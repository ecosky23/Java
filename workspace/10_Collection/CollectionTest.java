import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CollectionTest{



	public static void main(String[] args){
		Collection<String> coll = new ArrayList<String>(); //ArrayList�� �߻��� �ƴ� �Ϲ�Ŭ���� ���� 		
		coll.add("ȣ����");					// �͸� inner class���� ����
		coll.add("����");
		coll.add("ȣ����");//�ߺ����, ����
		//coll.add(25); ��Ʈ�� Ÿ�Ը� ���ü� �־ �������
		//coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");

		System.out.println("ũ�� = "+coll.size());  //size ũ�ⱸ�ϴ� ��
		Iterator it = coll.iterator(); //�÷��� �ȿ� ���ͷ����͸� �������ذ�
										//it.hasNext() - T
										//it.next()
		while(it.hasNext()){
			System.out.println(it.next());	
		}
	}										
}



/*
interface
- implements, �߻�޼ҵ� Override
- �͸� inner class
- �������� implements ���� Ŭ���� ã��
*/