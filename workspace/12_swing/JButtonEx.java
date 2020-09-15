import java.awt.*;
import javax.swing.*;
class JButtonEx extends JFrame{
	private Icon icon1 = new ImageIcon("j.jpg");
	private Icon icon2 = new ImageIcon("jj.jpg");
	private Icon icon3 = new ImageIcon("jjj.jpg");
	private Icon icon4 = new ImageIcon("jjjj.png");
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup(); 
	
	public JButtonEx(){
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i=0; i<4; i++){
			jb[i] = new JRadioButton(i+ 1 + "�� ��ư", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText(i + 1 +"��° ��ư�̴�. ����...");
			jb[i].setMnemonic(i+49);
			jb[i].setRolloverIcon(icon2);//���콺 ���ٴ����� ������ �׸�
			jb[i].setPressedIcon(icon3);//�������� ������ �׸�
			jb[i].setSelectedIcon(icon4);// ������ ������ ������ �׸�
			bg.add(jb[i]);
		}
		pack();//ũ�⿡ �°� �ڵ�����
		setVisible(true);
	}

	public static void main(String[] args) {
		new JButtonEx();
	}
}
