import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Label;
import java.awt.Panel;


class Calculator extends Frame implements KeyListener{
	String[] str = new String[]{"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+"}; 
		private Label dispL, inputL;// �� 2��
		private Button[] button; // ��ư 16�� 
		private Button back, cancel;// ��ư 2��
		private TextArea area;
		public Calculator(){
			super("����");			
			
			setBackground(new Color(194,238,254));//���� ����
			
			Button[] button = new Button[16]; //�迭�� ��ư 16�������

			dispL = new Label();//�� 2�� �����
			inputL = new Label();
			area = new TextArea();//�۾����°� �����

			dispL.setBackground(new Color(255,255,255)); //���� ���
			inputL.setBackground(new Color(255,255,255));


			back = new Button("��"); //��ư 2���� �� �Է�
			cancel = new Button("C");
			
			Panel an = new Panel();		//��ü �ĳ� �����
			an.setLayout(new GridLayout(7, 1, 5, 6)); // �ĳ��� ��� �� ���� ������ �Է�
			Panel p1 = new Panel();		
			p1.setLayout(new GridLayout(1, 4, 6, 5)); // ���� �ĳ� 7�� �����
			Panel p2 = new Panel();		
			p2.setLayout(new GridLayout(1, 4, 6, 5));
			Panel p3 = new Panel();		
			p3.setLayout(new GridLayout(1, 4, 6, 5));
			Panel p4 = new Panel();		
			p4.setLayout(new GridLayout(1, 4, 6, 5));
			Panel la1 = new Panel();		
			la1.setLayout(new GridLayout(1, 1, 10, 10)); //�� �ĳ� �Է�
			Panel la2 = new Panel();		
			la2.setLayout(new GridLayout(1, 1, 10, 10));
			Panel c = new Panel();		
			c.setLayout(new GridLayout(1, 2, 5, 1)); //��� �ĳ� �Է�

			for(int i = 0; i < button.length; i++){// ��ư�� �� �Է�
				button[i] = new Button(str[i]);
				if(i<=3){
						p1.add(button[i]); // �ٺ��� �Է�
				}else if(i<=7){
						p2.add(button[i]);
				}else if(i<=11){
						p3.add(button[i]);
				}else if(i<=15){
						p4.add(button[i]);
				}
			}		
			
			la1.add(dispL);  //���� ���ǳڿ� �Է�
			la2.add(inputL);
			c.add(back);//�󺧿� �齺���̽� �Է�
			c.add(cancel);
			

			an.add(la1); //��ü �ǳڿ� �ϳ��� �Է�
			an.add(la2);
			an.add(c);
			an.add(p1);
			an.add(p2);
			an.add(p3);
			an.add(p4);

			add(an);//��ü �ǳ��� �Է�

			setBounds(900,200,400,500);//���� ũ�⼳��
			setVisible(true);//���� ������̰�

			this.addWindowListener(new WindowExit());//���� xǥ������ ������ �����
			this.addKeyListener(this);// Ű������ ���صǰ� �ϴ°�
		}
			
		public void paint(Graphics g){g.drawString(, );}

		public void	keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_0){
			}else if(e.getKeyCode() == KeyEvent.VK_1){
				repaint();
			}
			}//Ű 0�� ������?
		public void	keyReleased(KeyEvent e){}
		public void	keyTyped(KeyEvent e){}



	public static void main(String[] args) {
			new Calculator();

	}
}