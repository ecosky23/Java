/*
가위 바위 보 게임
가위는 1, 바위는 2, 보자기는 3으로 설정하겠다. 난수설정
컴퓨터는 1~3사이의 난수 발생
while문으로 무한반복
돈은 1000원으로 시작한다.
[실행결과]
********
1. 가위 
2. 바위
3. 보
********
번호 입력: 2

배팅금액: 200

결과를 보려면 Enter를 치세요:

컴퓨터: 가위   나: 바위

You win.. 당신의 금액은 1200원 입니다.

*/

import java.util.Scanner;
class Game{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int money = 1000;
		int count = 200;
		String yn;
		while(true){
		int cn = (int)(Math.random()*3)+1;
		System.out.println();
		System.out.println("[실행결과]");
		System.out.println("**********");
		System.out.println("1. 가위");
		System.out.println("2. 바위");
		System.out.println("3. 보");
		System.out.println("**********");
		System.out.println();
		System.out.print("번호 입력: ");
		int number = scanner.nextInt();
		scanner.nextLine();
		System.out.println("결과를 보려면 ENTER를 치세요!!!!!");
		String result = scanner.nextLine();
		
		if(number == cn){
			System.out.println("비겼습니다.");
			if(number == 1){System.out.print("나: 가위\t");
				if(cn == 1){System.out.println("컴퓨터: 가위");}
					}else if(number == 2){System.out.print("나: 바위\t");
				if(cn == 2){System.out.println("컴퓨터: 바위");}
					}else if(number == 3){
						System.out.print("나: 보\t");
				if(cn == 3){System.out.println("컴퓨터: 보");}
			}	
		}else if(number==1 && cn==3 || 
				number==2 && cn==1 ||
				number==3 && cn==2){
				money += count;
				if(number == 1){System.out.println("나: 가위\t컴퓨터: 보");
					}else if(number ==2){System.out.println("나: 바위\t컴퓨터: 가위");
					}else if(number ==3){System.out.println("나: 보\t컴퓨터: 바위");}
				System.out.println();
				System.out.println("You win!!! 당신의 금액은"+money+"입니다.");
		}else if(number==1 && cn==2 || 
				number==2 && cn==3 || 
				number==3 && cn==1){
				money -= count;
				if(number==1){System.out.println("나: 가위\t컴퓨터: 바위");
					}else if(number==2){System.out.println("나: 바위\t컴퓨터: 보");		
					}else if(number==3){System.out.println("나: 보\t컴퓨터: 가위");}	
				System.out.println();
				System.out.println("You lose"+money+"원 남았습니다.");}
			if(money == 0){
					System.out.println("또할랭(Y/N)");
					yn = scanner.next();

					if(yn.equals("N") || yn.equals("n"))break;//for을 벗어나라
					else money =1000;
			}
		}//while
		System.out.println("프로그램을 종료합니다.");
	}//메인메소드
}//클래스
