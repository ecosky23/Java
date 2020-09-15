import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CollectionTest{



	public static void main(String[] args){
		Collection<String> coll = new ArrayList<String>(); //ArrayList는 추상이 아닌 일반클래스 여서 		
		coll.add("호랑이");					// 익명 inner class쓰지 않음
		coll.add("사자");
		coll.add("호랑이");//중복허용, 순서
		//coll.add(25); 스트링 타입만 들어올수 있어서 에러뜬다
		//coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");

		System.out.println("크기 = "+coll.size());  //size 크기구하는 식
		Iterator it = coll.iterator(); //컬렉션 안에 이터레이터를 지정해준것
										//it.hasNext() - T
										//it.next()
		while(it.hasNext()){
			System.out.println(it.next());	
		}
	}										
}



/*
interface
- implements, 추상메소드 Override
- 익명 inner class
- 누군가가 implements 해준 클래스 찾기
*/