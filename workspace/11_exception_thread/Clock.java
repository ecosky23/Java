import java.awt.Button;
import java.util.Date;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
class Clock extends Frame{
		private Button cloBtn;

	public Clock(){
		
		Date date = new Date();

		setBounds(700,200,300,100);
		setVisible(true);
		
			addWindowListener(new WindowAdapter(){//윈도우 어뎁터는 추상클레스
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		SimpleDateFormat adf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("오늘 날짜 : "+ adf.format(date));//adf형식으로 날짜를 찍어라
		System.out.println();
		
		cloBtn = new Button(adf.format(date));

		Panel p = new Panel();
		p.add(cloBtn);
		add(p);
		
	}

	public static void main(String[] args){
		new Clock();
	}
}
