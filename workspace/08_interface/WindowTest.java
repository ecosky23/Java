import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;


//event source - ����? ���?
//event listener
//event handler(������)
//Source.addListener(Handler�� ��ġ)

class WindowTest extends Frame implements MouseListener, MouseMotionListener, KeyListener{
	private int x, y;

	public void init(){
		setBounds(900,100,300,400);
		setVisible(true);//1

		//�̺�Ʈ
		this.addMouseListener(this);// �������� this�� �ٷ� �ؿ� ������
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.addWindowListener(new WindowExit());//�����δ� windowexitŬ������ ������ �ִ�.
	}//init()

	public void paint(Graphics g){g.drawString("X: "+x+" Y:"+y, x, y);}//ȭ�鿡 0 0 ����
		//2. setvisible���� ȭ���� �����  ������ �̰��� ���� x y 00��

	//MouseListener Override �߻�ȭ�� �����ִ°��� �������̽��� �����ͼ� ���⼭ ����
public void	mouseClicked(MouseEvent e){
	x=e.getX();
	y=e.getY();
	System.out.println("���콺 Ŭ��!!");
	System.out.println("X: "+x+" Y:"+y);//x y��ǥ�� �˰����ش�.
	repaint();//3.update() - paint() x:0 y:0 ������ ���� repaint ���༭ ȭ�鿡 ��ǥ�� ���´�.
	}
public void	mouseEntered(MouseEvent e){System.out.println("���콺 IN!!");}
public void	mouseExited(MouseEvent e){System.out.println("���콺 OUT!!");}
public void	mousePressed(MouseEvent e){}
public void	mouseReleased(MouseEvent e){}

//MouseMotionListener Override
public void	mouseDragged(MouseEvent e){System.out.println("���콺 �巡��!!");}
public void	mouseMoved(MouseEvent e){}
//KeyListener Override �߻�޼ҵ�
public void	keyPressed(KeyEvent e){
	if(e.getKeyCode() == KeyEvent.VK_ESCAPE){//���� Ű�� VK_ESCAPE(esc)�ΰ� ����°� ������ ����
		System.exit(0);//���α׷� ��������/ KeyEvent.VK_ESCAPE��� �ƽ�Ű �ڵ尪�� 27�� �־ �ȴ�.
	}
}
public void	keyReleased(KeyEvent e){}
public void	keyTyped(KeyEvent e){}



	public static void main(String[] args) {
		new WindowTest().init();
	}
}
