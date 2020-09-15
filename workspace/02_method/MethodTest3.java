import java.util.Random;
class MethodTest3 {
	public static void main(String[] args) {
	System.out.println("큰값 = " + Math.max(25, 36));  //자바 클래스 안에 저장 되어있는 MATH값
	

	double power = Math.pow(2,5);
	System.out.println("제곱 값 = " +power);
	
	//난수 - 컴퓨터가 불규칙하게 발생하는 수, 0<난수<=1
	int a;
	a = (int)(Math.random()*100)+1; // 1~ 100
	System.out.println(a);
	
	Double b;
	
	Random r = new Random();
		b = r.nextDouble();
		System.out.println(b);
	}

}


/*
자바 - 메소드 - 

*/