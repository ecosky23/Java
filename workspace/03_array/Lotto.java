import java.util.Arrays;
import java.util.Scanner;
class Lotto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] lotto = new int[6];
		int count;
		int number;
		 //난수 발생 1~ 45
		 System.out.println("몇번 돌리시겠습니까? ");
		number = scanner.nextInt();
		count =(number*1000);
		for(int k = 0; k < number; k++){
			
		for(int i = 0; i < lotto.length; i++){
			lotto[i] = (int)(Math.random()*45)+1;
				for(int j = 0; j < i; j++){
					if(lotto[i] == lotto[j]){// i, j가 같으면 중복값 발생
					i--;// 3번방과 4번방의 같은 숫자가 나오면 숫자가 하나적어지고 다시 
						// i(for)문으로 돌아가 숫자가 커져서 다시 3이된다.
					break;//for j를 벗어나라
				}
			}//for j
			
		}//for i
				Arrays.sort(lotto);		
				for(int data:lotto){
				System.out.print(String.format("%5d", data));
		}//출력
			System.out.println();
		}//for k	
	System.out.println(count+"원 사용");
}
}
//돈입력 7000 한판에 1000원