class Test{
	@Override
		public String toString(){
		return getClass()+"@���ٺ�";//getclass�� ���� Ŭ������ ��(class test)�� �����´�.
	}
	}

class Sample{}


class ObjectMain extends Object{
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("��ü t =" + t);//��ü t =Test@15db9742
		System.out.println("��ü t =" + t.toString());//���� �ּҿ� �Ȱ��� ����
		System.out.println();

		Sample s = new Sample();
		System.out.println("��ü s =" + s);
		System.out.println("��ü s =" + s.toString());//Sample@15db9742
		System.out.println("��ü s =" + s.hashCode());//���� 16������ 10������ ���´� 366712642

		String str = "apple";
		System.out.println("��ü str =" + str);//apple
		System.out.println("��ü str =" + str.toString());
		System.out.println("��ü str =" + str.hashCode());//���� ����

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : "+(cc==dd));//false �ּҰ�(������) ���ϴ� �� �����ٸ���
		System.out.println("cc.equals(dd) : "+cc.equals(dd));//false
		System.out.println();

		Object ee = new Object("apple");
		Object ff = new Object("apple");
		System.out.println("ee==ff : "+(ee==ff));//false �ּҰ� ��
		System.out.println("ee.equals(ff) : "+ee.equals(ff));//true ���ڿ� apple ��
	}
}
/*
class Object{
	public String toString(){// Ŭ����@16����
	public int hashCode(){}//�ּ� ���� 10������ ����
	public boolean equals(Object){}//������ ��
	}
}

public String extends Object{
	public String toString(){} //���ڿ�
	public int hashCode(){}// ���ڿ��� 10������ ���� ��Ų�� (���ڿ� ���� ����)
	public boolean equals(Object){}//���ڿ��� �����ִ� ��
}

*/