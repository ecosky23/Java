import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class PersonSort{
	public static void main(String[] args){
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		System.out.println("���� �� = ");
			for(String data : ar){
				System.out.println(data+"  ");
			}
		System.out.println();
		Arrays.sort(ar);//�����ϴ� ��ɾ�

		System.out.println("���� �� = ");
			for(String data : ar){
				System.out.println(data+"  ");

			}
			System.out.println();
			//��ü�� ���Ҷ��� Comparable�� �ʿ�

			System.out.println("PersonDTO�� ���� ������ ����");
				PersonDTO aa = new PersonDTO("ȫ�浿",25);
				PersonDTO bb = new PersonDTO("��ġ",40);
				PersonDTO cc = new PersonDTO("�����",30);

			ArrayList<PersonDTO> list = ArrayList<PersonDTO>();
				list.add(aa);
				list.add(bb);
				list.add(cc);
				
			System.out.println("���� �� = "+ list);
			
			Collections.sort(list);
			System.out.println("���� �� = "+ list);

			System.out.println("PersonDTO�� �̸� ������ ����");

			Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
				@Override
				public int compare(PersonDTO o1, PersonDTO o2){

					// return o1.getName().compareTo(o2.getName());//-1 0 1 ��������
					//��������
					//return o2.getName().compareTo(o1.getName());
					ret
						urn o1.getName().compareTo(o2.getName())*-1;
				}
			
			};
			Collections.sort(list, com);			
			System.out.println("���� �� = "+ list);

	}
}
