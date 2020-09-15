import java.util.Scanner;
class Baseball {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] user = new int[3];
		int[] com = new int[3];
		 int strike = 0;
		 int ball = 0;
		while(true){
		System.out.println("게임을 실행하겠습니까(Y/N)");
		String answer = scanner.nextLine();
		if(answer.equals("y") || answer.equals("Y")){
			System.out.println();
			System.out.println("게임을 시작합니다.");
		
			for(int i = 0; i < user.length; i++){
				for(int j =0; j < com.length; j++){
			
			System.out.println();		
			System.out.println("3가지 번호를 입력하세요");
			user[i] = scanner.nextInt();
			com[j] = (int)(Math.random()*9)+1;
			if(user[i] == com[j]){
				if(i==j)	
					strike++;
				}else{ 
				 ball++;
				}
			System.out.println("스트라이크: "+strike+"\t볼: "+ball);
			}//forj
			
			}//for i
			break;
			 
		}else{
			System.out.println("잘못 누르셨습니다.");	
		}
		
		
			
		
		
		}
		}
		}

