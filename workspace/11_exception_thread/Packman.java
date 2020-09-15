import java.awt.*;
import java.awt.event.*;

class Packman extends Frame implements Runnable, KeyListener{
	private Image img, img2;
	private int sel = 2;
	private boolean u, d, r, l;
	int x = 225;
	int y = 225;
	
	int[] foodX = new int[5];
	int[] foodY = new int[5];
	
	public Packman(){
		setBounds(700,200,500,500);
		setVisible(true);
		setResizable(false);
		
		for(int i = 0; i < foodX.length; i++){
		foodX[i] = (int)(Math.random()*450)+1;
		foodY[i] = (int)(Math.random()*450)+1;
		}
			this.addWindowListener(new WindowAdapter(){//윈도우 어뎁터는 추상클레스
			//Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			});

			addKeyListener(this);
			
			
			Thread t = new Thread(this); //스레드 생성
				t.start();

	}//Packman()
	@Override
	public void paint(Graphics g){
		img = Toolkit.getDefaultToolkit().getImage("pacman.png");
		
		g.drawImage(img,				
					x, y, x+50, y+50,//화면위치 
					sel*50, 0, sel*50+50, 50,	//이미지 위치
					this);

		img2 = Toolkit.getDefaultToolkit().getImage("lion.png");
		for(int i = 0; i < 5; i++){
		g.drawImage(img2, foodX[i], foodY[i], 20, 20,this);

		}
	}
	
	/*@Override
	public void paint(Graphics g){
		img = Toolkit.getDefaultToolkit().getImage("lion.png");
		
		g.drawImage(img,				
					20, 20, 50, 50,//화면위치 
					150, 0, 50, 50,	//이미지 위치
					this);
	}*/

	@Override
	public void run(){
			while(true){
				if(sel%2==0)sel++;
				else sel--;
				if(u)y-=10; if(y<0) y=490;
					
				else if(d) y+=10; if(y>490) y=0;
				else if(r) x+=10; if(x>490) x=0;
				else if(l) x-=10; if(x<0) x=490;
				
				repaint();
				
				try{
				Thread.sleep(200);//기본 1000분의 1초로 실행 그래서 딜레이 걸어준다 느리게해준다
				}catch(InterruptedException e){
					e.printStackTrace();
				}

				for(int i = 0; i < 5; i++){
					if((x+25) >= foodX[i]-10 && (y+25)>= foodY[i]-10 
						&& (x+25) <= foodX[i] +20 && (y+25)<=foodY[i]+20){
								foodX[i] = 0;
								foodY[i] = 0;
					}
				}


			}
		}

	@Override//keyListener Override
		
	public void	keyPressed(KeyEvent e){
			 if(e.getKeyCode() == KeyEvent.VK_UP){	//아스키코드 38
					//if(y<-50) y=225;
						this.y -= 10;
						sel =4;
				u=true; d=false; r=false; l=false;	
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){//아스키코드 40
				//	if(y>450) y=225;
						this.y += 10;
						sel =6;
				u=false; d=true; r=false; l=false;	
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){//아스키코드 37
				//	if(x<-50)x=225;
						this.x -= 10;
						sel=1;
				u=false; d=false; r=false; l=true;	
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){//아스키코드 39
				//	if(x>450) x=225;
						this.x += 10;
						sel=2;
				u=false; d=false; r=true; l=false;	
			}
			repaint();	
	}
	
		
	public void	keyReleased(KeyEvent e){}
	public void	keyTyped(KeyEvent e){}
		
	public static void main(String[] args) {
		new Packman();
	}
}
//먹이 이미지 (20,20)크기
//food 먹히면 먹이의 위치를 0,0으로해서 사라지게 repaint하기