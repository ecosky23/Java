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
			System.out.println("숫자를 입력하세요: ");
		int	number = scanner.nextInt();
			count++;
		if(num > number){
			System.out.println("숫자가 랜덤숫자보다 작습니다.");

		}else if(num < number){
			System.out.println("숫자가 랜덤숫자보다 큽니다.");
		}else if(num == number){
			System.out.println("숫자를 맞추셨습니다.");
			System.out.println("총 "+count+"횟수도전하셨습니다.");
				break;
		}
		}//while
		


		scanner.close();
	}
}


/*1~100사이의 난수를 발생하여 맞추는 게임
[실행결과]
1 ~ 100 사이의 난수가 발생하였습니다.(85)

숫자 입력: 50

50보다 큽니다.

숫자 입력 : 90

90보다 작습니다.
.....
숫자 입력 85
xx번 맞추셨습니다.

*/