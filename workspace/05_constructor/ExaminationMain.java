import java.util.Scanner;
class Examination{
	
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	private static final String JUNG="11111";//  정답
	
	public Examination(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력: ");
		this.name = scanner.nextLine();
		System.out.print("답입력: ");
		dap = scanner.nextLine();
		
		ox = new char[5];
	}

	public void compare(){
			for(int i = 0; i < dap.length(); i++){
			if(JUNG.charAt(i) == dap.charAt(i)){
				ox[i]='o';
				score+=20;
			}else ox[i]='x';
		}
	}
	public String getName(){return name;}
	public char[] getOx(){return ox;}
	public int getScore(){return score;}

	}
	
class ExaminationMain{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print("인원수 입력: ");
		int count = scanner.nextInt();
		
		Examination[] ar = new Examination[count]; //배열이 2개 잡힌다.
		for(int i=0; i<count; i++){
			ar[i] = new Examination();
			ar[i].compare();
			System.out.println();
		}
		
		System.out.println("이름\t1 2 3 4 5\t점수");

		for(int i = 0; i<count; i++){
		System.out.print(ar[i].getName()+"\t");

		for(int j = 0; j<ar[i].getOx().length; j++){
		System.out.print(ar[i].getOx()[j]+"  ");
		}//for j
		
		System.out.println("\t"+ar[i].getScore());	
			
	}//for i
	}

}
