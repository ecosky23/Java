class MemberDTO  {
	
		private String name;
		private int age;
		private String phone, address;

		public MemberDTO(){}
		public MemberDTO(String name, int age, String phone, String address){
		this.name = name;
		this.age =	age;
		this.phone = phone;
		this.address = address;
		}
		public void setName(String name){this.name = name;}
		public void setAge(int age){this.age = age;}
		public void setPhone(String phone){this.phone = phone;}
		public void setAddress(String address){this.address = address;}
		
		public String getName(){return name;}
		public String getPhone(){return phone;}
		public int getAge(){return age;}
		public String getAddress(){return address;}
		
	
}

//생성자 - 객체 초기화
