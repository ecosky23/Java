class ArrayTest{
	public static void main(String[] args) {
		int[] ar; //�迭�� ����
		ar = new int[5];//�޸� �Ҵ�
		System.out.println("�迭�� ar = "+ar); //ar�� �ּ�
			//	int[] ar = new int[5]; //���ǲ� ��ü
			ar[0] = 27;
			ar[1] = 35;
			ar[2] = 12;
			ar[3] = 64;
			ar[4] = 31;

		for(int i = 0; i < ar.length; i++){
			System.out.println("ar["+i+"] ="+ar[i]);
		}
		System.out.println("\n �Ųٷ� ���");
		for(int i = ar.length - 1; i>=0; i--){
			
			System.out.println("ar["+i+"] ="+ar[i]);
		}
		System.out.println("\n Ȧ�������͸� ���");
		for(int i = 0; i < ar.length; i++){
		  if(ar[i]%2 == 1)
			  System.out.println("ar["+i+"] ="+ar[i]);
		}


	}
}
