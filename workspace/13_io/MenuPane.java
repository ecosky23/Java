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
		fileM = new JMenu("����");
		editM = new JMenu("����");
		viewM = new JMenu("����");

		newM = new JMenuItem("���θ����");
		openM = new JMenuItem("����");
		saveM = new JMenuItem("����");
		exitM = new JMenuItem("����");

		cutM = new JMenuItem("�߶󳻱�");
		copyM = new JMenuItem("����");
		pasteM = new JMenuItem("�ٿ��ֱ�");

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
		
		//����Ű
		
		//cutM.setAccelerator(KeyStroke getKeyStroke('X',InputEvent.ALT_DOWN_MASK));����Ű �ִ� ��ɾ�
		cutM.setAccelerator(KeyStroke.getKeyStroke('X', Event.ALT_MASK));//�����ſ� �Ȱ��� ��ɾ�
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
����			����			����  <-JMenu

���θ����		�߶󳻱�
����			����
����			�ٿ��ֱ�
����
JMenuItem


*/