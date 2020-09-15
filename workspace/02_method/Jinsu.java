//10진수를 입력 받아서 2진수, 8진수 , 16진수로 출력하시오
//단 Integer에 변환시켜주는 메소드를 찾으시오
//
//[실행결과]
//10진수 입력 : 250
//2진수 = 11111010
//8진수 =
//16진수 = 
import java.util.Scanner;
class Jinsu {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("10진수 입력: ");
	int dec = scan.nextInt();
	String binary = Integer.toBinaryString(dec);
	String oct = Integer.toOctalString(dec);
	String hexa = Integer.toHexString(dec);
	
		System.out.println("2진수 = "+binary);
		System.out.println("8진수 = "+oct);
		System.out.println("16진수 = "+hexa);
	
	}
}
