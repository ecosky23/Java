import java.util.Scanner;
class ShapeTest{
	protected double area;

	public ShapeTest(){
		System.out.println("ShapeTest �⺻������");}
	public void calcArea(){
		System.out.println("������ ����մϴ�.");}
	public void dispArea(){
		System.out.println("������ ����մϴ�.");
	}

}

class SamTest extends ShapeTest{
	protected int base, height; //�ʵ� �� 3��

	public SamTest(){
		System.out.println("SamTest �⺻������");

		Scanner scanner = new Scanner(System.in);
		System.out.println("�غ�: ");
		base = scanner.nextInt();
		System.out.println("����: ");
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
		System.out.println("SaTest �⺻������");

		Scanner scanner = new Scanner(System.in);
		System.out.println("�غ�: ");
		width = scanner.nextInt();
		System.out.println("����: ");
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
	
	System.out.println("SadariTest �⺻������");

		Scanner scanner = new Scanner(System.in);
		System.out.println("�غ�: ");
		bottom = scanner.nextInt();
		System.out.println("����: ");
		height = scanner.nextInt();
		System.out.println("����: ");
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
		shape = new SamTest();//�θ� �ڽ��� �����Ѵ�. �θ� = ����(������) �پ��� ����
		shape.calcArea();		//��� �ڽ��� �θ� �����ϴ°��� �ȵȴ�.
		shape.dispArea();
		System.out.println();

		shape = new SaTest();//�θ� �ڽ��� �����Ѵ�. �θ� = ����(������) �پ��� ����
		shape.calcArea();
		shape.dispArea();

		System.out.println();

		shape = new SadariTest();//�θ� �ڽ��� �����Ѵ�. �θ� = ����(������) �پ��� ����
		shape.calcArea();
		shape.dispArea();
		System.out.println();
	}
}
