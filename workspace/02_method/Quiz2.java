/*
10부터 ~ 99사이의 난수를 2개 발생하여 합을 맞추는 게임
a = 난수 발생    b =난수 발생
[실행결과]
12 + 36 = 사용자가 입력
틀렸습니다.
또는
12 + 36 = 사용자가 입력
참잘했어용
답은 사용자가 입력 = user

당신의 점수는 x개 맞추어서 x점 입니다.
*/
import java.util.Scanner;
class Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		int count = 0;
		for(int i = 1; i<=5; i++){
			int a = (int)(Math.random()*90)+10;
			int b = (int)(Math.random()*90)+10;
				
						System.out.println("["+i+"]"+ a +"+"+ b +"=");					
						System.out.println("숫자를 입력하세요");
							int number = scanner.nextInt();	
						if(a + b==number){
								System.out.println("잘했습니다.");
								
									count++;
						}else if(a + b!=number){
							System.out.println("틀렸습니다.");
								for(int j = 1; j<=1;){
								System.out.println("["+i+"]"+ a +"+"+ b +"=");
								System.out.println("숫자를 입력하세요");
									number = scanner.nextInt();
								if(a + b==number){
										System.out.println("잘했습니다.");						
											count++;
								}else {
										System.out.println("틀렸습니다.");
										break;
								}
								}//for
					}
					}//for	
				System.out.println("당신의 점수는" +count+"개 맞추어서" +(count*20)+"점 입니다.");
	}
			
}
