import java.awt.event.*;
import java.awt.*;


//JDK11 ���� ������HTML5(<font>�±� �� ����) �׷��� <span>���� ����ؾ� �Ѵ�.   

/** 
api������ �ּ��� �߷��� /*�ȵȴ� /**�̷��� �ؾ��Ѵ�.
<font style="color: red; font-size: 20pt;">   �Ӽ�(attribute)
�̹����� �̵��ϴ� Ŭ����
</font>        
 �����ָ� �ݵ�� �ݾƾ��Ѵ�.
*/

class ImageMove extends Frame implements WindowListener, ActionListener, KeyListener{
	private Button newButton, leftButton, upButton, downButton, rightButton;
	
/** 
<font style="color: red; font-size: 20pt;">   
	x�� y�� �̹����� ������ġ
</font>        
*/
	int x = 200;
	int y = 200;

/** 
<font style="color: red; font-size: 20pt;">   
	��ư �����ϰ� Frame ũ�� ����
</font>        
*/

	public void init(){
		
		newButton = new Button("new");//��ư ����
		leftButton = new Button("��");
		upButton = new Button("��");
		downButton = new Button("��");
		rightButton = new Button("��");

		
		Panel p = new Panel();//�гλ���
		
			p.add(newButton);//�ǳڿ� ��ư ���̱�
			p.add(leftButton);
			p.add(upButton);
			p.add(downButton);
			p.add(rightButton);
			
				add("North",p);//�����ӿ� �ǳ� ���̱�
		
		setBounds(700,100,500,500);
		setVisible(true);

	/*	newButton.setFocusable(false);//��Ŀ���� �����ִ� ��ɾ�
		leftButton.setFocusable(false);  ��ư �ȿ� 2���� ����� ����
		rightButton.setFocusable(false);	��Ŀ������� ���ָ� �ϳ��� ����� �����ؼ�
		upButton.setFocusable(false);	Ű���尡 �۵����ϰ� �ȴ�.
		downButton.setFocusable(false);
	*/
		setResizable(false);//������ ����

		addWindowListener(this);//��𼭽���.�����츮���ʽ���(�����ϴ� ���� ���������� �ֳ�?)
		
		newButton.addActionListener(this);//����Ǵ� ��ư.�����(�����ϴ� ���� ��ġ)
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
	@Override//ActionListener �� �ϳ��ۿ� ����.
	public void actionPerformed(ActionEvent e){//���콺 Ŭ���� ���ؼ� ������ ����
		//ex) = if(e.getSource() == newButton){ �Ʒ��� ������
		
		if(e.getActionCommand() == "new"){  
			this.x = 200;
			this.y = 200;
		}else if(e.getActionCommand() == "��"){ 
			if(x<-50)x=450;
			this.x -= 10;
		}else if(e.getActionCommand() == "��"){
			if(y<-50)y=450;
			this.y -= 10;
		}else if(e.getActionCommand() == "��"){
			if(y>450)y=-50;
			this.y += 10;
		}else if(e.getActionCommand() == "��"){
			if(x>450)x=-50;
			this.x += 10;
		}
				repaint();
	}

	@Override//keyListener Override

	public void	keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){//Ű���带 ���ؼ� �����ӻ���
				System.exit(0);					//�ƽ�Ű�ڵ� 27
			}else if(e.getKeyCode() == KeyEvent.VK_UP){	//�ƽ�Ű�ڵ� 38
					if(y<-50) y=450;
						this.y -= 10;		
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){//�ƽ�Ű�ڵ� 40
					if(y>450) y=-50;
						this.y += 10;	
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){//�ƽ�Ű�ڵ� 37
					if(x<-50)x=450;
						this.x -= 10;
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){//�ƽ�Ű�ڵ� 39
					if(x>450) x=-50;
						this.x += 10;
			}
			repaint();
	}
		
	public void	keyReleased(KeyEvent e){}
	public void	keyTyped(KeyEvent e){}


	@Override
	public void paint(Graphics g){// �׸��ҷ����� repaint() �ϸ� �� �޼ҵ带 �ٽ� ȣ���ϴ°�
		Toolkit t = Toolkit.getDefaultToolkit();
		
		Image img= t.getImage("D:/java_se/workspace/08_interface/chi.jpg");
	//	Image img = Toolkit.getDefaultToolkit().getImage("chi.jpg"); ���ǰ͵��� ��ģ�� ������
			g.drawImage(img, this.x, this.y, 100, 100, this);
	}	

	@Override
	public void windowActivated(WindowEvent e){}//Ȱ��ȭ
	public void windowClosed(WindowEvent e){}//x�� ������ ����ó��
	public void windowClosing(WindowEvent e){System.exit(0);}//x�� ������ ����
	public void windowDeactivated(WindowEvent e){}//��Ȱ��ȭ
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}


	public static void main(String[] args) {
		new ImageMove().init();
	}
}
/*
���� �̹��� �̵� 1�� ���⿡ X����ǰ� �����
â ũ�� ���� 500, 500���� - ���ͳ� ���� ã�� 
���ʿ� ��ư 5�� newButton leftButton upButton downButton rightButton
��ư�� ȭ��ǥ �ֱ� newButton�� �̹����� ó���������� �����ϱ�
�̹��� �ϳ��ø��� ��� ���� �۰� �̹��� ��ġ ó�� 100, 100
��ư�� ������ ��ư �ϳ��� ��ġ�̵� 10 
��ư�� �������� �߰��� ������� �ٽ� ���������� ������ �ϱ�
Ű���� �̺�Ʈ �߻� ȭ��ǥ ������ �����̰�

*/