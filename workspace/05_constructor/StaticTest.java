class StaticTest{
	private int a;//�ʵ�, �ν��Ͻ����� �� Ŭ���������� ��밡��
	private static int b;//�ʵ�, Ŭ���� ���� static������ ��𼭵� ��밡��, ��������

	static{
		System.out.println("�ʱ�ȭ ����");
		b=3;
	}

	public StaticTest(){
			System.out.println("�⺻ ������");
			a=3;
		}
		public void calc(){
			a++;
			b++;
		}

		public void disp(){
			System.out.println("a="+a+"\t b="+b);
		}
		
		public static void output(){
			System.out.println("static method...");
		//	System.out.println("a="+this.a+"\t b="+b); this�� static 
		//  ���� ���� ���ؼ� ������ ���

		}



	public static void main(String[] args) {
	StaticTest aa = new StaticTest();
		
		aa.calc();
		aa.disp();
		System.out.println();

		StaticTest bb = new StaticTest();
		bb.calc();
		bb.disp();
		System.out.println();

		StaticTest cc = new StaticTest();
		cc.calc();
		cc.disp();
		System.out.println();

		StaticTest.output();//ststic �޼ҵ�� new�� �����ʾƵ� Ŭ�����̸��� 
							//���� �޼ҵ�� �ٷ� ��밡���ϴ�.
		output();//Ŭ���� �������� Ŭ���� �̸��� �Ⱦ��� �޼ҵ常 �ᵵ ������ ���´�.
		aa.output();//�̷��� �ص� ���̳��´�.
	}
}//class staticTest
