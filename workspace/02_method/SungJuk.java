//�̸�name ����kor ����eng ����math ������ �Է� �޾Ƽ� ����tot�� ���avg�� ���Ͻÿ�
//��, ������ calcTot()���Ͽ� ��ȯ ����� calcAvg()���Ͽ� ��ȯ ����� disp()���� �Ͻÿ�
//[������]
//�̸� �Է�:
//�������� �Է�: 90
//�������� �Է�: 90
//�������� �Է�: 91

//*** ȫ�浿 ����ǥ ***
// ���� ���� ���� ���� ���
// 90  90  91 271 90.33
//1. �̸� ���� ���� ���� �Է�
//2. �Լ� ȣ�� - calcTot(
//3. �Լ� ȣ�� - calcAvg(
//4. �Լ� ȣ�� - disp(
import java.util.Scanner;
class SungJuk{
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("�̸��� �Է��ϼ���: ");
	String name = scanner.nextLine();
	System.out.println("���������� �Է��ϼ���: ");
	int kor = scanner.nextInt();
	System.out.println("���������� �Է��ϼ���: ");
	int math = scanner.nextInt();
	System.out.println("���������� �Է��ϼ���: ");
	int eng = scanner.nextInt();

	int calcTot = kor + math + eng;
	int calcAvg = calcTot/3;

	System.out.println("�̸�:" +name);
	}

	

}
