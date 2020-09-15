import java.util.Date;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Clock2 extends Frame implements Runnable{
		
		Date date = new Date();//오늘 날짜와 시간

	public Clock2(){
		this.setForeground(Color.RED);
		setFont(new Font("Consolas", Font.BOLD, 30));
		setBounds(700,200,300,200);
		setVisible(true);
		
			addWindowListener(new WindowAdapter(){//윈도우 어뎁터는 추상클레스
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			});
			
			Thread t = new Thread(this); //스레드 생성
				t.start();//스레드 시작 시작과 동시에 run메소드로 이동
	}//clock()
	
	@Override
	public void paint(Graphics g){
		SimpleDateFormat adf = new SimpleDateFormat("HH:mm:ss");
			g.drawString(adf.format(new Date()), 80, 110);//문자열로 변환해줘야함 
		
	}

	@Override
		public void run(){// start에서 와서 다시 0.2초후 start메소드로 이동 paint 하고 계속 반복
			while(true){
				repaint();
				try{
				Thread.sleep(1000);//기본 1000분의 1초로 실행 그래서 딜레이 걸어준다 느리게해준다
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}//while
		}

		

	public static void main(String[] args){
		new Clock2();
	}
}