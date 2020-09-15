import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class TimerTest extends JFrame implements Runnable, ActionListener{
	private JButton stB, exitB;
	private JLabel label;
	private boolean bb = true;
	private static int ii;
	
	public TimerTest(){
		]

		setLayout(null);

		label = new JLabel("0");
		label.setFont(new Font("고딕체", Font.BOLD, 70));
		stB = new JButton("시작");
		exitB = new JButton("종료");
		

		label.setBounds(70,30,100,100);
		stB.setBounds(200,40,60,30);
		exitB.setBounds(200,80,60,30);

		add(label);
		add(stB);
		add(exitB);

		setTitle("타이머");
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stB.addActionListener(this);
		exitB.addActionListener(this);

	}//TimerTest()

		

	@Override
	public void run(){
		
		for(int i =1; i <=20; i++){
			label.setText(i+"");//setText에는 문자열만 와야되서 문자열로 바꿔준다. (new Integer(i).toString()); 문자열로 바꾸는 같은 식
			if(!bb)break;
			try{
			Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//for
			stB.setEnabled(true);
			exitB.setEnabled(false);

	}


	public void actionPerformed(ActionEvent e){
		Thread t;
		if(e.getSource() == stB){
			 
			t = new Thread(this);
				t.start();
			bb = true;
			stB.setEnabled(false);
			exitB.setEnabled(true);
		}
		else if(e.getSource() == exitB){
			t = null;//정지버튼 누르면 다시 초기화 되게 스레드를 없앤다
			bb = false;
			stB.setEnabled(true);//프로그램이 멈추고 시작버튼 활성화
			exitB.setEnabled(false);
		}
	}

	public static void main(String[] args){
		new TimerTest();
	}
}
