import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
class WindowTest extends Frame{	//기본생성자
	public WindowTest(){
		//new Frame("내가만든 윈도우").setVisible(true); 새거에 제목넣기
		super("내가만든 윈도우");//부모 생성자 호출해서 windowtest에 제목 넣기

		System.out.println("도형");//cmd안에 글자가 나온다.
		setForeground(new Color(255,255,0));//글자색
		setBackground(new Color(235,31,189));//바탕색
		
		//setBackground(Color.PINK); 배경 색깔
		setBounds(900,200,300,400); // 창의 위치와 크기
		//setSize(300,400);// 창의 크기
		setVisible(true);
	}
	@Override// 자식클래스에서 실행되게 하기위해서
		public void paint(Graphics g){//구현부 - 생성자 바깥에 위치해 있어도 call back 메소드 이기 때문에 자바가상머신이 자동으로 실행//Frame안에 그려준다.
			g.drawString("도형",100,80); //그림형식으로 글자를 넣어준다 숫자는 위치
			g.drawLine(200,150,100,200); // 줄을 그려준다 숫자는 위치
			g.drawRect(200,150,100,200); //x좌표, y좌표, 너비, 높이 사각형 그리기
			g.drawOval(200,150,100,200);//원그리기 x좌표, y좌표, 너비, 높이
	}

	public static void main(String[] args) {
		new WindowTest();
				

	}
}
//235, 31,189