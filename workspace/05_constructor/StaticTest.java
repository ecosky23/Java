class StaticTest{
	private int a;//필드, 인스턴스변수 이 클래스에서만 사용가능
	private static int b;//필드, 클래스 변수 static에서는 어디서든 사용가능, 공유변수

	static{
		System.out.println("초기화 영역");
		b=3;
	}

	public StaticTest(){
			System.out.println("기본 생성자");
			a=3;
		}
		public void calc(){
			a++;
			b++;
		}

		public void disp(){
			System.out.println("a="+a+"\t b="+b);
		}
		
		public static void output(){
			System.out.println("static method...");
		//	System.out.println("a="+this.a+"\t b="+b); this는 static 
		//  에서 쓰지 못해서 에러가 뜬다

		}



	public static void main(String[] args) {
	StaticTest aa = new StaticTest();
		
		aa.calc();
		aa.disp();
		System.out.println();

		StaticTest bb = new StaticTest();
		bb.calc();
		bb.disp();
		System.out.println();

		StaticTest cc = new StaticTest();
		cc.calc();
		cc.disp();
		System.out.println();

		StaticTest.output();//ststic 메소드는 new를 하지않아도 클래스이름을 
							//통해 메소드로 바로 사용가능하다.
		output();//클래스 내에서는 클래스 이름을 안쓰고 메소드만 써도 내용이 나온다.
		aa.output();//이렇게 해도 답이나온다.
	}
}//class staticTest
