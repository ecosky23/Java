class StringMain{
	public static void main(String[] args) {
		String aa = "apple";//leteral ���� ����, aa �ּҰ��� apple�� ����
		String bb = "apple";// bb�ּҰ��� ���� �޸𸮿� ���� apple����

		if(aa==bb)System.out.println("aa�� bb�� ������(�ּҾ���)�� ����");
		else System.out.println("aa�� bb�� �������� �ٸ���");

		if(aa.equals(bb))System.out.println("aa�� bb�� ���ڿ��� ����");
		else System.out.println("aa�� bb�� ���ڿ��� �ٸ���.");
		System.out.println();

		String cc = new String("apple");//cc �ּҰ��� String�ȿ� apple�� ����
		String dd = new String("apple");//dd �ּҰ��� String�ȿ� apple�� ����

		if(cc == dd)System.out.println("cc�� dd�� �������� ����");
		else System.out.println("cc�� dd�� �������� �ٸ���");

		if(cc.equals(dd))System.out.println("cc�� dd�� ���ڿ��� ����");
		else System.out.println("cc�� dd�� ���ڿ��� �ٸ���.");
		System.out.println();

		String ee = "���� ��¥�� "+2020+4+13;//���ڿ�
		System.out.println(ee);

		/*
		���ڿ��� ������ �ȵǹǷ� �޸� 4�� �����ȴ�
		JVM�� ���ؼ� ���� �� Garbage Collector�� ������
		Garbage Collector�� ����Ǹ� ��ǻ�ʹ� �����.

		"���� ��¥�� "
		"���� ��¥�� 2020"
		"���� ��¥�� 20204"
		ee --> "���� ��¥�� 2020413"
		*/

			System.out.println("���ڿ��� ũ��= "+ ee.length());//14
			System.out.println("���� ���� =  "+ ee.charAt(4));//¥

			System.out.println("���ڿ��� ����= "+ ee.substring(7));//2020413
			System.out.println("���ڿ��� ����= "+ ee.substring(7,11));//2020

			System.out.println("�빮�� ����= "+ "Hello".toUpperCase());
			System.out.println("�ҹ��� ����= "+ "Hello".toLowerCase());

			System.out.println("���ڿ� �˻�= "+ ee.indexOf("¥"));//4
			System.out.println("���ڿ� �˻�= "+ ee.indexOf("��¥"));//3
			System.out.println("���ڿ� �˻�= "+ ee.indexOf("���ٺ�"));//-1

			System.out.println("���ڿ� ġȯ="+ee.replace("����","����"));
	}
}

//indexOf(?,?)�Ű����� 2������ ���� ã�ƾ� ������ Ǯ���ִ�.
