//10������ �Է� �޾Ƽ� 2����, 8���� , 16������ ����Ͻÿ�
//�� Integer�� ��ȯ�����ִ� �޼ҵ带 ã���ÿ�
//
//[������]
//10���� �Է� : 250
//2���� = 11111010
//8���� =
//16���� = 
import java.util.Scanner;
class Jinsu {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("10���� �Է�: ");
	int dec = scan.nextInt();
	String binary = Integer.toBinaryString(dec);
	String oct = Integer.toOctalString(dec);
	String hexa = Integer.toHexString(dec);
	
		System.out.println("2���� = "+binary);
		System.out.println("8���� = "+oct);
		System.out.println("16���� = "+hexa);
	
	}
}
