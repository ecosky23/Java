class PersonDTO implements Comparable<PersonDTO>{//�ڱ��ڽŰ� ���ϱ����� PersonDTO�� ����
	private String name;
	private int age;
	
	public PersonDTO(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return this.name;
	}

	public int getAge(){
		return this.age;
	}

	@Override
	public String toString(){
		return "�̸�: "+name+ "���� ="+age;
	}

	@Override
	public int compareTo(PersonDTO o){
		/*if(this.age < o.age) return -1;
		else if(this.age == o.age) return 0;
		else return 1;
		*/
		

	}
}


