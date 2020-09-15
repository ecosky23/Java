class ConstructorTest{
	private String name;
	private int age;

	public ConstructorTest(){ //생성자
		System.out.println("default 생성자");
	}
	public ConstructorTest(String name){
		this();
		this.name = name;
	}
	public ConstructorTest(int age){//메인 메소드에서 25를 부름
		this("코난"); //생성자 끼리 부를때는 반드시 첫번째 줄에 있어야한다. 그리고 위의 스트링 네임을 부른다.
		this.age = age;
		
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	
}



class ConstructorMain{
	public static void main(String[] args) {
	ConstructorTest	aa	= new ConstructorTest();
	System.out.println("이름 = "+aa.getName()+" 나이 ="+aa.getAge());
	
	ConstructorTest	bb	= new ConstructorTest("홍길동");
	System.out.println("이름 = "+bb.getName()+" 나이 ="+bb.getAge());	

	ConstructorTest	cc	= new ConstructorTest(25);
	System.out.println("이름 = "+cc.getName()+" 나이 ="+cc.getAge());

	}
}
