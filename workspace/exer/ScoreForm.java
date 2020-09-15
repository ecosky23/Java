import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;  //와일드 카드 - 모든 것
import javax.swing.table.*;

class ScoreForm extends JFrame implements ActionListener {
	private final static int TABLE_COLUMN = 5;

	private JButton inputBtn, outputBtn, searchBtn, rankBtn, saveBtn, openBtn;
	private JTextField[] jtf = new JTextField[TABLE_COLUMN];
	private DefaultTableModel model;
	private JTable table;
	private Score score;

	public ScoreForm() {
		super("학생 테이블");

		//Button
		inputBtn = new JButton("입력");
		outputBtn = new JButton("출력");
		searchBtn = new JButton("학번검색");
		rankBtn = new JButton("순위");
		saveBtn = new JButton("파일저장");
		openBtn = new JButton("파일읽기");

		//TextField & Label
		JPanel[] p = new JPanel[TABLE_COLUMN];//배열 생성
		JPanel pl = new JPanel();
		pl.setLayout(new GridLayout(5,1,5,5));
		JLabel[] jl = new JLabel[TABLE_COLUMN];//배열 생성
		String[] title = {"학번","이름","국어","영어","수학"};
		for (int i=0; i<TABLE_COLUMN; i++) {
			jl[i] = new JLabel(title[i]);
			jtf[i] = new JTextField(20);
			
			p[i] = new JPanel();
			p[i].add(jl[i]);
			p[i].add(jtf[i]);

			pl.add(p[i]);
		}//for

		//Table
		Vector<String> v = new Vector<String>();
		v.add("학번");
		v.add("이름");
		v.add("국어");
		v.add("영어");
		v.add("수학");
		v.add("총점");
		v.add("평균");
		model = new DefaultTableModel(v,0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane();
		scroll = new JScrollPane(table);

		score = new ScoreImpl();//score 객체 생성
		
		//South
		JPanel pd = new JPanel();
		pd.setLayout(new GridLayout(1,5,5,5));
		pd.add(inputBtn);
		pd.add(outputBtn);
		pd.add(searchBtn);
		pd.add(rankBtn);
		pd.add(saveBtn);
		pd.add(openBtn);
		
		//Center
		JPanel pc = new JPanel();
		pc.setLayout(new GridLayout(1,2));
		pc.add(pl);
		pc.add(scroll);

		Container c = getContentPane();
		c.add("Center", pc);
		c.add("South", pd);

		setSize(600,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//프레임 위치 가운데로 설정
	}//ScoreForm()

	public void event(){
		inputBtn.addActionListener(this);
		outputBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputBtn){
			//데이터
			ScoreDTO dto = new ScoreDTO();
			dto.setHak(jtf[0].getText());
			dto.setName(jtf[1].getText());
			dto.setKor(Integer.parseInt(jtf[2].getText()));
			dto.setEng(Integer.parseInt(jtf[3].getText()));
			dto.setMath(Integer.parseInt(jtf[4].getText()));

			dto.calc();

			score.input(dto);

			JOptionPane.showMessageDialog(this, "등록완료!!");//리스트에 등록하고 메시지 띄우기
															//(위치,"메시지")	

			//초기화
			for(int i=0; i<jtf.length; i++){
				jtf[i].setText("");
			}

		}else if(e.getSource() == outputBtn) {
			score.output(model);
		}else if(e.getSource() == searchBtn) {
			String hak = JOptionPane.showInputDialog(this, "학번을 입력하세요");
			if(hak==null || hak.equals("")) return;//학번에 아무것도 입력되지 않으면 돌아가기

			int sw = score.search(model, hak);//학번도 같이 scoreimp로 넘기고 scoreimp에서 score로 같이 넘겨줘야한다.
												//sw로 넣어줘야지 찾는 학번이 없을때 메시지를 띄운다.

			if(sw==0) 
				JOptionPane.showInputDialog(this, "찾는 학번이 없습니다");

		}else if(e.getSource() == rankBtn) {
			score.to_desc(); //총점으로 내림차순
			score.output(model);

		}else if(e.getSource() == saveBtn) {//ScoreDTO로 못보내서 객체직렬화 -> byte[]변환
			score.save();

		}else if(e.getSource() == openBtn) {
			score.load();
			score.output(model);//세이브와 다르게 로드는 불러와서 다시 뿌려줘야지 보인다.
		}
	}
}
