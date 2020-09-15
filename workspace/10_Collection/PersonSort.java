import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class PersonSort{
	public static void main(String[] args){
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		System.out.println("정렬 전 = ");
			for(String data : ar){
				System.out.println(data+"  ");
			}
		System.out.println();
		Arrays.sort(ar);//정렬하는 명령어

		System.out.println("정렬 후 = ");
			for(String data : ar){
				System.out.println(data+"  ");

			}
			System.out.println();
			//객체를 비교할때는 Comparable가 필요

			System.out.println("PersonDTO를 나이 순으로 정렬");
				PersonDTO aa = new PersonDTO("홍길동",25);
				PersonDTO bb = new PersonDTO("또치",40);
				PersonDTO cc = new PersonDTO("도우너",30);

			ArrayList<PersonDTO> list = ArrayList<PersonDTO>();
				list.add(aa);
				list.add(bb);
				list.add(cc);
				
			System.out.println("정렬 전 = "+ list);
			
			Collections.sort(list);
			System.out.println("정렬 후 = "+ list);

			System.out.println("PersonDTO를 이름 순으로 정렬");

			Comparator<PersonDTO> com = new Comparator<PersonDTO>(){
				@Override
				public int compare(PersonDTO o1, PersonDTO o2){

					// return o1.getName().compareTo(o2.getName());//-1 0 1 오름차순
					//내림차순
					//return o2.getName().compareTo(o1.getName());
					ret
						urn o1.getName().compareTo(o2.getName())*-1;
				}
			
			};
			Collections.sort(list, com);			
			System.out.println("정렬 후 = "+ list);

	}
}
