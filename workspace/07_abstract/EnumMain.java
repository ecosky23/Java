/*
class EnumColor{
	static final String RED = "����";
	static final String GREEN = "�ʷ�";
	static final String BLUE = "�Ķ�";
	static final String MAGENTA = "����";

}
*/
enum EnumColor {
	RED, GREEN, BLUE, MAGENTA//�ϳ��� ������ ��ó�� �����
}

class EnumMain{
	String colorName;
	EnumColor color;
	public static void main(String[] args) {
		System.out.println(EnumColor.RED);
		System.out.println();

		EnumMain em = new EnumMain();
		em.colorName = "����";
		em.color = EnumColor.RED;
		System.out.println(em.colorName+"\t"+em.color);

		em.colorName = "����";
		EnumColor VIOLET = EnumColor.MAGENTA;
		System.out.println(em.colorName+"\t"+VIOLET);//�ϳ��� ������ Ÿ������ ���
		System.out.println();

		for(EnumColor data : EnumColor.values()){
			System.out.println(data+"\t"
								+data.ordinal()+"\t"
								+data.valueOf(data+""));
								//+data.valueOf("BLACK")); �̷��� �ϸ� ������ ����.
		}


	}
}
//valueOf()
//String ���� enum���� �������� ���� ������ IllegalArgumentException �߻�