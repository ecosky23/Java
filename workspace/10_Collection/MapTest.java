import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class MapTest{
	public static void main(String[] args){
		Map<String,String> map = new HashMap<String,String>();

		map.put("book101","백설공주");//(key,Value)
		map.put("book201","인어공주");
		map.put("book102","백설공주");//Value 중복허용
		map.put("book301","피오나");
		map.put("book101","엄지공주");//key 중복허용 여기서 부터 101찍으면 엄지공주나옴

	//	System.out.println(map.get("book101"));//코드값으로 Value 값을 가져옴

		Scanner scan = new Scanner(System.in);
		System.out.println("코드 입력 : ");
		String key = scan.next();
		//if(map.get(key)==null)
		if(map.containsKey(key))// key값을 가지고 있냐?
			System.out.println(map.get(key));
		else 
			System.out.println("없는 key값입니다.");
	}
}
