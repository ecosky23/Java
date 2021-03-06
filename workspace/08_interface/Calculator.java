import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Label;
import java.awt.Panel;


class Calculator extends Frame implements KeyListener{
	String[] str = new String[]{"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+"}; 
		private Label dispL, inputL;// 라벨 2개
		private Button[] button; // 버튼 16개 
		private Button back, cancel;// 버튼 2개
		private TextArea area;
		public Calculator(){
			super("계산기");			
			
			setBackground(new Color(194,238,254));//배경색 선택
			
			Button[] button = new Button[16]; //배열로 버튼 16개만들고

			dispL = new Label();//라벨 2개 만들기
			inputL = new Label();
			area = new TextArea();//글씨쓰는거 말들기

			dispL.setBackground(new Color(255,255,255)); //라벨의 배경
			inputL.setBackground(new Color(255,255,255));


			back = new Button("←"); //버튼 2개에 글 입력
			cancel = new Button("C");
			
			Panel an = new Panel();		//전체 파넬 만들기
			an.setLayout(new GridLayout(7, 1, 5, 6)); // 파넬의 행과 열 옆의 사이즈 입력
			Panel p1 = new Panel();		
			p1.setLayout(new GridLayout(1, 4, 6, 5)); // 내부 파넬 7개 만들기
			Panel p2 = new Panel();		
			p2.setLayout(new GridLayout(1, 4, 6, 5));
			Panel p3 = new Panel();		
			p3.setLayout(new GridLayout(1, 4, 6, 5));
			Panel p4 = new Panel();		
			p4.setLayout(new GridLayout(1, 4, 6, 5));
			Panel la1 = new Panel();		
			la1.setLayout(new GridLayout(1, 1, 10, 10)); //라벨 파넬 입력
			Panel la2 = new Panel();		
			la2.setLayout(new GridLayout(1, 1, 10, 10));
			Panel c = new Panel();		
			c.setLayout(new GridLayout(1, 2, 5, 1)); //취소 파넬 입력

			for(int i = 0; i < button.length; i++){// 버튼에 글 입력
				button[i] = new Button(str[i]);
				if(i<=3){
						p1.add(button[i]); // 줄별로 입력
				}else if(i<=7){
						p2.add(button[i]);
				}else if(i<=11){
						p3.add(button[i]);
				}else if(i<=15){
						p4.add(button[i]);
				}
			}		
			
			la1.add(dispL);  //라벨을 라벨판넬에 입력
			la2.add(inputL);
			c.add(back);//라벨에 백스페이스 입력
			c.add(cancel);
			

			an.add(la1); //전체 판넬에 하나씩 입력
			an.add(la2);
			an.add(c);
			an.add(p1);
			an.add(p2);
			an.add(p3);
			an.add(p4);

			add(an);//전체 판넬을 입력

			setBounds(900,200,400,500);//계산기 크기설정
			setVisible(true);//계산기 모습보이게

			this.addWindowListener(new WindowExit());//계산기 x표누르면 꺼지게 만든다
			this.addKeyListener(this);// 키누른거 실해되게 하는거
		}
			
		public void paint(Graphics g){g.drawString(, );}

		public void	keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_0){
			}else if(e.getKeyCode() == KeyEvent.VK_1){
				repaint();
			}
			}//키 0을 누르면?
		public void	keyReleased(KeyEvent e){}
		public void	keyTyped(KeyEvent e){}



	public static void main(String[] args) {
			new Calculator();

	}
}
