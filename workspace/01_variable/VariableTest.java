class VariableTest {
	public static void main(String[] args){
		boolean a = true; // 컴터로는 1이 들어간다.
		System.out.println("a="+a);

		char b = 'A';
		System.out.println("b="+b);

		char c = 65;
		System.out.println("c="+c);

		//char d = 65536;  char의 최대크기가 65535라서 65536은 크기가 넘어서 에러가 뜬다
		//System.out.println("d="+d);
		int e = 65;
		System.out.println("e="+e);

		int f = 'A';
		System.out.println("f="+f);

		// float g = 43.8; - error 43.8이 double형이라서 float형에 넣으면 애러가 뜬다
		// double g = 43.8;
		float g = (float)43.8; 
		//float g = 43.8f;
		//앞의 것은 double을 float로 형변환하는것이고 뒤에것은 시작이 float형으로 태어난것이다.
		System.out.println("g="+g);



	}
}




