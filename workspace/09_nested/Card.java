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

		//Panel 6���� �迭�� �����Ͻÿ�
		Panel[] p = new Panel[7];
		Color[] color = {new Color(255,0,0),
						new Color(223,108,15),
						new Color(255,255,0),
						new Color(0,255,0),
						new Color(0,0,255),
						new Color(23,2,174),
						new Color(255,0,255),		
		};
		String[] title = {"����","��Ȳ","���","�ʷ�","�Ķ�","����","����"};

		for(int i = 0; i<p.length; i++){
			p[i] = new Panel();//����
			p[i].setBackground(color[i]);

			frame.add(p[i], title[i]);

			//�̺�Ʈ ���콺 �������� ��� �޼ҵ带 ������ �ִ� ���콺 ��� ���
			p[i].addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					//card.show(frame, "�Ķ�");
					card.next(frame);//Ŭ���ϸ� �ϳ��� �ѱ�°�
				}
			});
		}

		

		frame.setBounds(700,100,300,300);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter(){//������ ��ʹ� �߻�Ŭ����
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
