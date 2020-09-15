abstract class AbstractTest{ //POJO(Plain Old Java Object)
	protected String name;

	public abstract void setName(String name);//추상메소드 이런메소드가 생길것이다 예측하는 것
										//추상메소드는 추상메소드라고 표현해야한다.

	public String getName(){// 메소드의 구현부   게터를 통해서 return값을 밖으로 보넴
		return name;
	}

}
//추상 메소드는 추상 클래스가 있어야 한다. but 추상클래스는 추상 메소드가 없을 수도 있다.