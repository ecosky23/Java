class AA{
	public int a = 3;//�ʵ�� OVERRRIDE������ ����.
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
		aa.disp();//BB:13 override�� ������ aa�� �ƴ� �ڽ��� BB�� ����Ѵ�.
		System.out.println(aa.a+ " " );//3  �޼ҵ尡 �ƴ� �ʵ�� ������ OVERRIDE�� �ȵȴ�

		//BB bb2 = aa; ������ �� �θ�� �ڽ��� ���������� �ڽ��� �θ� �������Ѵ�.�ڽ� =(�ڽ�)�θ� 
		BB bb2 = (BB)aa;
		System.out.println(bb2.a+ " " );//13 
	}
}
