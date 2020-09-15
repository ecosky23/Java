import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class RGB extends Frame{
	
	private Button redBtn, greenBtn, blueBtn;

	private DrCanvas canvas;

	public RGB(){
		redBtn = new Button("����");
		greenBtn = new Button("�ʷ�");
		blueBtn = new Button("�Ķ�");
		
		canvas = new DrCanvas();
		
		Panel p = new Panel();
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);

		add("North", p);
		add("Center", canvas);

		setBounds(700,100,300,400);
		setVisible(true);
		//�̺�Ʈ
		this.addWindowListener(new WindowAdapter(){//������ ��ʹ� �߻�Ŭ����
			//Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		redBtn.addActionListener(new ActionListener(){//�������̽��� new�� �ȵȴ�. ��ȸ�����λ��
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.RED);
			}
		});
		greenBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.GREEN);
			}
		});
		blueBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				canvas.setBackground(Color.BLUE);
			}
		});
	}//RGB



	class DrCanvas extends Canvas{//���� Ŭ������ �����ؼ� Canvas ��� Canvas�� �ݵ�� ��ӹ޾ƾ��Ѵ�.
		public DrCanvas(){
			this.setBackground(new Color(255,255,200));
		}
	}


	public static void main(String[] args){
		new RGB();
	}
}
