import java.util.Arrays;
import java.util.Scanner;
class Lotto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] lotto = new int[6];
		int count;
		int number;
		 //���� �߻� 1~ 45
		 System.out.println("��� �����ðڽ��ϱ�? ");
		number = scanner.nextInt();
		count =(number*1000);
		for(int k = 0; k < number; k++){
			
		for(int i = 0; i < lotto.length; i++){
			lotto[i] = (int)(Math.random()*45)+1;
				for(int j = 0; j < i; j++){
					if(lotto[i] == lotto[j]){// i, j�� ������ �ߺ��� �߻�
					i--;// 3����� 4������ ���� ���ڰ� ������ ���ڰ� �ϳ��������� �ٽ� 
						// i(for)������ ���ư� ���ڰ� Ŀ���� �ٽ� 3�̵ȴ�.
					break;//for j�� �����
				}
			}//for j
			
		}//for i
				Arrays.sort(lotto);		
				for(int data:lotto){
				System.out.print(String.format("%5d", data));
		}//���
			System.out.println();
		}//for k	
	System.out.println(count+"�� ���");
}
}
//���Է� 7000 ���ǿ� 1000��