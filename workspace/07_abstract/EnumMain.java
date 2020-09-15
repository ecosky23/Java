/*
class EnumColor{
	static final String RED = "빨강";
	static final String GREEN = "초록";
	static final String BLUE = "파랑";
	static final String MAGENTA = "보라";

}
*/
enum EnumColor {
	RED, GREEN, BLUE, MAGENTA//하나의 데이터 값처럼 사용함
}

class EnumMain{
	String colorName;
	EnumColor color;
	public static void main(String[] args) {
		System.out.println(EnumColor.RED);
		System.out.println();

		EnumMain em = new EnumMain();
		em.colorName = "빨강";
		em.color = EnumColor.RED;
		System.out.println(em.colorName+"\t"+em.color);

		em.colorName = "보라";
		EnumColor VIOLET = EnumColor.MAGENTA;
		System.out.println(em.colorName+"\t"+VIOLET);//하나의 데이터 타입으로 사용
		System.out.println();

		for(EnumColor data : EnumColor.values()){
			System.out.println(data+"\t"
								+data.ordinal()+"\t"
								+data.valueOf(data+""));
								//+data.valueOf("BLACK")); 이렇게 하면 에러가 난다.
		}


	}
}
//valueOf()
//String 값을 enum에서 가져오고 값이 없으면 IllegalArgumentException 발생