import java.util.ArrayList;
import java.util.Iterator;

class CollectionTest2{

	
	@SuppressWarnings("unchecked")//������ �ϸ� ������� ������ ���� ��Ȳ�� �����ϴ� ��
	public static void main(String[] args){
		ArrayList list = new ArrayList(); //ArrayList�� �߻��� �ƴ� �Ϲ�Ŭ���� ���� 		
		list.add("ȣ����");					// �͸� inner class���� ����
		list.add("����");
		list.add("ȣ����");//�ߺ����, ����
		list.add(25); 
		list.add(43.8);
		list.add("�⸰");
		list.add("�ڳ���");

		for(int i = 0; i<list.size(); i++){//size ũ�� ���ϴ� ��
			System.out.println(list.get(i));
		}

	}
}										




/*
interface
- implements, �߻�޼ҵ� Override
- �͸� inner class
- �������� implements ���� Ŭ���� ã��
*/