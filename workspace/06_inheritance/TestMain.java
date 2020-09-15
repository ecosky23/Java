class Test{
	int a, b;
}

// default 자신의 폴더안의 것들은 같이사용할 수 있다.
class TestMain{
	public static void main(String[] args) {
		Test aa = new Test();
		Test bb = aa; //aa의 주소값이 이동한다.
			aa.a = 10;
			aa.b = 20;
			System.out.println(aa.a+"\t"+aa.b);//10 20
			System.out.println(bb.a+"\t"+bb.b);
	
		bb.a = 30;
		bb.b = 40;
		System.out.println(aa.a+"\t"+aa.b);//30 40
		System.out.println(bb.a+"\t"+bb.b);//30 40
		
		bb = new Test();

		bb.a = 50;
		bb.b = 60;
		System.out.println(aa.a+"\t"+aa.b);//30 40
		System.out.println(bb.a+"\t"+bb.b);//50 60
	}
}
