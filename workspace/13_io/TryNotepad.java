import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedWriter;

class TryNotepad extends JFrame implements ActionListener{
	private JTextArea output; 	
	private JScrollPane sc;
	private MenuPane menu;
	private File file;
	
	public TryNotepad(){

		Container c = getContentPane();
		output = new JTextArea();
		sc = new JScrollPane(output);
		sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//오른쪽에 스크롤생겨서 나오게
		
		menu = new MenuPane();
		setJMenuBar(menu);

		c.add(sc);

		setBounds(700,100,700,500);
		setVisible(true);
		setTitle("간단메모장");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int result = JOptionPane.showConfirmDialog(TryNotepad.this,//메시지 띄울위치
										 "파일을 저장하시겠습니까?",//메세지
										"종료",//제목
										JOptionPane.YES_NO_CANCEL_OPTION,//선택메뉴
										JOptionPane.QUESTION_MESSAGE);//이미지
			 if(result == JOptionPane.YES_OPTION){//저장하고 종료
				saveDialog();//저장 다이얼로그
				fileWrite();//파일 읽기
				System.exit(0);
			 }else if(result == JOptionPane.NO_OPTION){//저장 안하고 종료
				System.exit(0);
			 }
			}
		});
	
	}
	
	public void event(){
		menu.getExitM().addActionListener(this);
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){

		if(e.getSource() == menu.getExitM()){
			 int result = JOptionPane.showConfirmDialog(this,
										 "파일을 저장하시겠습니까?",
										"종료",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE);
			 if(result == JOptionPane.YES_OPTION){//저장하고 종료
				saveDialog();//저장 다이얼로그
				fileWrite();//파일 읽기
				System.exit(0);
			 }else if(result == JOptionPane.NO_OPTION){//저장 안하고 종료
				System.exit(0);
			 }


		}else if(e.getSource() == menu.getNewM()){
			output.setText("");
		}else if(e.getSource() == menu.getOpenM()){
			openDialog();//열기 다이얼로그
			fileRead();//파일 읽기
		}else if(e.getSource() == menu.getSaveM()){
			saveDialog();//저장 다이얼로그
			fileWrite();//파일 읽기
		}else if(e.getSource() == menu.getCutM()){
			output.cut();
		}else if(e.getSource() == menu.getCopyM()){
			output.copy();
		}else if(e.getSource() == menu.getPasteM()){
			output.paste();
		}
	}

	public void openDialog(){//메뉴바에 열기파일을 누르면 열기메뉴가 켜진다.
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);

		if(result == JFileChooser.APPROVE_OPTION){
			 file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);//파일의 위치를 메시지로 나타내준다.
	}
	public void fileRead(){
		if(file==null) return;
		output.setText("");
		try{
		BufferedReader br = new BufferedReader(new FileReader(file));//선택한 파일 가져오기
		String line;

		while((line = br.readLine())!=null){//파일안의 내용의 한줄 읽기(엔터치기 전까지가 한줄이다.)
			//output.setText(line); - 덮어쓰기
			output.append(line+"\n");
		}//while    한줄씩읽어서 마지막 줄이 null이된다.
		br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public void saveDialog(){//파일 저장하기
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);//오픈 다이얼로그에서 세이브로 바꿔주기만 하면된다.

		if(result == JFileChooser.APPROVE_OPTION){
			 file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);
		
	}

	public void fileWrite(){//불러오기, 열기
		if(file==null) return;
		try{
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String data = output.getText();
		bw.write(data);
		bw.close();
	}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new TryNotepad().event();
	}
}
/*
1. 종료 다이얼로그(x, 메뉴 - 종료)
"파일을 저장하시겠습니까?" - 예, 아니오, 취소

2.MenuPane.java
단축키 - 잘라내기 ALT + X
		복사 ALT + C
		붙여넣기 ALT + v

3.처음 실행을 해서 열기 다이얼로그 - 취소(error)
에러 뜨는거 안뜨게 하기
*/