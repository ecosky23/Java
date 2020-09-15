class ChildTest extends SuperTest{//subtest와는 상관없는 클레스이다.
	private String name;
	private int age;
	public ChildTest(String name, int age, double weight, double height){
		System.out.println("ChildTest 생성자");
			this.name = name;
			this.age = age;
			super.weight = weight; //부모클래스에서 상속받은것
			super.height = height; //this.height = height도 가능
	}
	
	public void disp(){//부모클레스인 stpertest에도 disp가 있다 하지만 우선권은
		System.out.println("이름 = "+ name);//자식에게 있다. so 자식클래스인 childtest의 disp가 실행되고
		System.out.println("나이 = "+age);//부모클래스의 disp는 사라진다. 이것이 override이다.
		super.disp();//super을 쓰지않고 실행하면 
	}


	public static void main(String[] args) {
		
		ChildTest aa = new ChildTest("홍길동",25,72.5,175.3);
		aa.disp();
		SuperTest bb = new ChildTest("코난",13,40.3,153.8);//override는 무조건 자식을 실행
		bb.disp();
	}
}
