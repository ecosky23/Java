import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class MsPaint extends JFrame implements MouseMotionListener{	
		Point endP = null;
		Point startP = null;

		private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
		private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
		private JCheckBox fill;
		private JRadioButton line, circle, rect, roundRect, pen;
		private JComboBox<String> combo;
		private JButton draw;
		private DrCanvas canvas;
		private ArrayList<ShapeDTO> list;

	public MsPaint(){
	
	canvas = new DrCanvas(this);//����ĵ������ this�� MsPaint���� �ѱ�
	
	String[] color={"����","�ʷ�","�Ķ�","����","�ϴ�"};	//�޺��ڽ� ���γ���
	
	 combo = new JComboBox<String>(color); 
	
		 x1T = new JTextField("0");
		 x2T = new JTextField("0");
		 y1T = new JTextField("0");
	     y2T = new JTextField("0");
    	 z1T = new JTextField("50");
		 z2T = new JTextField("50");

	     x1L = new JLabel("x1");
	     y1L = new JLabel("y1");
		 x2L = new JLabel("x2");
		 y2L = new JLabel("y2");
		 z1L = new JLabel("z1");
		 z2L = new JLabel("z2");

		 fill = new JCheckBox("ä���");
		
		 list = new ArrayList<shapeDTO>();

		 line = new JRadioButton("��", true);
		 circle = new JRadioButton("��");
		 rect = new JRadioButton("�簢��");
		 roundRect = new JRadioButton("�ձٻ簢��");
		 pen = new JRadioButton("����");

	ButtonGroup group = new ButtonGroup();//����� ��ư �׷����� ��� �ѹ��� �ϳ��� ���õǰ� �ϱ�
	group.add(line);//������Ű�� �͵� �߿��ϴ�
	group.add(circle);
	group.add(rect);
	group.add(roundRect);
	
	draw = new JButton("�׸���");
	
	x1T.setBounds(45,10,50,30);//�ؽ�Ʈ�ʵ�
	y1T.setBounds(115,10,50,30);
	x2T.setBounds(185,10,50,30);
	y2T.setBounds(255,10,50,30);
	z1T.setBounds(325,10,50,30);
	z2T.setBounds(395,10,50,30);

	x1L.setBounds(30,10,50,30);//��
	y1L.setBounds(100,10,50,30);
	x2L.setBounds(170,10,50,30);
	y2L.setBounds(240,10,50,30);
	z1L.setBounds(310,10,50,30);
	z2L.setBounds(380,10,50,30);

	fill.setBounds(470,10,80,30);//üũ�ڽ�

	line.setBounds(40,220,50,30);//������ư
	circle.setBounds(90,220,50,30);
	rect.setBounds(140,220,80,30);
	roundRect.setBounds(220,220,100,30);

	canvas.setBounds(40,55,500,160);//ķ����
	
	combo.setBounds(350,225,80,30);//�޺��ڽ�

	draw.setBounds(455,225,80,30);//�׸��� ��ư

	add(x1L);//��
	add(y1L);
	add(x2L);
	add(y2L);
	add(z1L);
	add(z2L);

	add(x1T);//�ؽ�Ʈ�ʵ�
	add(y1T);
	add(x2T);
	add(y2T);
	add(z1T);
	add(z2T);

	add(fill);//üũ�ڽ�
	add(line);//���� ��ư
	add(circle);
	add(rect);
	add(roundRect);

	add(combo);//�޺��ڽ�

	add(canvas);//������

	add(draw);//�׸��� ��ư
	
		setLayout(null);
		setTitle("�̴� �׸���");
		setBounds(700,100,600,300);
		setVisible(true);

		addMouseMotionListener(this);
		
	}
		public void	mouseDragged(MouseEvent e){}
		public void	mouseMoved(MouseEvent e){}
		
		public JTextField getX1T(){return x1T;}
		public JTextField getX2T(){return x2T;}
		public JTextField getY1T(){return y1T;}
		public JTextField getY2T(){return y2T;}
		public JTextField getZ1T(){return z1T;}
		public JTextField getZ2T(){return z2T;}

		public JComboBox<String> getCombo(){return combo;}
		public JCheckBox getFill(){return fill;}
		public JRadioButton getLine(){return line;}
		public JRadioButton getCircle(){return circle;}
		public JRadioButton getRect(){return rect;}
		public JRadioButton getRoundRect(){return roundRect;}
		public JRadioButton getPen(){return pen;}

		public ArrayList<shapeDTO> getList(){
			return list;
		}

		
		
	

		public void event(){
			draw.addActionListener(new ActionListener(){//�������̽��� new�� �Ҽ� ������
				@Override									//�͸����� �����ϰ��Ѵ�
				public void actionPerformed(ActionEvent e){	
					canvas.repaint();
				}
			});

			canvas.addMouseListener(new MouseAdapter(){
			@Override
			public void	mousePressed(MouseEvent e){
	
				x1T.setText(g.getX()+"");//��Ʈ�������� �ٲ���� �Ѵ�.
				y1T.setText(g.getY()+"");//���콺�� ���������� ó�� ��ǥ
			}
			});

			canvas.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				x2T.setText(g.getX()+"");//�巹�� �ɶ��� ���콺 �� ��ǥ
				y2T.setText(g.getY()+"");
				canvas.repaint();
			}
			});
		}													

	public static void main(String[] args){
		new MsPaint().event();
	}
}
