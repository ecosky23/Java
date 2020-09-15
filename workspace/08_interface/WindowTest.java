import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;


//event source - 누가? 어디서?
//event listener
//event handler(구현부)
//Source.addListener(Handler의 위치)

class WindowTest extends Frame implements MouseListener, MouseMotionListener, KeyListener{
	private int x, y;

	public void init(){
		setBounds(900,100,300,400);
		setVisible(true);//1

		//이벤트
		this.addMouseListener(this);// 구현부인 this는 바로 밑에 존재함
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addWindowListener(new WindowExit());//구현부는 windowexit클래스가 가지고 있다.
	}//init()

	public void paint(Graphics g){g.drawString("X: "+x+" Y:"+y, x, y);}//화면에 0 0 나옴
		//2. setvisible에서 화면을 만들고  다음에 이것이 실행 x y 00됨

	//MouseListener Override 추상화로 남아있는것을 인터페이스로 가져와서 여기서 실행
public void	mouseClicked(MouseEvent e){
	x=e.getX();
	y=e.getY();
	System.out.println("마우스 클릭!!");
	System.out.println("X: "+x+" Y:"+y);//x y좌표를 알게해준다.
	repaint();//3.update() - paint() x:0 y:0 나오는 것을 repaint 해줘서 화면에 좌표가 나온다.
	}
public void	mouseEntered(MouseEvent e){System.out.println("마우스 IN!!");}
public void	mouseExited(MouseEvent e){System.out.println("마우스 OUT!!");}
public void	mousePressed(MouseEvent e){}
public void	mouseReleased(MouseEvent e){}

//MouseMotionListener Override
public void	mouseDragged(MouseEvent e){System.out.println("마우스 드래그!!");}
public void	mouseMoved(MouseEvent e){}
//KeyListener Override 추상메소드
public void	keyPressed(KeyEvent e){
	if(e.getKeyCode() == KeyEvent.VK_ESCAPE){//눌른 키가 VK_ESCAPE(esc)인가 물어보는것 맞으면 종료
		System.exit(0);//프로그램 강제종료/ KeyEvent.VK_ESCAPE대신 아스키 코드값인 27을 넣어도 된다.
	}
}
public void	keyReleased(KeyEvent e){}
public void	keyTyped(KeyEvent e){}



	public static void main(String[] args) {
		new WindowTest().init();
	}
}
