class MethodTest {
	public void disp(){
		System.out.println("non-static 메소드");
	}

	public static void print(){
		System.out.println("static 메소드");
	}
	public static void main(String[] args){
		
		MethodTest.print(); //호출
		System.out.println();
		//new MethodTest().disp(); //static이 없기 때문에 new를 붙여야 한다.
	
	MethodTest aa; //클래스형 변수, 객체
	aa = new MethodTest();
	System.out.println("객체 aa = "+aa);
	System.out.println("객체 aa = "+aa.toString()); //toString 문자열로 전환하게 함
	System.out.println("객체 aa = "+aa.hashCode()); //hashCode 10진수로 출력되게 함
	aa.disp();

	//int aa;; //정수형 변수
	//double aa;; //실수형 변수
	//char aa;; // 문자형 변수
	
	}
}

/*
메소드()
-명령어들의 집합체들은 반드시 함수(메소드)안에 넣어야 한다.
*/
