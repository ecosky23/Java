class Quiz 21 {
	public static void main(String[] args) {
		import java.util.Scanner;
class Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		int count = 0;
		for(int i = 1; i<=5; i++){
			int a = (int)(Math.random()*90)+10;
			int b = (int)(Math.random()*90)+10;
			for(int j = 1; j<=2; j++){
			System.out.println("["+i+"]"+ a +"+"+ b +"=");

			}

		}
	}
}
