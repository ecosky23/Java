import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Frame;
class LoginResult extends Frame implements WindowListener{
	private String id, pwd;
//WindowsListener override
	public LoginResult(String id, String pwd){
		this.id = id;
		this.pwd = pwd;

		setBounds(1200,100,300,300);
		setVisible(true);
	//�̺�Ʈ
		this.addWindowListener(this);
	}
	
	public void paint(Graphics g){
		if(id.equals("angel") && pwd.equals("1004"))
			g.drawString("�α��� ����", 30, 100);
		else
			g.drawString("�α��� ����", 30, 100);
	}

	//WindowListener Override
	public void windowActivated(WindowEvent e){}//Ȱ��ȭ
	public void windowClosed(WindowEvent e){}//x�� ������ ����ó��
	public void windowClosing(WindowEvent e){setVisible(false);}//x�� ������ ���� false�� �ϸ� x�� ������ �̰͸� ������.
	public void windowDeactivated(WindowEvent e){}//��Ȱ��ȭ
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	
}
