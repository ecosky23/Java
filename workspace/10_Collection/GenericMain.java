class GenericTest<T>{
	private T a;  //데이터 타입을 정해놓지 않고 T로 둔다.

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
		aa.setA("홍길동");
		System.out.println("이름 = " +aa.getA());

	
		GenericTest<Integer> bb = new GenericTest<Integer>();
		bb.setA(25);
		System.out.println("나이 = " +bb.getA());

	}
}
