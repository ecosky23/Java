import java.util.Scanner;
import java.util.Random;

class Quiz {
	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int num = random.nextInt(100)+1;	
		//int num = (int)(Math.random()*100)+1;
		
		int count = 0;
		while(true){
			System.out.println("���ڸ� �Է��ϼ���: ");
		int	number = scanner.nextInt();
			count++;
		if(num > number){
			System.out.println("���ڰ� �������ں��� �۽��ϴ�.");

		}else if(num < number){
			System.out.println("���ڰ� �������ں��� Ů�ϴ�.");
		}else if(num == number){
			System.out.println("���ڸ� ���߼̽��ϴ�.");
			System.out.println("�� "+count+"Ƚ�������ϼ̽��ϴ�.");
				break;
		}
		}//while
		


		scanner.close();
	}
}


/*1~100������ ������ �߻��Ͽ� ���ߴ� ����
[������]
1 ~ 100 ������ ������ �߻��Ͽ����ϴ�.(85)

���� �Է�: 50

50���� Ů�ϴ�.

���� �Է� : 90

90���� �۽��ϴ�.
.....
���� �Է� 85
xx�� ���߼̽��ϴ�.

*/