import java.util.Scanner;
class Baseball {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] user = new int[3];
		int[] com = new int[3];
		 int strike = 0;
		 int ball = 0;
		while(true){
		System.out.println("������ �����ϰڽ��ϱ�(Y/N)");
		String answer = scanner.nextLine();
		if(answer.equals("y") || answer.equals("Y")){
			System.out.println();
			System.out.println("������ �����մϴ�.");
		
			for(int i = 0; i < user.length; i++){
				for(int j =0; j < com.length; j++){
			
			System.out.println();		
			System.out.println("3���� ��ȣ�� �Է��ϼ���");
			user[i] = scanner.nextInt();
			com[j] = (int)(Math.random()*9)+1;
			if(user[i] == com[j]){
				if(i==j)	
					strike++;
				}else{ 
				 ball++;
				}
			System.out.println("��Ʈ����ũ: "+strike+"\t��: "+ball);
			}//forj
			
			}//for i
			break;
			 
		}else{
			System.out.println("�߸� �����̽��ϴ�.");	
		}
		
		
			
		
		
		}
		}
		}

