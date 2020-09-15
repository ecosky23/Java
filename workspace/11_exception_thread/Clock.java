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
		
			addWindowListener(new WindowAdapter(){//������ ��ʹ� �߻�Ŭ����
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		SimpleDateFormat adf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("���� ��¥ : "+ adf.format(date));//adf�������� ��¥�� ����
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
