class Final{
	public final String FRUIT="���";
	public final String FRUIT2;

	public static final String ANIMAL="����";
	public static final String ANIMAL2;
	static{ANIMAL2 = "�⸰";}
	public Final(){FRUIT2 = "����";}
}


class FinalMain{
	public static void main(String[] args) {
		final int AGE = 10;
		System.out.println("��� AGE =" +AGE);

		//AGE++; ERROR ����� ���Ҽ� ���� ���̱� ������ ���ϸ� �ȵȴ�

		final int AGE2;
		AGE2 = 20;
		System.out.println("��� AGE2 =" +AGE2);

		Final fi = new Final();
		
		System.out.println("FRUIT = "+fi.FRUIT);
		System.out.println("FRUIT2 = "+fi.FRUIT2);
		System.out.println("ANIMAL = "+fi.ANIMAL);
		System.out.println("ANIMAL2 = "+fi.ANIMAL2);
	}
}
