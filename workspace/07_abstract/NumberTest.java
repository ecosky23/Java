import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;

class NumberTest{
	public static void main(String[] args){
		NumberFormat nf = new DecimalFormat(); //���ø� ������ �ѹ������� �ڽ����̴�.
		//DecimalFormat 3�ڸ� ���� ��ǥ(,)�� ��´�. �Ҽ��� ���� 3�ڸ� ���� ��Ÿ��
		System.out.println(nf.format(12345678.456789));//�ڽ� Ŭ���� �̿�
		System.out.println(nf.format(12345678));
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.##��"); 
		//��ȿ���ڰ� �ƴѰ��� ǥ������ �ʴ´�.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		NumberFormat nf3 = new DecimalFormat("#,###.00��"); 
		//0�� ������ ǥ��
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();

		//NumberFormat nf4 = NumberFormat.getInstance();//�޼ҵ带 �̿��ؼ� ���� �̾ȿ��� Ŭ������
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();//ȯ�� ���� ǥ��:��
		nf4.setMaximumFractionDigits(2);//�Ҽ����� 2°¥�� ���� ������
		nf4.setMinimumFractionDigits(2);//�Ҽ����� ���� ��� 0�� ������ ��µȴ�.
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();

		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();

	
	
	}
}
/*		1,234.57		1234
#,###.## 1,234.57		1,234
#,###.00 1,234.57		1,234.00



*/