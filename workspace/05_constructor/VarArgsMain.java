class VarArgs{
	public VarArgs(){}//�⺻ ������
	

		public int sum(int...ar){//���������� �迭ó��
			int hap=0;
			for(int i=0; i<ar.length; i++){
				hap += ar[i];
			}
			return hap;
		}
		
}


class VarArgsMain{
	public static void main(String[] args) {
		VarArgs aa = new VarArgs();
		System.out.println("�� = " +aa.sum(10,20));//30
		
		System.out.println("�� = " +aa.sum(10,20,30));
		
		System.out.println("�� = " +aa.sum(10,20,30,40));
	}
}
