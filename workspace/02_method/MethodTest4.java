class MethodTest4{
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		double b = Double.parseDouble(args[1]);
		//��ü���� �⺻������ ����ȯ�� �Ұ����ϴ�. String�� int�� ����ȯ �Ұ�
		// args[0]�� String Ÿ���̴�.
		//Intege.parseInt()String�� ������ �ٲ��ִ� �޼ҵ�

		System.out.println(a + " + " + b + " = " + (a + b));
	}
}
