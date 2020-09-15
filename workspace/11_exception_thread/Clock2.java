import java.util.Date;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Clock2 extends Frame implements Runnable{
		
		Date date = new Date();//���� ��¥�� �ð�

	public Clock2(){
		this.setForeground(Color.RED);
		setFont(new Font("Consolas", Font.BOLD, 30));
		setBounds(700,200,300,200);
		setVisible(true);
		
			addWindowListener(new WindowAdapter(){//������ ��ʹ� �߻�Ŭ����
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			});
			
			Thread t = new Thread(this); //������ ����
				t.start();//������ ���� ���۰� ���ÿ� run�޼ҵ�� �̵�
	}//clock()
	
	@Override
	public void paint(Graphics g){
		SimpleDateFormat adf = new SimpleDateFormat("HH:mm:ss");
			g.drawString(adf.format(new Date()), 80, 110);//���ڿ��� ��ȯ������� 
		
	}

	@Override
		public void run(){// start���� �ͼ� �ٽ� 0.2���� start�޼ҵ�� �̵� paint �ϰ� ��� �ݺ�
			while(true){
				repaint();
				try{
				Thread.sleep(1000);//�⺻ 1000���� 1�ʷ� ���� �׷��� ������ �ɾ��ش� ���������ش�
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}//while
		}

		

	public static void main(String[] args){
		new Clock2();
	}
}