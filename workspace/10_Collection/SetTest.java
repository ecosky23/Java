import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

class SetTest{
	public static void main(String[] args){
		Set<String> set = new HashSet<String>();
		set.add("ȣ����");					
		set.add("����");
		set.add("ȣ����");//�ߺ���� �ȵ�, ���� ����
		set.add("�⸰");
		set.add("�ڳ���");

		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}
