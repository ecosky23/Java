import java.awt.Frame;
import java.awt.Button;

class ButtonTest2 extends Frame{
	private Button newB, exitB;

	public void init(){
		newB = new Button("새로만들기");// newB exitB 버튼 생성
		exitB = new Button("종료");	
		
		newB.setBounds(50,100,80,50);//이 크기로 버튼을 만들고
		exitB.setBounds(200,300,80,50);//버튼을 만들고
		this.add(newB);// 버튼을 화면에 붙인다.
		add(exitB);// 화면에 붙인다.
		setLayout(null);//레이아웃을 완전히 없애버리기 동서남북 위치를 없앤다
		setBounds(900,200,300,400); // 창의 위치와 크기	
		setVisible(true);
		}



	public static void main(String[] args) {
		ButtonTest2 bt = new ButtonTest2();
		bt.init();

		new ButtonTest2().init();//1. 클래스 만들어라 2.생성자만들어라 3. init만들어라  1회용
	}
}
