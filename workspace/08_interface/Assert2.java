import java.util.Scanner;
class Assert2{
	
	private int x, y;

	public void input(){
		Scanner scanner = new Scanner(System.in);
			System.out.println("x�Է�");
			x = scanner.nextInt();
			System.out.println("y�Է�");
			y = scanner.nextInt();
			this.x = x;
			this.y = y;
	}
			
	public void output(){
		assert y>=0 : "y�� 0���� ũ�ų� ���ƾ��Ѵ�.";
		//javac -source 1.8 Arssert2.java
		//java -ea Assert
		//ea �� assert�� ó���ϰڴ�
		//da �� assert�� ó�����ϰڴ�.

		int mul=1;
		for(int i = 1; i < y; i++){
			mul*=x;
			
		}
		System.out.println(x+"�� " +y+"���� "+ mul);
	}
	public static void main(String[] args){
		Assert2 arc = new Assert2();
			arc.input();
			arc.output();
	}
}