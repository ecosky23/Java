//import static java.lang.Math.random; //���� �޽��� �����ϱ� ������ �Ʒ��� �Ž��� �����൵ �ȴ�.
//import static java.lang.Math.pow;
import static java.lang.Math.*;        //����ƽ�̶� new�� �Ƚᵵ �ȴ�.
import static java.lang.String.format;
import static java.lang.System.out;		//�ý��۵� ���̶� ��������ϸ� �׿� �Ƚᵵ �ȴ�.
class ImportStatic{
	public static void main(String[] args){
		out.println("���� = " + random());//0<=����<1
		out.println("���� = " + pow(2,5));
		out.println("�Ҽ� ���� 2° �ڸ� = "+ format("%.2f",43.56789));

	}
}
