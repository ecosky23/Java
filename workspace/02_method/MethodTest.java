class MethodTest {
	public void disp(){
		System.out.println("non-static �޼ҵ�");
	}

	public static void print(){
		System.out.println("static �޼ҵ�");
	}
	public static void main(String[] args){
		
		MethodTest.print(); //ȣ��
		System.out.println();
		//new MethodTest().disp(); //static�� ���� ������ new�� �ٿ��� �Ѵ�.
	
	MethodTest aa; //Ŭ������ ����, ��ü
	aa = new MethodTest();
	System.out.println("��ü aa = "+aa);
	System.out.println("��ü aa = "+aa.toString()); //toString ���ڿ��� ��ȯ�ϰ� ��
	System.out.println("��ü aa = "+aa.hashCode()); //hashCode 10������ ��µǰ� ��
	aa.disp();

	//int aa;; //������ ����
	//double aa;; //�Ǽ��� ����
	//char aa;; // ������ ����
	
	}
}

/*
�޼ҵ�()
-��ɾ���� ����ü���� �ݵ�� �Լ�(�޼ҵ�)�ȿ� �־�� �Ѵ�.
*/
