class GenericTest<T>{
	private T a;  //������ Ÿ���� ���س��� �ʰ� T�� �д�.

	public void setA(T a){
		this.a = a;
	}

	public T getA(){
		return a;
	}

}


//-----------
class GenericMain{
	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>();
		aa.setA("ȫ�浿");
		System.out.println("�̸� = " +aa.getA());

	
		GenericTest<Integer> bb = new GenericTest<Integer>();
		bb.setA(25);
		System.out.println("���� = " +bb.getA());

	}
}
