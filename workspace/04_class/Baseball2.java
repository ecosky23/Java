import java.util.Scanner;
class Baseball2{
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int com[] = new int[3]; 
		int user[] = new int[3];
		
		do{
		if(choice=='y' || choice =='Y'){

		for(int i = 0; i < com.length; i++){
		com[i] = (int)(Math.random()*)+1;
		for(int k = 0; k < i; k++){
			if(com[i] == com[k]){
			i--;
			break;
			}
		}//k
		}//i
		System.out.println(strike + "스트라이크"+ ball + "볼");
		//게임시작
		while(true){
			System.out.println("숫자 3개 입력");
			for(int i = 0; i<use.length; i++){
				user[i] = System.in.read() -'0';//'0'문자0은 아스키 코드 48이다.										//'A'대문자 A는 아스키 코드 65이다.
			}//for i
			System.out.read();
			System.out.read();
			System.out.println(com[0]+","+com[1]+","+com[2]);
			
			strike = ball =0;
			for(int i= 0; i < com.length; i++){
				for(int k = 0; k<user.length; k++){
				if(com[i] = user[k]){
				if(i == k) strike++;
				else ball++;
				}
				}
			}
			
			if(strike == 3){
				System.out.println("삼진 아웃! 게임끝");
			}
		}//while
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
