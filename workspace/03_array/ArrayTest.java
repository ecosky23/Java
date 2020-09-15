class ArrayTest{
	public static void main(String[] args) {
		int[] ar; //배열을 선언
		ar = new int[5];//메모리 할당
		System.out.println("배열명 ar = "+ar); //ar은 주소
			//	int[] ar = new int[5]; //위의꺼 합체
			ar[0] = 27;
			ar[1] = 35;
			ar[2] = 12;
			ar[3] = 64;
			ar[4] = 31;

		for(int i = 0; i < ar.length; i++){
			System.out.println("ar["+i+"] ="+ar[i]);
		}
		System.out.println("\n 거꾸로 출력");
		for(int i = ar.length - 1; i>=0; i--){
			
			System.out.println("ar["+i+"] ="+ar[i]);
		}
		System.out.println("\n 홀수데이터만 출력");
		for(int i = 0; i < ar.length; i++){
		  if(ar[i]%2 == 1)
			  System.out.println("ar["+i+"] ="+ar[i]);
		}


	}
}
