class VariableTest {
	public static void main(String[] args){
		boolean a = true; // ���ͷδ� 1�� ����.
		System.out.println("a="+a);

		char b = 'A';
		System.out.println("b="+b);

		char c = 65;
		System.out.println("c="+c);

		//char d = 65536;  char�� �ִ�ũ�Ⱑ 65535�� 65536�� ũ�Ⱑ �Ѿ ������ ���
		//System.out.println("d="+d);
		int e = 65;
		System.out.println("e="+e);

		int f = 'A';
		System.out.println("f="+f);

		// float g = 43.8; - error 43.8�� double���̶� float���� ������ �ַ��� ���
		// double g = 43.8;
		float g = (float)43.8; 
		//float g = 43.8f;
		//���� ���� double�� float�� ����ȯ�ϴ°��̰� �ڿ����� ������ float������ �¾���̴�.
		System.out.println("g="+g);



	}
}




