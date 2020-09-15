class AbstractMain extends AbstractTest{
	
	@Override
	public void setName(String name){// 추상클래스 때문에 반드시 override 해야한다.
		this.name = name;
	}

	public static void main(String[] args) {
	//	AbstractTest at = new AbstractTest();//추상클래스는 자체적인 메모리생성이 안된다.
		AbstractTest at = new AbstractMain();//생성은 자식꺼로하고 접근은 부모꺼로 접근
												//접근을 Main으로 하면 Test내부로 접근을 못함
	}
}

/*
abstract class AA{
	public abstract void sub();
	public void disp(){}
	}
class BB extends AA{
	public void sub(){} //Override해야한다.
	public void disp(){}
}


*/