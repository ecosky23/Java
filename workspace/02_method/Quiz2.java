/*
10���� ~ 99������ ������ 2�� �߻��Ͽ� ���� ���ߴ� ����
a = ���� �߻�    b =���� �߻�
[������]
12 + 36 = ����ڰ� �Է�
Ʋ�Ƚ��ϴ�.
�Ǵ�
12 + 36 = ����ڰ� �Է�
�����߾��
���� ����ڰ� �Է� = user

����� ������ x�� ���߾ x�� �Դϴ�.
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
						System.out.println("���ڸ� �Է��ϼ���");
							int number = scanner.nextInt();	
						if(a + b==number){
								System.out.println("���߽��ϴ�.");
								
									count++;
						}else if(a + b!=number){
							System.out.println("Ʋ�Ƚ��ϴ�.");
								for(int j = 1; j<=1;){
								System.out.println("["+i+"]"+ a +"+"+ b +"=");
								System.out.println("���ڸ� �Է��ϼ���");
									number = scanner.nextInt();
								if(a + b==number){
										System.out.println("���߽��ϴ�.");						
											count++;
								}else {
										System.out.println("Ʋ�Ƚ��ϴ�.");
										break;
								}
								}//for
					}
					}//for	
				System.out.println("����� ������" +count+"�� ���߾" +(count*20)+"�� �Դϴ�.");
	}
			
}
