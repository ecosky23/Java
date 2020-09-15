class MethodTest4{
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		double b = Double.parseDouble(args[1]);
		//객체형은 기본형으로 형변환이 불가능하다. String는 int로 형변환 불가
		// args[0]은 String 타입이다.
		//Intege.parseInt()String을 정수로 바꿔주는 메소드

		System.out.println(a + " + " + b + " = " + (a + b));
	}
}
