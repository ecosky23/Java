import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class MapTest{
	public static void main(String[] args){
		Map<String,String> map = new HashMap<String,String>();

		map.put("book101","�鼳����");//(key,Value)
		map.put("book201","�ξ����");
		map.put("book102","�鼳����");//Value �ߺ����
		map.put("book301","�ǿ���");
		map.put("book101","��������");//key �ߺ���� ���⼭ ���� 101������ �������ֳ���

	//	System.out.println(map.get("book101"));//�ڵ尪���� Value ���� ������

		Scanner scan = new Scanner(System.in);
		System.out.println("�ڵ� �Է� : ");
		String key = scan.next();
		//if(map.get(key)==null)
		if(map.containsKey(key))// key���� ������ �ֳ�?
			System.out.println(map.get(key));
		else 
			System.out.println("���� key���Դϴ�.");
	}
}
