class PersonTest{
	private String name = null;
	private int age = 0;
	//이름을 받는 메소드 구현
	public void setName(String n){//구현
		name = n; //홍길동을 name에서 받고 n에 넣는다.		
	}
	public void setAge(int a){
		age = a;
	}
	public void setData(String n, int a){
		name = n;
		age = a;
	}
	public void setData(){}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	}
public class PersonMain{ //파일명은 메인클래스의 이름으로 한다. 
	public static void main(String[] args){
		PersonTest aa = new PersonTest();//객체
			 
			System.out.println("aa= "+aa);
			aa.setName("홍길동");//호출 : 홍길동을위의 String에 주고 다시 되돌아온다.
			aa.setAge(25);
			System.out.println("이름 = "+aa.getName()+" 나이 ="+aa.getAge());
	
			
			PersonTest bb = new PersonTest();
			System.out.println("bb= "+bb);
			bb.setName("코난");
			bb.setAge(13);
			System.out.println("이름 = "+bb.getName()+" 나이 ="+bb.getAge());
	
			PersonTest cc = new PersonTest();
			cc.setData("또치", 100);
			System.out.println("이름 = "+cc.getName()+" 나이 ="+cc.getAge());
			PersonTest dd = new PersonTest();
			dd.setData();
	}
}
//set는 값을 받는것
//get, is는 값을 주는것