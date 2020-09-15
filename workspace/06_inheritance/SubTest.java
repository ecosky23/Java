class SubTest extends SuperTest{
	private String name;
	private int age;
	
	public SubTest(String name, int age, double weight, double height){
		System.out.println("SubTest 생성자");
			this.name = name;
			this.age = age;
			super.weight = weight; //부모클래스에서 상속받은것
			super.height = height; //this.height = height도 가능
	}		
	
	public void output(){
		System.out.println("이름 = "+ name);
		System.out.println("나이 = "+age);
		//System.out.println("몸무게 = "+weight);
		//System.out.println("키 = "+height);
		disp();
	}



	public static void main(String[] args){
		SubTest aa = new SubTest("홍길동",25,72.5,175.3);//자식은 객체를 생성할때 생성자를 
														//부르는데 자신거와 부모거 2번 부르게된다.
													//aa의 주소에는 supertest와 subtest
													//2가지의 클래스가 존재한다.
	
		aa.output();
		System.out.println("----------");
		aa.disp();
		System.out.println("=================");
		
		SuperTest bb = new SubTest("코난",13,40.3,153.8);
	//	bb.output();// - error 이것은 못부른다. bb가 supertest를 객체로 해서 실행하기 때문에
					// subtest에 있는 메소드는 실행불가능하다.
		bb.disp();//이것은 가능하다 supertest에 disp메소드가 존재하기 때문에
	}
}
