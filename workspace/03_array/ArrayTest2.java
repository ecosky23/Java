/*
ũ�Ⱑ 50���� �������� ��������
�迭�ȿ� 65~90������ ������ �߻��Ͽ� �����Ͻÿ�
�迭�� ����ϼ���
*/

class ArrayTest2 {
	public static void main(String[] args) {
		int[] ar = new int[50]; 
		int[] count = new int[26];
		 
		for(int i = 0; i < ar.length; i++){
			ar[i] = (int)(Math.random()*26)+65; 
			System.out.print(ar[i]+" ");
			if((i+1)%10==0)System.out.println();
				//1�ٿ� 10����
		for(int j = 0; j < count.length; j++){
			if(ar[i] == (j+65)) count[j]++;	
			}//for j						
		}//for i
		
		for(int i =0; i<count.length; i++){
		System.out.println((char)(i+65)+"�� ���� ="+count[i]);
		}
	}
}
