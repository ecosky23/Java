class SuperTest{
	
		protected double weight, height; //�����ڸ� ���ؼ� ������ �ʱ�ȭ
		
		public SuperTest(){
			System.out.println("SuperTest �⺻ ������");
		}
		

		public SuperTest(double weight, double height){
			System.out.println("SuperTest ������");
			this.weight = weight;
			this.height = height;
		}
		public void disp(){
			System.out.println("������ = "+weight);
			System.out.println("Ű = "+height);
		}
}	
