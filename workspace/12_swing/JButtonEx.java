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
			jb[i] = new JRadioButton(i+ 1 + "번 버튼", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText(i + 1 +"번째 버튼이다. 눌러...");
			jb[i].setMnemonic(i+49);
			jb[i].setRolloverIcon(icon2);//마우스 갖다댔을때 나오는 그림
			jb[i].setPressedIcon(icon3);//눌렀을떼 나오는 그림
			jb[i].setSelectedIcon(icon4);// 눌렀다 땟을때 나오는 그림
			bg.add(jb[i]);
		}
		pack();//크기에 맞게 자동조정
		setVisible(true);
	}

	public static void main(String[] args) {
		new JButtonEx();
	}
}
