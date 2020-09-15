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
		redBtn = new Button("빨강");
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		
		canvas = new DrCanvas();
		
		Panel p = new Panel();
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);

		add("North", p);
		add("Center", canvas);

		setBounds(700,100,300,400);
		setVisible(true);
		//이벤트
		this.addWindowListener(new WindowAdapter(){//윈도우 어뎁터는 추상클레스
			//Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		redBtn.addActionListener(new ActionListener(){//인터페이스라서 new가 안된다. 일회용으로사용
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



	class DrCanvas extends Canvas{//내부 클레스를 생성해서 Canvas 사용 Canvas는 반드시 상속받아야한다.
		public DrCanvas(){
			this.setBackground(new Color(255,255,200));
		}
	}


	public static void main(String[] args){
		new RGB();
	}
}
