class SubTest extends SuperTest{
	private String name;
	private int age;
	
	public SubTest(String name, int age, double weight, double height){
		System.out.println("SubTest ������");
			this.name = name;
			this.age = age;
			super.weight = weight; //�θ�Ŭ�������� ��ӹ�����
			super.height = height; //this.height = height�� ����
	}		
	
	public void output(){
		System.out.println("�̸� = "+ name);
		System.out.println("���� = "+age);
		//System.out.println("������ = "+weight);
		//System.out.println("Ű = "+height);
		disp();
	}



	public static void main(String[] args){
		SubTest aa = new SubTest("ȫ�浿",25,72.5,175.3);//�ڽ��� ��ü�� �����Ҷ� �����ڸ� 
														//�θ��µ� �ڽŰſ� �θ�� 2�� �θ��Եȴ�.
													//aa�� �ּҿ��� supertest�� subtest
													//2������ Ŭ������ �����Ѵ�.
	
		aa.output();
		System.out.println("----------");
		aa.disp();
		System.out.println("=================");
		
		SuperTest bb = new SubTest("�ڳ�",13,40.3,153.8);
	//	bb.output();// - error �̰��� ���θ���. bb�� supertest�� ��ü�� �ؼ� �����ϱ� ������
					// subtest�� �ִ� �޼ҵ�� ����Ұ����ϴ�.
		bb.disp();//�̰��� �����ϴ� supertest�� disp�޼ҵ尡 �����ϱ� ������
	}
}
