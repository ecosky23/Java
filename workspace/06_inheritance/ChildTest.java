class ChildTest extends SuperTest{//subtest�ʹ� ������� Ŭ�����̴�.
	private String name;
	private int age;
	public ChildTest(String name, int age, double weight, double height){
		System.out.println("ChildTest ������");
			this.name = name;
			this.age = age;
			super.weight = weight; //�θ�Ŭ�������� ��ӹ�����
			super.height = height; //this.height = height�� ����
	}
	
	public void disp(){//�θ�Ŭ������ stpertest���� disp�� �ִ� ������ �켱����
		System.out.println("�̸� = "+ name);//�ڽĿ��� �ִ�. so �ڽ�Ŭ������ childtest�� disp�� ����ǰ�
		System.out.println("���� = "+age);//�θ�Ŭ������ disp�� �������. �̰��� override�̴�.
		super.disp();//super�� �����ʰ� �����ϸ� 
	}


	public static void main(String[] args) {
		
		ChildTest aa = new ChildTest("ȫ�浿",25,72.5,175.3);
		aa.disp();
		SuperTest bb = new ChildTest("�ڳ�",13,40.3,153.8);//override�� ������ �ڽ��� ����
		bb.disp();
	}
}
