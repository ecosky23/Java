import java.util.Vector;
	class VectorTest{
	public static void main(String[] args){
		Vector<String> v = new Vector<String>();//기본 용량 10개, 10개씩 증가
		System.out.println("백터 크기 = "+ v.size());//0
		System.out.println("백터 용량 = "+ v.capacity());//10
		System.out.println();

		System.out.println("항목 추가");
		for(int i=1; i<=10; i++){
			v.add(i+"");
		}
		System.out.println("백터 크기 = "+ v.size());//10
		System.out.println("백터 용량 = "+ v.capacity());//10
		System.out.println();
		
		v.addElement(5+"");
		System.out.println("백터 크기 = "+ v.size());//11 크기가 넘어가 면 용량은 10씩 늘어난다.
		System.out.println("백터 용량 = "+ v.capacity());//20
		System.out.println();

		System.out.println(v);
		
		System.out.println("항목삭제");
		v.remove(10);
	}
}
