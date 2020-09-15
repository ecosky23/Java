import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MsPaint extends JFrame {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvas can;
	private ArrayList<ShapeDTO> list;

	public MsPaint(){
		x1L = new JLabel("X1");
		y1L = new JLabel("Y1");
		x2L = new JLabel("X2");
		y2L = new JLabel("Y2");
		z1L = new JLabel("Z1");
		z2L = new JLabel("Z2");

		x1T = new JTextField("0",4);
		y1T = new JTextField("0",4);
		x2T = new JTextField("0",4);
		y2T = new JTextField("0",4);
		z1T = new JTextField("50",4);
		z2T = new JTextField("50",4);

		fill = new JCheckBox("ä���");
		
		line = new JRadioButton("��", true);
		circle = new JRadioButton("��");
		rect = new JRadioButton("�簢��");
		roundRect = new JRadioButton("�ձ� �簢��");
		pen = new JRadioButton("����");

		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		String[] color = {"����","�ʷ�","�Ķ�","����","�ϴ�"};
		combo = new JComboBox<String>(color);

		draw = new JButton("�׸���");

		can = new DrCanvas(this);

		list = new ArrayList<ShapeDTO>();

		JPanel p = new JPanel();
		p.add(x1L);
		p.add(x1T);
		p.add(y1L);
		p.add(y1T);
		p.add(x2L);
		p.add(x2T);
		p.add(y2L);
		p.add(y2T);
		p.add(z1L);
		p.add(z1T);
		p.add(z2L);
		p.add(z2T);
		p.add(fill);

		JPanel p2 = new JPanel();
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);

		Container c = this.getContentPane();
		c.add("North", p);
		c.add("Center", can);
		c.add("South", p2);
		
		setBounds(500,200,700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//MsPaint()

	public JTextField getX1T(){
		return x1T;
	}
	public JTextField getY1T(){
		return y1T;
	}
	public JTextField getX2T(){
		return x2T;
	}
	public JTextField getY2T(){
		return y2T;
	}
	public JTextField getZ1T(){
		return z1T;
	}
	public JTextField getZ2T(){
		return z2T;
	}
	public JComboBox<String> getCombo(){
		return combo;
	}
	public JCheckBox getFill(){
		return fill;
	}
	public JRadioButton getLine(){
		return line;
	}
	public JRadioButton getCircle(){
		return circle;
	}
	public JRadioButton getRect(){
		return rect;
	}
	public JRadioButton getRoundRect(){
		return roundRect;
	}
	public JRadioButton getPen(){
		return pen;
	}
	public ArrayList<ShapeDTO> getList(){
		return list;
	}
	
	public void event(){
		draw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				can.repaint();
			}
		});

		/*
		combo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				can.repaint();
			}
		});
		*/

		can.addMouseListener(new MouseAdapter(){
			@Override
			public void	mousePressed(MouseEvent e){
				x1T.setText(e.getX()+"");
				y1T.setText(e.getY()+"");
			}

			@Override
			public void mouseReleased(MouseEvent e){
				x2T.setText(e.getX()+"");
				y2T.setText(e.getY()+"");
				
				if(x1T.getText().equals(x2T.getText())
					&& y1T.getText().equals(y2T.getText())) return;

				ShapeDTO dto = new ShapeDTO();
				//��ǥ
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));

				dto.setFill(fill.isSelected());  //ä���

				//����
				if(line.isSelected()) dto.setShape(Figure.LINE);
				else if(circle.isSelected()) dto.setShape(Figure.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Figure.RECT);
				else if(roundRect.isSelected()) dto.setShape(Figure.ROUNDRECT);

				dto.setCombo(combo.getSelectedIndex()); //��

				list.add(dto);
				System.out.println(list);
			}
		});

		can.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void	mouseDragged(MouseEvent e){
				x2T.setText(e.getX()+"");
				y2T.setText(e.getY()+"");

				can.repaint();
			}
		});
	}

	public static void main(String[] args) {
		new MsPaint().event();
	}
}
