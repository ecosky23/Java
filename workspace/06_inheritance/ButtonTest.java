import java.awt.Frame;
import java.awt.Button;
import java.awt.Panel;
import java.awt.GridLayout;
class ButtonTest extends Frame{
		private Button northB = null;
		private Button newB, exitB;
		
		
		public void init(){		
		northB = new Button("����");  //���� �ִ� ButtonŬ������ ����
		newB = new Button("���θ����");
		exitB = new Button("����");	
		
		Panel p = new Panel(); //FlowLayout ��ư�� ��ĥ�� �Ȱ�ġ�� ��ġ��Ű��
		p.setLayout(new GridLayout(1, 2, 5, 0));  //(��, ��, ���ο���, ���ο���) ȭ�鿡 ���̾ƿ��� ���� ĭ�������ش�.
		p.add(newB);
		p.add(exitB);
		this.add("North", northB); // northB��� ��ư�� ���̾ƿ��� ���� ���ʿ� �ٿ��ּ���
			
			add("South", p);
		setBounds(900,200,300,400); // â�� ��ġ�� ũ��	
		setVisible(true);
		}

	public static void main(String[] args){
		ButtonTest bt = new ButtonTest(); //1. ������ ����� 2. ���ϰ� 3. init�����
		bt.init();
	}
}
