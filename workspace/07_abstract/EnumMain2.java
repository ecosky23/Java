enum EnumColor2{
	//enum ��ȣ���� �����ʹ� �����ڷ� ���޵ȴ�.
	RED("����"), GREEN("�ʷ�"), BLUE("�Ķ�"), MAGENTA("����");//1.������ ���ξ��� ���� ��Ʈ������ 
	private String colorName;

//	public ���� �ȵȴ�, private or default ����Ѵ�.
	EnumColor2(String colorName){//2. ���� ������� colorName�� ����
		this.colorName = colorName;//3. this.colorName�� ������ ����
	}
	public String getColorName(){
		return colorName;
	}

}



class EnumMain2{
	public static void main(String[] args) {
		System.out.println(EnumColor2.RED);
		System.out.println();

		for(EnumColor2 data : EnumColor2.values()){
			System.out.println(data+"\t"
								+data.ordinal()+"\t"
								+data.valueOf(data+"")
								+data.getColorName());
	}
}
}