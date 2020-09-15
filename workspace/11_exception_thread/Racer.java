import java.awt.*;
class Racer extends Canvas implements Runnable{
		private String name;
		private Image img;
		private int pos;
		private static int rank;
	
		public Racer(String name){//말의 이름이 들어옴
			this.name = name;
			img = Toolkit.getDefaultToolkit().getImage("horse.gif");
		}
		@Override
		public void paint(Graphics g){
				g.drawImage(img, pos, 0, 25,this.getSize().height,this);//x좌표, y좌표, 가로축 너비, 세로축 높이
				//this.getSize() 캔버스의 높이를 가져와라
		}

		@Override
		public void run(){
			for(int i = 0; i<=600; i+=((int)(Math.random()*10)+1)){//말의 움직임에 랜덤요소를 넣어줌
				pos=i;
				repaint();

				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}

			}//for
			rank++;//등수
			System.out.println(rank+"등 "+name);
		}
		

}
