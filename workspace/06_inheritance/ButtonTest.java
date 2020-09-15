import java.awt.Frame;
import java.awt.Button;
import java.awt.Panel;
import java.awt.GridLayout;
class ButtonTest extends Frame{
		private Button northB = null;
		private Button newB, exitB;
		
		
		public void init(){		
		northB = new Button("북쪽");  //원래 있던 Button클래스를 생성
		newB = new Button("새로만들기");
		exitB = new Button("종료");	
		
		Panel p = new Panel(); //FlowLayout 버튼이 겹칠때 안겹치게 배치시키기
		p.setLayout(new GridLayout(1, 2, 5, 0));  //(행, 열, 가로여백, 세로여백) 화면에 레이아웃을 통해 칸을나눠준다.
		p.add(newB);
		p.add(exitB);
		this.add("North", northB); // northB라는 버튼을 레이아웃을 통해 북쪽에 붙여주세요
			
			add("South", p);
		setBounds(900,200,300,400); // 창의 위치와 크기	
		setVisible(true);
		}

	public static void main(String[] args){
		ButtonTest bt = new ButtonTest(); //1. 생성자 만들고 2. 콜하고 3. init만들고
		bt.init();
	}
}
