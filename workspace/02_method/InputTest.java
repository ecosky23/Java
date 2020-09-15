class InputTest{
	public static void main(String[] args){
		System.out.println("배열명 args = " + args);

		for(int i =0; i < args.length; i++){ //args.length는 명령어
			System.out.println("args["+i+"] = " + args[i]);
			System.out.println("글자수 =  " + args[i].length());//args[i].length()는 메소드(함수)
			System.out.println("첫글자 =  " + args[i].charAt(0));//글자의 몇번째자리 글자를 뽑아내는 함수
			System.out.println();
		}//for
		System.out.println("확장형 for");
		for(String data : args){
			System.out.println(data);
		}
		
	}
	
}



/*
변수				배열
자료형 변수명		자료형[] 배열명 = {값, 값, 값};

메소드()
*/