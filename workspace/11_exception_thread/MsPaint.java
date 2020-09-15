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
	
	canvas = new DrCanvas(this);//닥터캔버스에 this로 MsPaint값을 넘김
	
	String[] color={"빨강","초록","파랑","보라","하늘"};	//콤보박스 내부내용
	
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

		 fill = new JCheckBox("채우기");
		
		 list = new ArrayList<shapeDTO>();

		 line = new JRadioButton("선", true);
		 circle = new JRadioButton("원");
		 rect = new JRadioButton("사각형");
		 roundRect = new JRadioButton("둥근사각형");
		 pen = new JRadioButton("연필");

	ButtonGroup group = new ButtonGroup();//레디오 버튼 그룹으로 묶어서 한번에 하나씩 선택되게 하기
	group.add(line);//순서지키는 것도 중요하다
	group.add(circle);
	group.add(rect);
	group.add(roundRect);
	
	draw = new JButton("그리기");
	
	x1T.setBounds(45,10,50,30);//텍스트필드
	y1T.setBounds(115,10,50,30);
	x2T.setBounds(185,10,50,30);
	y2T.setBounds(255,10,50,30);
	z1T.setBounds(325,10,50,30);
	z2T.setBounds(395,10,50,30);

	x1L.setBounds(30,10,50,30);//라벨
	y1L.setBounds(100,10,50,30);
	x2L.setBounds(170,10,50,30);
	y2L.setBounds(240,10,50,30);
	z1L.setBounds(310,10,50,30);
	z2L.setBounds(380,10,50,30);

	fill.setBounds(470,10,80,30);//체크박스

	line.setBounds(40,220,50,30);//라디오버튼
	circle.setBounds(90,220,50,30);
	rect.setBounds(140,220,80,30);
	roundRect.setBounds(220,220,100,30);

	canvas.setBounds(40,55,500,160);//캠버스
	
	combo.setBounds(350,225,80,30);//콤보박스

	draw.setBounds(455,225,80,30);//그리기 버튼

	add(x1L);//라벨
	add(y1L);
	add(x2L);
	add(y2L);
	add(z1L);
	add(z2L);

	add(x1T);//텍스트필드
	add(y1T);
	add(x2T);
	add(y2T);
	add(z1T);
	add(z2T);

	add(fill);//체크박스
	add(line);//라디오 버튼
	add(circle);
	add(rect);
	add(roundRect);

	add(combo);//콤보박스

	add(canvas);//컨버스

	add(draw);//그리기 버튼
	
		setLayout(null);
		setTitle("미니 그림판");
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
			draw.addActionListener(new ActionListener(){//인터페이스라서 new를 할수 없지만
				@Override									//익명으로 가능하게한다
				public void actionPerformed(ActionEvent e){	
					canvas.repaint();
				}
			});

			canvas.addMouseListener(new MouseAdapter(){
			@Override
			public void	mousePressed(MouseEvent e){
	
				x1T.setText(g.getX()+"");//스트링값으로 바꿔줘야 한다.
				y1T.setText(g.getY()+"");//마우스가 눌러질때는 처음 좌표
			}
			});

			canvas.addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				x2T.setText(g.getX()+"");//드레그 될때는 마우스 끝 좌표
				y2T.setText(g.getY()+"");
				canvas.repaint();
			}
			});
		}													

	public static void main(String[] args){
		new MsPaint().event();
	}
}
