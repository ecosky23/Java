import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ThreadOnOff extends JFrame implements Runnable{
	private JButton btn;
	private boolean bb = true;
	private static int ii;

	public ThreadOnOff(){
		btn = new JButton("������");

		

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);

		add("South", p);
		setSize(300,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x������ ������

		btn.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){	
				bb=true;
				new Thread(ThreadOnOff.this).start();//�ۿ��ִ� ThreadOnOffŬ������ ������� �����
			}
			@Override
			public void mouseReleased(MouseEvent e){		
				bb=false;
			}
		});
	}//ThreadOnOff()

	@Override
	public void run(){
		int i = ii; 
			
		while(true){
			i++;
			if(!bb)break;
			try{
			Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("i= "+i);
			ii = i;
			if(i>=50) i = 0;
		}//while
	}

	public static void main(String[] args){
		 new ThreadOnOff();	
	}
}
