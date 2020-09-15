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
	//이벤트
		this.addWindowListener(this);
	}
	
	public void paint(Graphics g){
		if(id.equals("angel") && pwd.equals("1004"))
			g.drawString("로그인 성공", 30, 100);
		else
			g.drawString("로그인 실패", 30, 100);
	}

	//WindowListener Override
	public void windowActivated(WindowEvent e){}//활성화
	public void windowClosed(WindowEvent e){}//x를 누르고 사후처리
	public void windowClosing(WindowEvent e){setVisible(false);}//x를 누르는 순간 false를 하면 x를 누르면 이것만 꺼진다.
	public void windowDeactivated(WindowEvent e){}//비활성화
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	
}
