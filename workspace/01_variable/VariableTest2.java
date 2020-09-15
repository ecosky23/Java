class VariableTest2{
	int a; //필드, 초기화가 되어있다. 값은 0이다.
	static int b;//필드 but static가 있기 때문에 초기화해주지 않아도 된다.
	public static void main(String[] args) {

		int a = 10; //local variable(지역변수), garbage(쓰레기 값)
		System.out.println("a="+a);

		System.out.println("필드 a="+ new VariableTest2().a); //클래스의 값을 사용하기 위해서는
															//new를 써서 초기화해서 변수를 만들어준다
		System.out.println("필드 b="+ VariableTest2.b);
		System.out.println("필드 b="+ b);
	}
}
