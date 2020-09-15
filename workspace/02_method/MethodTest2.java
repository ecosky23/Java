class MethodTest2 {
	
	public static void main(String[] args) {
	 
	MethodTest2 aa = new MethodTest2();
		System.out.println("합 = "+ aa.sum(25, 36));//61
		System.out.println("합 = "+ aa.sub(25, 36));//
		System.out.println("합 = "+ aa.mul(25, 36));//
		System.out.println("합 = "+ aa.div(25, 36));//
	
	}
	
	
	public int sum(int a, int b){//구현
	
	return a+b; //반환
	}
	public int sub(int a, int b){//구현
	
	return a-b; //반환
	}
	public int mul(int a, int b){//구현
	
	return a*b; //반환
	}
	public double div(double a, double b){//구현
	
	return a/b; //반환
	}
}



// 메소드 = 함수(parameter(매개변수), argument(인수)) 내부의 것을 파라미터 인수라고한다.