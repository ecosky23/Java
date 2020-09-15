//오름차순(ASCENDING) - 1,2,3
//내림차순(DESCENDING)
import java.util.Arrays;
class SelectionSort {
	public static void main(String[] args) {
		int[] ar = new int[]{36, 25, 12, 48, 30};//이것도 가능
		int temp = 0;
			/*for(int i = 0; i <=ar.length-1; i++){
					
				for(int j =i+1; j < ar.length; j++){
					if(ar[i] > ar[j]){
						temp = ar[i];						
						ar[i] = ar[j];
						ar[j] = temp;
				}					
				}			
				}

*/
			Arrays.sort(ar);
				for(int data : ar){
					System.out.println(data+"   ");
}
}
}
/*		int[] ar = {36, 25, 12, 48, 30}; //중괄호는 초기값에만 가능

		int [] ar = new int[5];
		// ar = {36, 25, 12, 48, 30} //이것은 안된다
		
		ar[0] = 36;//이것도 가능 방만들고 하나씩 대입하기
		ar[1] = 25;
		int a = 5; //초기값 5

	    int a; // a는 가비지 값(쓰레기값)
		*/