class GuguDan {
	public static void main(String[] args) {
		int dan = Integer.parseInt(args[0]);
		for(int i = 1; i <= 9; i++){
		System.out.println(dan + "*" + i + "=" + dan*1);
		}

		
	}
}



//단을 입력받아서 구구단을 구하시오
//[]실행결과
//java GuguDan 5(5입력)
//5 * 1 = 5
//5 * 2 = 10