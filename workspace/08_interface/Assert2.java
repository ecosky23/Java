import java.util.Scanner;
class Assert2{
	
	private int x, y;

	public void input(){
		Scanner scanner = new Scanner(System.in);
			System.out.println("x입력");
			x = scanner.nextInt();
			System.out.println("y입력");
			y = scanner.nextInt();
			this.x = x;
			this.y = y;
	}
			
	public void output(){
		assert y>=0 : "y는 0보다 크거나 같아야한다.";
		//javac -source 1.8 Arssert2.java
		//java -ea Assert
		//ea 는 assert를 처리하겠다
		//da 는 assert를 처리안하겠다.

		int mul=1;
		for(int i = 1; i < y; i++){
			mul*=x;
			
		}
		System.out.println(x+"의 " +y+"승은 "+ mul);
	}
	public static void main(String[] args){
		Assert2 arc = new Assert2();
			arc.input();
			arc.output();
	}
}