//��������(ASCENDING) - 1,2,3
//��������(DESCENDING)
import java.util.Arrays;
class SelectionSort {
	public static void main(String[] args) {
		int[] ar = new int[]{36, 25, 12, 48, 30};//�̰͵� ����
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
/*		int[] ar = {36, 25, 12, 48, 30}; //�߰�ȣ�� �ʱⰪ���� ����

		int [] ar = new int[5];
		// ar = {36, 25, 12, 48, 30} //�̰��� �ȵȴ�
		
		ar[0] = 36;//�̰͵� ���� �游��� �ϳ��� �����ϱ�
		ar[1] = 25;
		int a = 5; //�ʱⰪ 5

	    int a; // a�� ������ ��(�����Ⱚ)
		*/