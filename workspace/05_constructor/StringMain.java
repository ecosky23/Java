class StringMain{
	public static void main(String[] args) {
		String aa = "apple";//leteral 생성 가능, aa 주소값에 apple가 존재
		String bb = "apple";// bb주소값에 위의 메모리와 같은 apple존재

		if(aa==bb)System.out.println("aa와 bb의 참조값(주소안쪽)은 같다");
		else System.out.println("aa와 bb의 참조값은 다르다");

		if(aa.equals(bb))System.out.println("aa와 bb의 문자열은 같다");
		else System.out.println("aa와 bb의 문자열은 다르다.");
		System.out.println();

		String cc = new String("apple");//cc 주소값에 String안에 apple이 존재
		String dd = new String("apple");//dd 주소값에 String안에 apple이 존재

		if(cc == dd)System.out.println("cc와 dd의 참조값은 같다");
		else System.out.println("cc와 dd의 참조값은 다르다");

		if(cc.equals(dd))System.out.println("cc와 dd의 문자열은 같다");
		else System.out.println("cc와 dd의 문자열은 다르다.");
		System.out.println();

		String ee = "오늘 날짜는 "+2020+4+13;//문자열
		System.out.println(ee);

		/*
		문자열은 편집이 안되므로 메모리 4번 생성된다
		JVM에 의해서 삭제 시 Garbage Collector로 보낸다
		Garbage Collector가 실행되면 컴퓨터는 멈춘다.

		"오늘 날짜는 "
		"오늘 날짜는 2020"
		"오늘 날짜는 20204"
		ee --> "오늘 날짜는 2020413"
		*/

			System.out.println("문자열의 크기= "+ ee.length());//14
			System.out.println("문자 추출 =  "+ ee.charAt(4));//짜

			System.out.println("문자열의 추출= "+ ee.substring(7));//2020413
			System.out.println("문자열의 추출= "+ ee.substring(7,11));//2020

			System.out.println("대문자 병경= "+ "Hello".toUpperCase());
			System.out.println("소문자 변경= "+ "Hello".toLowerCase());

			System.out.println("문자열 검색= "+ ee.indexOf("짜"));//4
			System.out.println("문자열 검색= "+ ee.indexOf("날짜"));//3
			System.out.println("문자열 검색= "+ ee.indexOf("개바부"));//-1

			System.out.println("문자열 치환="+ee.replace("오늘","현재"));
	}
}

//indexOf(?,?)매개변수 2개들어가는 식을 찾아야 문제를 풀수있다.
