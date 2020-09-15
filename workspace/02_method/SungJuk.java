//이름name 국어kor 영어eng 수학math 점수를 입력 받아서 총점tot과 평균avg을 구하시오
//단, 총점은 calcTot()구하여 반환 평균은 calcAvg()구하여 반환 출력은 disp()에서 하시오
//[실행결과]
//이름 입력:
//국어점수 입력: 90
//영어점수 입력: 90
//수학점수 입력: 91

//*** 홍길동 성적표 ***
// 국어 영어 수학 총점 평균
// 90  90  91 271 90.33
//1. 이름 국어 영어 수학 입력
//2. 함수 호출 - calcTot(
//3. 함수 호출 - calcAvg(
//4. 함수 호출 - disp(
import java.util.Scanner;
class SungJuk{
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("이름을 입력하세요: ");
	String name = scanner.nextLine();
	System.out.println("국어점수를 입력하세요: ");
	int kor = scanner.nextInt();
	System.out.println("수학점수를 입력하세요: ");
	int math = scanner.nextInt();
	System.out.println("영어점수를 입력하세요: ");
	int eng = scanner.nextInt();

	int calcTot = kor + math + eng;
	int calcAvg = calcTot/3;

	System.out.println("이름:" +name);
	}

	

}
