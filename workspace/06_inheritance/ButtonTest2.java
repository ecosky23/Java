import java.awt.Frame;
import java.awt.Button;

class ButtonTest2 extends Frame{
	private Button newB, exitB;

	public void init(){
		newB = new Button("���θ����");// newB exitB ��ư ����
		exitB = new Button("����");	
		
		newB.setBounds(50,100,80,50);//�� ũ��� ��ư�� �����
		exitB.setBounds(200,300,80,50);//��ư�� �����
		this.add(newB);// ��ư�� ȭ�鿡 ���δ�.
		add(exitB);// ȭ�鿡 ���δ�.
		setLayout(null);//���̾ƿ��� ������ ���ֹ����� �������� ��ġ�� ���ش�
		setBounds(900,200,300,400); // â�� ��ġ�� ũ��	
		setVisible(true);
		}



	public static void main(String[] args) {
		ButtonTest2 bt = new ButtonTest2();
		bt.init();

		new ButtonTest2().init();//1. Ŭ���� ������ 2.�����ڸ����� 3. init������  1ȸ��
	}
}
