import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;


class ScoreForm extends JFrame implements ActionListener{
	private JLabel l1, l2, l3, l4, l5;
	private JTextField t1, t2, t3, t4, t5;
	private JButton iupB, outB, seaB, rankB, saveB, loadB;
	private ScoreImp imp;
	private ArrayList<ScoreDTO> list;
	private Vector<Object> vector;
	private DefaultTableModel model;
	private ScoreDTO dto;
	
	
	
	
	
	
//	private ArrayList<PersonDTO> list;
//	private Vector<String> vector;

	public ScoreForm(){
//-----------------------왼쪽 패널
		l1 = new JLabel("학번");
		l2 = new JLabel("이름");
		l3 = new JLabel("국어");
		l4 = new JLabel("영어");
		l5 = new JLabel("수학");
		
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		
		JPanel c1 = new JPanel();
		c1.add(l1);
		c1.add(t1);
		JPanel c2 = new JPanel();
		c2.add(l2);
		c2.add(t2);
		JPanel c3 = new JPanel();
		c3.add(l3);
		c3.add(t3);
		JPanel c4 = new JPanel();
		c4.add(l4);
		c4.add(t4);
		JPanel c5 = new JPanel();
		c5.add(l5);
		c5.add(t5);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5,1));

		left.add(c1);
		left.add(c2);
		left.add(c3);
		left.add(c4);
		left.add(c5);

		
	
//-----------------------------------------

//----------------------------------오른쪽 패널
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(1,1,1,1));
		String[] header = {"학번", "이름", "국어", "영어", "수학", "총점", "평균"};
		String[][] content = {};
		model = new DefaultTableModel(content, header);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		right.add(scroll);

		
//---------------------------------------

//----------------------------------아래쪽 패널
		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1,6,5,5));

		iupB = new JButton("입력");
		outB = new JButton("출력");
		seaB = new JButton("학번검색");
		rankB = new JButton("순위");
		saveB = new JButton("파일저장");
		loadB = new JButton("파일찾기");

		north.add(iupB);
		north.add(outB);
		north.add(seaB);
		north.add(rankB);
		north.add(saveB);
		north.add(loadB);


//----------------------------------센터 패널

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,2,5,5));
			center.add(left);
			center.add(right);

		Container c = this.getContentPane();
			c.add("North", center);
			c.add("South", north);


//------------------------------------------
		
		setBounds(200,200,600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	}//ScoreForm
	
	//-----------------------------------------------
	
		public void event(){

		iupB.addActionListener(this);
		outB.addActionListener(this);
		seaB.addActionListener(this);
	//	rankB.addActionListener(this);
	//	saveB.addActionListener(this);
	//	loadB.addActionListener(this);

	}//event

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == iupB){
				input();
				
			}else if(e.getSource() == outB){
				output();
			}else if(e.getSource() == seaB){
				search();
			}else if(e.getSource() == rankB){
				rank();
			}else if(e.getSource() == saveB){
				save();
			}else if(e.getSource() == loadB){
				load();
			}
		}

		public void input(){

		list = new ArrayList<ScoreDTO>();
		int hak = Integer.parseInt(t1.getText());
		String name = t2.getText();
		int kor = Integer.parseInt(t3.getText());
		int eng = Integer.parseInt(t4.getText());
		int math = Integer.parseInt(t5.getText());

		ScoreDTO dto = new ScoreDTO(hak, name, kor, eng, math);
		dto.calcTot();
		dto.calcAvg();
		list.add(dto);
		
		
	//	hak.setText("");
	//	name.setText("");
	//	kor.setText("");
	//	eng.setText("");
	//	math.setText("");
			
		}

	public void output(){
		//데이터
		
		for(ScoreDTO dto : list){
			Vector<Object> v = new Vector<Object>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor());
			v.add(dto.getEng());
			v.add(dto.getMath());
			v.add(dto.getTot());
			v.add(dto.getAvg());
				model.addRow(v);//행에 백터 내용 넣기
		}//for
	}
	
	public void search(){
		String sc = JOptionPane.showInputDialog("검색할 학번을 입력하세요");
			int sw = 0;
			for(int i = 0; i < list.size(); i++){
				if(Integer.parseInt(sc) == list.get(i).getsc()){
					model2.addRow(dto);
				}
			}
	}

		public void rank(){
		}
		
		public void save(){
		}

		public void load(){
		}
}
