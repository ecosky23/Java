import java.util.ArrayList;

class PersonMain{
	public ArrayList<PersonDTO> init(){
		PersonDTO aa = new PersonDTO("ȫ�浿",25);
		PersonDTO bb = new PersonDTO("��ġ",40);
		PersonDTO cc = new PersonDTO("�����",30);

		ArrayList<PersonDTO> list = ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);

		return list;
	}

	public static void main(String[] args){
		PersonMain main = new PersonMain();

		ArrayList<PersonDTO> list = main.init();
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
		System.out.println("---------");

		for(PersonDTO dto : list){
			System.out.println(dto);
		}
	}
}
