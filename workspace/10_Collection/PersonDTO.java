class PersonDTO implements Comparable<PersonDTO>{//자기자신과 비교하기위해 PersonDTO를 쓴다
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
		return "이름: "+name+ "나이 ="+age;
	}

	@Override
	public int compareTo(PersonDTO o){
		/*if(this.age < o.age) return -1;
		else if(this.age == o.age) return 0;
		else return 1;
		*/
		

	}
}


