import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
class WindowTest extends Frame{	//�⺻������
	public WindowTest(){
		//new Frame("�������� ������").setVisible(true); ���ſ� ����ֱ�
		super("�������� ������");//�θ� ������ ȣ���ؼ� windowtest�� ���� �ֱ�

		System.out.println("����");//cmd�ȿ� ���ڰ� ���´�.
		setForeground(new Color(255,255,0));//���ڻ�
		setBackground(new Color(235,31,189));//������
		
		//setBackground(Color.PINK); ��� ����
		setBounds(900,200,300,400); // â�� ��ġ�� ũ��
		//setSize(300,400);// â�� ũ��
		setVisible(true);
	}
	@Override// �ڽ�Ŭ�������� ����ǰ� �ϱ����ؼ�
		public void paint(Graphics g){//������ - ������ �ٱ��� ��ġ�� �־ call back �޼ҵ� �̱� ������ �ڹٰ���ӽ��� �ڵ����� ����//Frame�ȿ� �׷��ش�.
			g.drawString("����",100,80); //�׸��������� ���ڸ� �־��ش� ���ڴ� ��ġ
			g.drawLine(200,150,100,200); // ���� �׷��ش� ���ڴ� ��ġ
			g.drawRect(200,150,100,200); //x��ǥ, y��ǥ, �ʺ�, ���� �簢�� �׸���
			g.drawOval(200,150,100,200);//���׸��� x��ǥ, y��ǥ, �ʺ�, ����
	}

	public static void main(String[] args) {
		new WindowTest();
				

	}
}
//235, 31,189