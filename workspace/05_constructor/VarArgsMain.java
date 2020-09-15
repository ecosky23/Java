class VarArgs{
	public VarArgs(){}//기본 생성자
	

		public int sum(int...ar){//내부적으로 배열처리
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
		System.out.println("합 = " +aa.sum(10,20));//30
		
		System.out.println("합 = " +aa.sum(10,20,30));
		
		System.out.println("합 = " +aa.sum(10,20,30,40));
	}
}
