import java.util.Scanner;
class ExceptionTest{
	public static void main(String[] args){
		if(args.length > 0) System.out.println("args[0] = "+args[0]);
		System.out.println();

		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է�: ");
		int num = scan.nextInt();
		
		try{
		int num2 = Integer.parseInt(args[0]);//���������� ��ȯ
		//System.out.println(num+"/"+num2+"="+((double)num/num2)); double�� �ϰ� 0���γ����� infinity�� ���
		}catch(NumberFormatException e){//���ڸ� �ȳ־ ������ �߸� ��Ÿ���� ����
			System.out.println("���ڸ� �Է��ϼ���");//�����̿��� ���� �Է������� ��Ÿ���� ����
		}catch(ArithmeticException e){//0���� ���������� ������ ��� ����
			System.out.println("0���� ������ �ȵ˴ϴ�.");
		}finally{//error�� �־ ������ ����
			System.out.println("error�� �ְ� ���� ������ ����!!");
		}
	}
}
