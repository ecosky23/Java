class ThisTest{
	private int a;
	public void setA(int a){
		System.out.println("this ="+this);	
		this.a = a;
	}
	public int getA(){
		return a;//항상 this가 생량되어 있다.
	}
}



class ThisMain{
	public static void main(String[] args){
		ThisTest aa = new ThisTest();
		System.out.println("aa="+ aa);
		aa.setA(10);
		ThisTest bb = new ThisTest();
		System.out.println("bb="+ bb);
		bb.setA(20);
	}
}