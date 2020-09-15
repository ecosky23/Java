import java.util.Scanner;
class ShapeTest{
	protected double area;

	public ShapeTest(){
		System.out.println("ShapeTest 기본생성자");}
	public void calcArea(){
		System.out.println("도형을 계산합니다.");}
	public void dispArea(){
		System.out.println("도형을 출력합니다.");
	}

}

class SamTest extends ShapeTest{
	protected int base, height; //필드 총 3개

	public SamTest(){
		System.out.println("SamTest 기본생성자");

		Scanner scanner = new Scanner(System.in);
		System.out.println("밑변: ");
		base = scanner.nextInt();
		System.out.println("높이: ");
		height = scanner.nextInt();
	}
		@Override
		public void calcArea(){
		area = (base*height)/2;}
		public void dispArea(){
		System.out.println(area);}
}

class SaTest extends ShapeTest{
	protected int width, height;

	public SaTest(){
		System.out.println("SaTest 기본생성자");

		Scanner scanner = new Scanner(System.in);
		System.out.println("밑변: ");
		width = scanner.nextInt();
		System.out.println("높이: ");
		height = scanner.nextInt();
	}
		@Override
		public void calcArea(){
		area = width*height;}
		public void dispArea(){
		System.out.println(area);}
}

class SadariTest extends ShapeTest{
	protected int top, bottom, height;

	public SadariTest(){
	
	System.out.println("SadariTest 기본생성자");

		Scanner scanner = new Scanner(System.in);
		System.out.println("밑변: ");
		bottom = scanner.nextInt();
		System.out.println("높이: ");
		height = scanner.nextInt();
		System.out.println("윗변: ");
		top = scanner.nextInt();
	}
	@Override
		public void calcArea(){
		area = (top+height)*height/2;}
		public void dispArea(){
		System.out.println(area);}
}

class ShapeMain{
	public static void main(String[] args) {
	/*	SamTest sam = new SamTest();
		sam.calcArea();
		sam.dispArea();
		
		SaTest sa = new SaTest();
		sa.calcArea();
		sa.dispArea();

		SadariTest sadari = new SadariTest();
		sadari.calcArea();
		sadari.dispArea();

		System.out.println();*/

		ShapeTest shape;
		shape = new SamTest();//부모가 자식을 참조한다. 부모 = 참조(다형성) 다양한 성질
		shape.calcArea();		//대신 자식이 부모를 참조하는경우는 안된다.
		shape.dispArea();
		System.out.println();

		shape = new SaTest();//부모가 자식을 참조한다. 부모 = 참조(다형성) 다양한 성질
		shape.calcArea();
		shape.dispArea();

		System.out.println();

		shape = new SadariTest();//부모가 자식을 참조한다. 부모 = 참조(다형성) 다양한 성질
		shape.calcArea();
		shape.dispArea();
		System.out.println();
	}
}
