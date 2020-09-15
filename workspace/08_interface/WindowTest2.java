import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame - BorderLayout(�������Ϲ�ġ)
class WindowTest2 extends Frame implements ActionListener, WindowListener{
	private Button newBtn, exitBtn;
	private TextArea area;

	public void init(){
		newBtn = new Button("���θ����"); //���θ�����ֱ� ���� ���� 
		exitBtn = new Button("����");

		area = new TextArea();// �۾����� ����°��� �־��ִ� ��
		area.setFont(new Font("������",Font.BOLD,20));//�۲� ���� ũ��� ��Ʈ�� ��������

		Panel p = new Panel();//FlowLayout(�߾� ���� ������� ��ġ) ����� ���� 
		p.setBackground(new Color(255,200,255));
		p.add(newBtn);// ��ο� ��ư �ø���
		p.add(exitBtn);

		add("North", p);//����� ���� ȭ��â�� �ø���
		add("Center",area); // �۾����°��� ȭ�鿡 �����ֱ�

		setBounds(900,100,300,400);
		setVisible(true);

		//�̺�Ʈ
		this.addWindowListener(this);
		exitBtn.addActionListener(this);// 1.�����ư�� ������ �������� �ൿ�ϰ��ϴ� ��ɾ�
		newBtn.addActionListener(this);// �� ��ư�� ������ �ൿ�ϰ� �ϴ¸�ɾ� this�� ����� �� Ŭ�����������Ѵٴ� ��
}
//ActionListener override

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() == "���θ����"){  // ��ư�� �ƴ϶� ���� �ִ� ��� �� �۷� ã�� ��
											//���⿡���� �̰Դ� ���ϴ�.
		//if(e.getSource() == newBtn){ // �� ��ư�̶�� �����Ǿ� �ִ� ���� ������ ��
			area.setText(" "); //new ��ư�� ������ �ʱ�ȭ �ϰڴ�.
		}else if(e.getSource() == exitBtn){ // ������ư�� �����ư���� Ȯ��
			System.exit(0);
		}// 2.�����ư ������ ����Ǵ� ����
	}
//WindowListener override
	public void windowActivated(WindowEvent e){}//Ȱ��ȭ
	public void windowClosed(WindowEvent e){}//x�� ������ ����ó��
	public void windowClosing(WindowEvent e){System.exit(0);}//x�� ������ ����
	public void windowDeactivated(WindowEvent e){}//��Ȱ��ȭ
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	public static void main(String[] args) {
		new WindowTest2().init();
	}
}
