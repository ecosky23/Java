import java.awt.event.*;
import java.awt.*;


//JDK11 버전 에서는HTML5(<font>태그 가 없다) 그래서 <span>으로 사용해야 한다.   

/** 
api문서에 주석이 뜨려면 /*안된다 /**이렇게 해야한다.
<font style="color: red; font-size: 20pt;">   속성(attribute)
이미지를 이동하는 클래스
</font>        
 열어주면 반드시 닫아야한다.
*/

class ImageMove extends Frame implements WindowListener, ActionListener, KeyListener{
	private Button newButton, leftButton, upButton, downButton, rightButton;
	
/** 
<font style="color: red; font-size: 20pt;">   
	x와 y는 이미지의 시작위치
</font>        
*/
	int x = 200;
	int y = 200;

/** 
<font style="color: red; font-size: 20pt;">   
	버튼 생성하고 Frame 크기 설정
</font>        
*/

	public void init(){
		
		newButton = new Button("new");//버튼 생성
		leftButton = new Button("←");
		upButton = new Button("↑");
		downButton = new Button("↓");
		rightButton = new Button("→");

		
		Panel p = new Panel();//패널생성
		
			p.add(newButton);//판넬에 버튼 붙이기
			p.add(leftButton);
			p.add(upButton);
			p.add(downButton);
			p.add(rightButton);
			
				add("North",p);//프레임에 판넬 붙이기
		
		setBounds(700,100,500,500);
		setVisible(true);

	/*	newButton.setFocusable(false);//포커스를 없애주는 명령어
		leftButton.setFocusable(false);  버튼 안에 2개의 기능이 존재
		rightButton.setFocusable(false);	포커스어블을 해주면 하나의 기능을 삭제해서
		upButton.setFocusable(false);	키보드가 작동안하게 된다.
		downButton.setFocusable(false);
	*/
		setResizable(false);//프레임 고정

		addWindowListener(this);//어디서실행.윈도우리스너실행(실행하는 것을 누가가지고 있나?)
		
		newButton.addActionListener(this);//실행되는 버튼.실행부(실행하는 것의 위치)
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		upButton.addActionListener(this);
		downButton.addActionListener(this);
	
		newButton.addKeyListener(this);
		leftButton.addKeyListener(this);
		rightButton.addKeyListener(this);
		upButton.addKeyListener(this);
		downButton.addKeyListener(this);
	
	}
	@Override//ActionListener 는 하나밖에 없다.
	public void actionPerformed(ActionEvent e){//마우스 클릭을 통해서 움직임 생성
		//ex) = if(e.getSource() == newButton){ 아래와 같은식
		
		if(e.getActionCommand() == "new"){  
			this.x = 200;
			this.y = 200;
		}else if(e.getActionCommand() == "←"){ 
			if(x<-50)x=450;
			this.x -= 10;
		}else if(e.getActionCommand() == "↑"){
			if(y<-50)y=450;
			this.y -= 10;
		}else if(e.getActionCommand() == "↓"){
			if(y>450)y=-50;
			this.y += 10;
		}else if(e.getActionCommand() == "→"){
			if(x>450)x=-50;
			this.x += 10;
		}
				repaint();
	}

	@Override//keyListener Override

	public void	keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){//키보드를 통해서 움직임생성
				System.exit(0);					//아스키코드 27
			}else if(e.getKeyCode() == KeyEvent.VK_UP){	//아스키코드 38
					if(y<-50) y=450;
						this.y -= 10;		
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){//아스키코드 40
					if(y>450) y=-50;
						this.y += 10;	
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){//아스키코드 37
					if(x<-50)x=450;
						this.x -= 10;
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){//아스키코드 39
					if(x>450) x=-50;
						this.x += 10;
			}
			repaint();
	}
		
	public void	keyReleased(KeyEvent e){}
	public void	keyTyped(KeyEvent e){}


	@Override
	public void paint(Graphics g){// 그림불러오기 repaint() 하면 이 메소드를 다시 호출하는것
		Toolkit t = Toolkit.getDefaultToolkit();
		
		Image img= t.getImage("D:/java_se/workspace/08_interface/chi.jpg");
	//	Image img = Toolkit.getDefaultToolkit().getImage("chi.jpg"); 위의것들을 합친것 같은값
			g.drawImage(img, this.x, this.y, 100, 100, this);
	}	

	@Override
	public void windowActivated(WindowEvent e){}//활성화
	public void windowClosed(WindowEvent e){}//x를 누르고 사후처리
	public void windowClosing(WindowEvent e){System.exit(0);}//x를 누르는 순간
	public void windowDeactivated(WindowEvent e){}//비활성화
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}


	public static void main(String[] args) {
		new ImageMove().init();
	}
}
/*
제목 이미지 이동 1시 방향에 X실행되게 만들기
창 크기 고정 500, 500으로 - 인터넷 에서 찾기 
위쪽에 버튼 5개 newButton leftButton upButton downButton rightButton
버튼에 화살표 넣기 newButton은 이미지가 처음지점으로 오게하기
이미지 하나올리기 가운데 정도 작게 이미지 위치 처음 100, 100
버튼을 누르면 버튼 하나당 위치이동 10 
버튼이 왼쪽으로 쭉가서 사라지면 다시 오른쪽으로 나오게 하기
키보드 이벤트 발생 화살표 누르면 움직이게

*/