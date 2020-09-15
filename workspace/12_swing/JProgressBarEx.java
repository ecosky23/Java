import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
class JProgressBarEx extends JFrame implements ActionListener, Runnable{
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL,0,100);//������ Ÿ�԰� �ּҰ�, �ִ밪
	private JButton jbt = new JButton("����");
	private JButton jbt1 = new JButton("����");

	public JProgressBarEx(){
		super("Test");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("�̰��� ���α׷��� �ٴ�..."));//��������
		con.add("Center", jpb);// ���α׷��� �ٿ��ֱ�
		jpb.setStringPainted(true);
		jpb.setString("0%");//����ٿ� ��Ÿ���� ����
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));//����������
		jp.add(jbt);//��ư �ٿ��ֱ�
		jp.add(jbt1);

		jbt.addActionListener(this);//��ư ���� �ϴ� ������
		jbt1.addActionListener(this);

		con.add("South", jp);//�г��� �ܿ� �ٿ��ֱ� 
		setSize(300,150);
		setVisible(true);
	}

	private boolean bb = true;
	private static int ii;
	public void run(){
		if(ii == 100) ii = 0;
		for(int i = ii; i<= 100; i++){
			if(!bb) break;// bb�� false�� �Ǹ� �����
			try{
				Thread.sleep(50);// 50��ŭ ������
			}catch(InterruptedException ee){}
			jpb.setValue(i);//������� ���簪�� ����
			ii = i;
			jpb.setString(i + "%");//����ٿ� ���� ������ ���ڰ� ��%���� ȭ�鿡 ��Ÿ��
		}
		jbt.setEnabled(true);//���۹�ư Ȱ��ȭ
		jbt1.setEnabled(false);//���۹�ư ��Ȱ��ȭ
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == jbt){
			bb = true; new Thread(this).start();
			jbt.setEnabled(false);//���α׷��� ����ǰ� ���۹�ư ��Ȱ��ȭ
			jbt1.setEnabled(true);//�����ư Ȱ��ȭ
		}
		else if(e.getSource() == jbt1){
			bb = false;
			jbt.setEnabled(true);//���α׷��� ���߰� ���۹�ư Ȱ��ȭ
			jbt1.setEnabled(false);//���α׷��� ���߰� �����ư ��Ȱ��ȭ
		}
	}

	public static void main(String[] args){
		new JProgressBarEx();
	}
}
