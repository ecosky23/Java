import java.util.ArrayList;
import java.util.Iterator;

class CollectionTest2{

	
	@SuppressWarnings("unchecked")//컴파일 하면 에러대신 오류가 나는 상황을 억제하는 것
	public static void main(String[] args){
		ArrayList list = new ArrayList(); //ArrayList는 추상이 아닌 일반클래스 여서 		
		list.add("호랑이");					// 익명 inner class쓰지 않음
		list.add("사자");
		list.add("호랑이");//중복허용, 순서
		list.add(25); 
		list.add(43.8);
		list.add("기린");
		list.add("코끼리");

		for(int i = 0; i<list.size(); i++){//size 크기 구하는 것
			System.out.println(list.get(i));
		}

	}
}										




/*
interface
- implements, 추상메소드 Override
- 익명 inner class
- 누군가가 implements 해준 클래스 찾기
*/