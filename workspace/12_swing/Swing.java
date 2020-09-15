import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

class Swing extends JFrame implements ActionListener {
	private JButton newB, exitB;
	private JTextArea area;
	private int result;
	public Swing(){		
		newB = new JButton(new ImageIcon("cc.gif"));
		exitB = new JButton("종료");
		JPanel p1 = new JPanel();		
		area = new JTextArea();
		JScrollPane sc = new JScrollPane(area);		
		
		Container c = getContentPane();
		p1.add(newB);
		p1.add(exitB);
		c.add("North",p1);	
		c.add("Center",sc);

		setBounds(700,400,300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				result=JOptionPane.showConfirmDialog(Swing.this, 
										"정말로 종료하시겠습니까?", 
										"종료",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
				if(result ==JOptionPane.YES_OPTION){
					//System.exit(0);
					result=JOptionPane.showConfirmDialog(Swing.this, 
										"확실해?!", 
										"종료?!",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE);
					if(result ==JOptionPane.YES_OPTION){
						System.exit(0);
					}
				}
			}
		});
		
		//이벤트
		newB.addActionListener(this);
		exitB.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==newB){
			area.setText("");
		}else if(e.getSource()==exitB){
			//System.exit(0);
			result = JOptionPane.showConfirmDialog(this,
													"정말로 종료하시겠습니까?",
													"종료",
													JOptionPane.YES_NO_OPTION,
													JOptionPane.QUESTION_MESSAGE);
			if(result ==JOptionPane.YES_OPTION){
				System.exit(0);
			}
										

		}
	}



	public static void main(String[] args) {
		new Swing();
	}
}
