import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
class WindowTest extends Frame{

	public void init(){
		setBounds(700,100,300,400);
			setVisible(true);
	}

	@Override
	public void paint(Graphics g){
		Toolkit t = Toolkit.getDefaultToolkit();//Ŭ���� ���� �߻��̶� new�� �ȵȴ�
		//Image img= t.getImage("lion.png");//�̹��� �ҷ����� ���̾� �̹��� �ҷ��´� �װ� img�� �ִ´�.
		Image img= t.getImage("D:/java_se/workspace/07_abstract/lion.png");
		//g.drawImage(img,30,100,this); // �̹��� �׸��� �׸��� �ڱ��ڽſ� �ٿ��� �ȼ� this�� ����
										//getImage(�׸�,��ġ, ��ġ , ��𿡺��ϰ���)

	/*g.drawImage(img,				// ȭ�� ũ�� �����ϱ�
				30, 100, 250, 300, //ȭ�� ��ġ
				238, 220, 0, 0,	//�̹��� ��ġ
				this);			//�Ųٷ� �����
*/
		g.drawImage(img,				
					30, 100, 250, 300, 
					238, 0, 0, 220,	
					this);

	
	}
	public static void main(String[] args) {
		new WindowTest().init();//������
		
		
	}
}
// ����̺� ��δ� /�ξ���. 