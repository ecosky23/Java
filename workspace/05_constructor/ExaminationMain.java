import java.util.Scanner;
class Examination{
	
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	private static final String JUNG="11111";//  ����
	
	public Examination(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸� �Է�: ");
		this.name = scanner.nextLine();
		System.out.print("���Է�: ");
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

		System.out.print("�ο��� �Է�: ");
		int count = scanner.nextInt();
		
		Examination[] ar = new Examination[count]; //�迭�� 2�� ������.
		for(int i=0; i<count; i++){
			ar[i] = new Examination();
			ar[i].compare();
			System.out.println();
		}
		
		System.out.println("�̸�\t1 2 3 4 5\t����");

		for(int i = 0; i<count; i++){
		System.out.print(ar[i].getName()+"\t");

		for(int j = 0; j<ar[i].getOx().length; j++){
		System.out.print(ar[i].getOx()[j]+"  ");
		}//for j
		
		System.out.println("\t"+ar[i].getScore());	
			
	}//for i
	}

}
