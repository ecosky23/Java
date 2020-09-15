class AbstractMain implements InterA{
	
//public void setName(String name){AbstractTest의 추상클래스 완성
//			this.name = name;

	public static void main(String[] args){
	//	AbstractTest at = new AbstractTest(); -error 추상클래스는 new가 안된다. 그래서 상속해줘야한다.
	//	AbstractTest at = new AbstractMain(); AbstractMain에서 생성하여 Test에 두기
		AbstractTest at = new AbstracTest(){
			@Override
			public void setName(String name){//클래스를 잠깐 대신 Override 해준다. 이름이없다.
				this.name = name;			//이것이 익명 이너 클래스 이다.
			}
			//AbstractMain$1.class
		};
		
		InterA bb = new InterA(){
			public void aa(){}
			public void bb(){}
		};

		AbstractExam cc = new AbstractExam(){};
			public void cc(){}
	}
}

/*
class Outer{
	class Inner{
	}
	static class Inner2{
	}
	public void disp(){
		class Inner3{}
	}
}

public static void main(String[] args){
	Outer.Inner aa = new Outer(),new Inner();
	Outer.Inner2 aa = new Outer.Inner2();
	new 추상클래스(){};
	new 클래스(){};
	new 인터페이스(){}

}


*/