import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.*;
import java.awt.event.InputEvent;
import java.awt.Event;

class MenuPane extends JMenuBar{
	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;

	public MenuPane(){
		fileM = new JMenu("파일");
		editM = new JMenu("편집");
		viewM = new JMenu("보기");

		newM = new JMenuItem("새로만들기");
		openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("종료");

		cutM = new JMenuItem("잘라내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");

		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);

		editM.add(cutM);
		editM.add(copyM);
		editM.add(pasteM);

		add(fileM);
		add(editM);
		add(viewM);
		
		//단축키
		
		//cutM.setAccelerator(KeyStroke getKeyStroke('X',InputEvent.ALT_DOWN_MASK));단축키 주는 명령어
		cutM.setAccelerator(KeyStroke.getKeyStroke('X', Event.ALT_MASK));//위에거와 똑같은 명령어
		copyM.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.ALT_DOWN_MASK));
		pasteM.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.ALT_DOWN_MASK));


	}

	public JMenuItem getNewM(){
		return newM;
	}
	public JMenuItem getOpenM(){
		return openM;
	}
	public JMenuItem getSaveM(){
		return saveM;
	}
	public JMenuItem getExitM(){
		return exitM;
	}
	public JMenuItem getCutM(){
		return cutM;
	}
	public JMenuItem getCopyM(){
		return copyM;
	}
	public JMenuItem getPasteM(){
		return pasteM;
	}

	

}
/*
JMenuBar
파일			편집			보기  <-JMenu

새로만들기		잘라내기
열기			복사
저장			붙여넣기
종료
JMenuItem


*/