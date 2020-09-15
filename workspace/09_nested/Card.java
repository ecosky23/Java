import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
class Card{
	private Frame frame;
	private CardLayout card;

	public void init(){

		frame = new Frame();
		card = new CardLayout();
		frame.setLayout(card);

		//Panel 6개를 배열로 생성하시오
		Panel[] p = new Panel[7];
		Color[] color = {new Color(255,0,0),
						new Color(223,108,15),
						new Color(255,255,0),
						new Color(0,255,0),
						new Color(0,0,255),
						new Color(23,2,174),
						new Color(255,0,255),		
		};
		String[] title = {"빨강","주황","노랑","초록","파랑","남색","보라"};

		for(int i = 0; i<p.length; i++){
			p[i] = new Panel();//생성
			p[i].setBackground(color[i]);

			frame.add(p[i], title[i]);

			//이벤트 마우스 리스너의 모든 메소드를 가지고 있는 마우스 어뎁터 사용
			p[i].addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					//card.show(frame, "파랑");
					card.next(frame);//클릭하면 하나씩 넘기는것
				}
			});
		}

		

		frame.setBounds(700,100,300,300);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter(){//윈도우 어뎁터는 추상클레스
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	public static void main(String[] args){
			Card ca = new Card();
			ca.init();
	}
}
