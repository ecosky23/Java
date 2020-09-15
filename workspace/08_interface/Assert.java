import java.util.Scanner;
class Assert{
	Scanner scanner = new Scanner(System.in);
	private int x, y;

	public void input(){
			System.out.println("xÀÔ·Â");
			x = scanner.nextInt();		
				this.x = x;
	}

	public void output(){
		for(int i = 1; i < 10; i++){
			System.out.println(Math.pow(x,i));
		}
	}
	public static void main(String[] args){
		Assert ar = new Assert();
			ar.input();
			ar.output();
	}
}