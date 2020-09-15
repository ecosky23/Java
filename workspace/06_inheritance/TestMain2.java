class AA{
	public int a = 3;//필드는 OVERRRIDE개념이 없다.
	public void disp(){
	
		a+= 5;
		System.out.println("AA : "+a+ " " );
	}

}

class BB extends AA{
	public int a = 8;
	public void disp(){
		this.a+= 5;//8+5
		System.out.println("BB : "+a+ " " );
	}

}

class TestMain2{
	public static void main(String[] args) {
		BB bb = new BB();
		bb.disp(); // BB: 13
		System.out.println(bb.a+ " " );//13

		AA aa = new BB();
		aa.disp();//BB:13 override기 때문에 aa가 아닌 자식의 BB를 계산한다.
		System.out.println(aa.a+ " " );//3  메소드가 아닌 필드와 변수는 OVERRIDE가 안된다

		//BB bb2 = aa; 에러가 뜸 부모는 자식을 참조하지만 자식은 부모를 참조못한다.자식 =(자식)부모 
		BB bb2 = (BB)aa;
		System.out.println(bb2.a+ " " );//13 
	}
}
