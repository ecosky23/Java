/*
학생의 이름과 답안지를 입력 받아서 점수를 구하시오

[실행결과]
이름 입력: 홍길동
답안지 입력: "12141" 5문제의 답안

이름  1  2  3  4  5 점수 index[] 배열로 위 아래 첫번째거 비교 두번째거 비교for문 혹은 if문 으로 사용
홍길동 o  x  o  x  o 60점
문자형 변수
정수형 변수


*/

import java.util.Scanner;
class Quiz3{
	public static void main(String[] args) {
		final String ANSWER = "11111";   //상수화 문제의 정답
		String name, dab = "";
		int score = 0;
		char[] ox = new char[5];
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		name = scanner.nextLine();
		System.out.print("답안지를 입력하세요: ");
		dab = scanner.nextLine();
		
			
			for(int i = 0; 0 < 5; i++){
				
				if(ANSWER.charAt(i) == dab.charAt(i)){
					ox[i] = 'o';
					score = score+20;
				}else{	ox[i] = 'x';
						}
			System.out.printf("이름 1 2 3 4 5 점수");
			System.out.println(name+"\t\t");
			}
			
			
			for(int i = 0; i<ox.length; i++){
				System.out.println(ox[i]+" ");
			}
			System.out.println("\t"+score + "점");
			
	}
}
