class Outer{
	private String name;
	
	public void output(){
		Inner in = new Inner(); //������ ������ ���ؼ��� ��ü�� �����ؾ� �Ѵ�.
		System.out.println("�̸�= "+this.name+"/t ����= "+in.age);
		//	System.out.println("�̸�= "+name+"/t"+age);  error
	}

	class Inner{//Outer�޸�Inner.class    Outer.class  Outer.java �̷��� ������ 3�� ����
		private int age;

		public void disp(){
			System.out.println("�̸�= "+Outer.this.name+"/t ����="+this.age);
		}
	}//class Inner

	public static void main(String[] args){
		Outer outer = new Outer();//Outer Ŭ������ �̿밡�� InnerŬ������ ���Ұ���
		outer.name = "ȫ�浿";

		Outer.Inner in2 = outer.new Inner();// Inner�� Outer���ο� �ִٴ� ���� ��������Ѵ�.
		in2.age=25;
		in2.disp();

		Outer.Inner in3 = outer.new Inner();
		in3.age=30;
		in3.disp();

		Outer.Inner in4 = new Outer().new Inner();
		//in4.name = "��ġ"; error
		in4.age=35;
		in4.disp();
	}
}//class Outer
