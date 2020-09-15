import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;

class JTableEx2 extends JFrame implements ActionListener{
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn, delBtn;


	public JTableEx2(){
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong","홍길동","111","010-123-1234"));
		list.add(new PersonDTO("conan","코난","333","010-777-7777"));
	

		//타이틀
		vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰");

		model = new DefaultTableModel(vector, 0){//1을 넣어주면 빈칸이 하나생긴다
			public boolean isCellEditable(int r, int c){//편집가능하게 한다.
				return (c != 0) ? true : false;//아이디 수정불가능하게 한다.
			}	
		};//미리 몇행만들것인지 입력

		table = new JTable(model);//제이 테이블에 모델 넣기

		JScrollPane scroll = new JScrollPane(table);//JTable를 스크롤에 붙이기
		
		//데이터
		for(PersonDTO dto : list){
			Vector<String> v = new Vector<String>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());

			model.addRow(v);//행에 백터 내용 넣기
		}//for

		//버튼 추가
		addBtn = new JButton("추가");
		delBtn = new JButton("삭제");		

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);

		Container c = getContentPane();
		c.add("Center", scroll);
		c.add("South", p);

		setBounds(700,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == addBtn){
			insert();
		}else if(e.getSource() == delBtn){
			delete();
		}
	}

	public void insert(){		
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");//누르면 창뜨게 하는것
		if( id == null || id.length()==0){
			JOptionPane.showMessageDialog(this, "아이디는 필수 입력사항입니다.");
			return;
		}

		for(int i =0; i<model.getRowCount(); i++){//테이블의 행의수
			if(id.equals(model.getValueAt(i,0))){//getValueAt실제 데이터 추출 함수
				JOptionPane.showMessageDialog(this, "사용중인 아이디 입니다.");
					return;
			}
		}

		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		String pwd = JOptionPane.showInputDialog(this, "패스워드를 입력하세요");
		String tel = JOptionPane.showInputDialog(this, "전화번호를 입력하세요");
		
		Vector<String> v = new Vector<String>();//백터 생성
			v.add(id);//백터에 정보입력
			v.add(name);
			v.add(pwd);
			v.add(tel);

			model.addRow(v);//addRow줄생성 하고 model에 입력 하기
		}

		public void delete(){
			int sw = 0;
			String id = JOptionPane.showInputDialog(this, "삭제할 아이디를 입력하세요");
			for(int i =0; i<model.getRowCount(); i++){//테이블의 행의수
			if(id.equals(model.getValueAt(i,0))){//getValueAt실제 데이터 추출 함수
				model.removeRow(i);
					i--;
					sw=1;
			}
			}//for	

			if(sw==0){
				JOptionPane.showMessageDialog(this, "삭제할 이름이 없습니다.");
			}


		}//delete()
		
	public static void main(String[] args){
		new JTableEx2();
	}
}
//아이디를 입력하지 않으면 그냥 나가세요
//아이디가 중복되면 "사용중인 아이디 입니다." 
//JOptionPane.showMessageDialog(this, "사용중인아이디입니다.')를 띄우고 나가세요
//이름 입력, 비밀번호 입력, 핸드폰 입력, 테이블에 추가