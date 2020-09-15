/*
크기가 50개인 정수형을 잡으세요
배열안에 65~90사이의 난수를 발생하여 저장하시요
배열을 출력하세오
*/

class ArrayTest2 {
	public static void main(String[] args) {
		int[] ar = new int[50]; 
		int[] count = new int[26];
		 
		for(int i = 0; i < ar.length; i++){
			ar[i] = (int)(Math.random()*26)+65; 
			System.out.print(ar[i]+" ");
			if((i+1)%10==0)System.out.println();
				//1줄에 10개씩
		for(int j = 0; j < count.length; j++){
			if(ar[i] == (j+65)) count[j]++;	
			}//for j						
		}//for i
		
		for(int i =0; i<count.length; i++){
		System.out.println((char)(i+65)+"의 개수 ="+count[i]);
		}
	}
}
