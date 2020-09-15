class Outer{
	private String name;
	
	public void output(){
		Inner in = new Inner(); //내부의 변수를 위해서는 객체를 선언해야 한다.
		System.out.println("이름= "+this.name+"/t 나이= "+in.age);
		//	System.out.println("이름= "+name+"/t"+age);  error
	}

	class Inner{//Outer달리Inner.class    Outer.class  Outer.java 이렇게 파일이 3개 생김
		private int age;

		public void disp(){
			System.out.println("이름= "+Outer.this.name+"/t 나이="+this.age);
		}
	}//class Inner

	public static void main(String[] args){
		Outer outer = new Outer();//Outer 클래스만 이용가능 Inner클래스는 사용불가능
		outer.name = "홍길동";

		Outer.Inner in2 = outer.new Inner();// Inner가 Outer내부에 있다는 것을 적어줘야한다.
		in2.age=25;
		in2.disp();

		Outer.Inner in3 = outer.new Inner();
		in3.age=30;
		in3.disp();

		Outer.Inner in4 = new Outer().new Inner();
		//in4.name = "또치"; error
		in4.age=35;
		in4.disp();
	}
}//class Outer
