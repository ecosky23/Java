class AbstractMain implements InterA{
	
//public void setName(String name){AbstractTest�� �߻�Ŭ���� �ϼ�
//			this.name = name;

	public static void main(String[] args){
	//	AbstractTest at = new AbstractTest(); -error �߻�Ŭ������ new�� �ȵȴ�. �׷��� ���������Ѵ�.
	//	AbstractTest at = new AbstractMain(); AbstractMain���� �����Ͽ� Test�� �α�
		AbstractTest at = new AbstracTest(){
			@Override
			public void setName(String name){//Ŭ������ ��� ��� Override ���ش�. �̸��̾���.
				this.name = name;			//�̰��� �͸� �̳� Ŭ���� �̴�.
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
	new �߻�Ŭ����(){};
	new Ŭ����(){};
	new �������̽�(){}

}


*/