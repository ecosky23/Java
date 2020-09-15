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
		label.setFont(new Font("���ü", Font.BOLD, 70));
		stB = new JButton("����");
		exitB = new JButton("����");
		

		label.setBounds(70,30,100,100);
		stB.setBounds(200,40,60,30);
		exitB.setBounds(200,80,60,30);

		add(label);
		add(stB);
		add(exitB);

		setTitle("Ÿ�̸�");
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stB.addActionListener(this);
		exitB.addActionListener(this);

	}//TimerTest()

		

	@Override
	public void run(){
		
		for(int i =1; i <=20; i++){
			label.setText(i+"");//setText���� ���ڿ��� �;ߵǼ� ���ڿ��� �ٲ��ش�. (new Integer(i).toString()); ���ڿ��� �ٲٴ� ���� ��
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
			t = null;//������ư ������ �ٽ� �ʱ�ȭ �ǰ� �����带 ���ش�
			bb = false;
			stB.setEnabled(true);//���α׷��� ���߰� ���۹�ư Ȱ��ȭ
			exitB.setEnabled(false);
		}
	}

	public static void main(String[] args){
		new TimerTest();
	}
}
