class AA{}

class BB extends AA{}

//다형성 -> 여러가지의 형태의것을 다 받아준다. 부모클래스가 자식클래스에 다형성을 가진다.

class InstanceOf{
	public static void main(String[] args){
		AA aa = new AA();
		AA bb = new BB();
		AA aa2 = new BB();

		AA aa3 = aa;
		if(aa instanceof AA) System.out.println("1.TRUE");//aa가 AA와 클래스가 같은지
		else System.out.println("1.FALSE");		//aa는 casting이 된다.
												//aa가 가리키는 곳에는 AA타입의 클래스가 있다.
		AA aa4 = bb;//부모 = 자식 자식의 것은 부모에게 갈수있다.
		if(bb instanceof AA) System.out.println("2.TRUE");
		else System.out.println("2.FALSE");

//		BB bb2 = aa; ERROR 부모의 값은 자식에게 못간다. 하려면 부모가 자식으로 케스팅해야한다.
		BB bb2 = (BB)aa2;	//자식 = (자식)부모 이렇게 자식으로 형변환 해야한다. 
		if(aa2 instanceof BB) System.out.println("3.TRUE");
		else System.out.println("3.FALSE");

		//BB bb3 = (BB)aa; error 자체적으로 BB가 만들어진적이 없어서 aa는 캐스팅이 안된다.
		if(aa instanceof BB) System.out.println("4.TRUE");
		else System.out.println("4.FALSE");
	}											
}
 