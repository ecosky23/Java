import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

class Racer extends Canvas implements Runnable { //�� 1����
	private String name;
	private Image img;
	private int pos;
	private static int rank;

	public Racer(String name){
		this.name = name;
		img = Toolkit.getDefaultToolkit().getImage("horse.gif");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, pos, 0, 25, this.getSize().height, this);//x��ǥ, y��ǥ, �ʺ�, ����
	}
	
	@Override
	public void run(){
		for(int i=0; i<=600; i+=((int)(Math.random()*10)+1)){
			pos=i;
			repaint();

			try{
				Thread.sleep(100); //�⺻���� 1/1000
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//for
		
		//���
		rank++;
		System.out.println(rank+"��   "+name);
	}
}
