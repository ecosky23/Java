enum EnumColor2{
	//enum 괄호안의 데이터는 생성자로 전달된다.
	RED("빨강"), GREEN("초록"), BLUE("파랑"), MAGENTA("보라");//1.생성자 가로안의 값이 스트링에들어감 
	private String colorName;

//	public 쓰면 안된다, private or default 써야한다.
	EnumColor2(String colorName){//2. 위의 색깔들이 colorName로 들어옴
		this.colorName = colorName;//3. this.colorName로 색깔이 들어옴
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