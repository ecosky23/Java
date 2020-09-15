import java.util.Scanner;
class ExceptionTest{
	public static void main(String[] args){
		if(args.length > 0) System.out.println("args[0] = "+args[0]);
		System.out.println();

		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int num = scan.nextInt();
		
		try{
		int num2 = Integer.parseInt(args[0]);//정수형으로 전환
		//System.out.println(num+"/"+num2+"="+((double)num/num2)); double로 하고 0으로나누면 infinity가 뜬다
		}catch(NumberFormatException e){//숫자를 안넣어서 에러가 뜨면 나타나는 문구
			System.out.println("숫자만 입력하세요");//숫자이외의 것을 입력했을때 나타나는 문구
		}catch(ArithmeticException e){//0으로 나누었을때 나오는 경고 문구
			System.out.println("0으로 나누면 안됩니다.");
		}finally{//error가 있어도 무조건 실행
			System.out.println("error가 있건 없건 무조건 실행!!");
		}
	}
}
