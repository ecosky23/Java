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
		System.out.println(strike + "��Ʈ����ũ"+ ball + "��");
		//���ӽ���
		while(true){
			System.out.println("���� 3�� �Է�");
			for(int i = 0; i<use.length; i++){
				user[i] = System.in.read() -'0';//'0'����0�� �ƽ�Ű �ڵ� 48�̴�.										//'A'�빮�� A�� �ƽ�Ű �ڵ� 65�̴�.
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
				System.out.println("���� �ƿ�! ���ӳ�");
			}
		}//while
		}
		System.out.println("���α׷��� �����մϴ�.");
	}
}
