import java.util.Scanner;
public class Baseball1 {
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] com = new int[3];
		
		while(true) { 
			com[0] = (int)(Math.random()*9)+1;
			com[1] = (int)(Math.random()*9)+1;
			com[2] = (int)(Math.random()*9)+1;
			
			if(com[0]!=com[1] && 
				com[0]!=com[2] && 
				com[1]!=com[2]  ) {
				break;
			}
		}
		int randomBall = com[0]*100+com[1]*10+com[2];
		int count = 0; 
		int strike = 0; 
		int ball = 0; 
		int out = 0; 
		
		while(true) {
			System.out.println("������ �����ϰڽ��ϱ�(Y/N)");
			String answer = sc.nextLine();
			if(answer.equals("y") || answer.equals("Y")){
			System.out.println();
			for(;;){
			System.out.println("������ �����մϴ�.");
			System.out.println();
			System.out.println("��ȣ�� �Է��ϼ���");
			int playball = sc.nextInt(); 
			count++;
			strike = 0;
			ball = 0;
			out = 0;		
			for(int i=2; i>=0; i--) {
				int tempStrike = strike;
				int tempBall = ball;
				if(com[i]==playball%10) { 
					strike++;
				} else { 
					for(int j=2; j>=0; j--) {
						if(com[j]==playball%10) {
							ball++;
						}
					}
				}
				if(tempStrike==strike && tempBall==ball) { 
					out++;
				}
				playball/=10; 	
			}
			System.out.println(count + "��Ʈ����ũ: "+strike+" ��: "+ball+"�ƿ�: "+out);
			
			if(strike==3) {
				System.out.println("����!!!!!!!!");
				break;
			}
			}
			break;
		}
		
	}
	
}
}


