import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
class JProgressBarEx extends JFrame implements ActionListener, Runnable{
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL,0,100);//데이터 타입과 최소값, 최대값
	private JButton jbt = new JButton("시작");
	private JButton jbt1 = new JButton("멈춤");

	public JProgressBarEx(){
		super("Test");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("이것이 프로그레스 바당..."));//제목같은것
		con.add("Center", jpb);// 프로그레스 붙여주기
		jpb.setStringPainted(true);
		jpb.setString("0%");//진행바에 나타나는 문자
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));//오른쪽정렬
		jp.add(jbt);//버튼 붙여주기
		jp.add(jbt1);

		jbt.addActionListener(this);//버튼 동작 하는 리스너
		jbt1.addActionListener(this);

		con.add("South", jp);//패널을 콘에 붙여주기 
		setSize(300,150);
		setVisible(true);
	}

	private boolean bb = true;
	private static int ii;
	public void run(){
		if(ii == 100) ii = 0;
		for(int i = ii; i<= 100; i++){
			if(!bb) break;// bb가 false가 되면 멈춘다
			try{
				Thread.sleep(50);// 50만큼 느리게
			}catch(InterruptedException ee){}
			jpb.setValue(i);//진행바의 현재값을 지정
			ii = i;
			jpb.setString(i + "%");//진행바와 같이 보열줄 문자값 몇%인지 화면에 나타냄
		}
		jbt.setEnabled(true);//시작버튼 활성화
		jbt1.setEnabled(false);//시작버튼 비활성화
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == jbt){
			bb = true; new Thread(this).start();
			jbt.setEnabled(false);//프로그램이 실행되고 시작버튼 비활성화
			jbt1.setEnabled(true);//멈춤버튼 활성화
		}
		else if(e.getSource() == jbt1){
			bb = false;
			jbt.setEnabled(true);//프로그램이 멈추고 시작버튼 활성화
			jbt1.setEnabled(false);//프로그램이 멈추고 멈춤버튼 비활성화
		}
	}

	public static void main(String[] args){
		new JProgressBarEx();
	}
}
