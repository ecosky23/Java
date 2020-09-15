import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class WindowExit implements WindowListener{
	

public void windowActivated(WindowEvent e){}//활성화
public void windowClosed(WindowEvent e){}//x를 누르고 사후처리
public void windowClosing(WindowEvent e){System.exit(0);}//x를 누르는 순간
public void windowDeactivated(WindowEvent e){}//비활성화
public void windowDeiconified(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowOpened(WindowEvent e){}
}
