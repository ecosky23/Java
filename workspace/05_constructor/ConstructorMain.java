class ConstructorTest{
	private String name;
	private int age;

	public ConstructorTest(){ //������
		System.out.println("default ������");
	}
	public ConstructorTest(String name){
		this();
		this.name = name;
	}
	public ConstructorTest(int age){//���� �޼ҵ忡�� 25�� �θ�
		this("�ڳ�"); //������ ���� �θ����� �ݵ�� ù��° �ٿ� �־���Ѵ�. �׸��� ���� ��Ʈ�� ������ �θ���.
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
	System.out.println("�̸� = "+aa.getName()+" ���� ="+aa.getAge());
	
	ConstructorTest	bb	= new ConstructorTest("ȫ�浿");
	System.out.println("�̸� = "+bb.getName()+" ���� ="+bb.getAge());	

	ConstructorTest	cc	= new ConstructorTest(25);
	System.out.println("�̸� = "+cc.getName()+" ���� ="+cc.getAge());

	}
}
