class PersonTest{
	private String name = null;
	private int age = 0;
	//�̸��� �޴� �޼ҵ� ����
	public void setName(String n){//����
		name = n; //ȫ�浿�� name���� �ް� n�� �ִ´�.		
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
public class PersonMain{ //���ϸ��� ����Ŭ������ �̸����� �Ѵ�. 
	public static void main(String[] args){
		PersonTest aa = new PersonTest();//��ü
			 
			System.out.println("aa= "+aa);
			aa.setName("ȫ�浿");//ȣ�� : ȫ�浿������ String�� �ְ� �ٽ� �ǵ��ƿ´�.
			aa.setAge(25);
			System.out.println("�̸� = "+aa.getName()+" ���� ="+aa.getAge());
	
			
			PersonTest bb = new PersonTest();
			System.out.println("bb= "+bb);
			bb.setName("�ڳ�");
			bb.setAge(13);
			System.out.println("�̸� = "+bb.getName()+" ���� ="+bb.getAge());
	
			PersonTest cc = new PersonTest();
			cc.setData("��ġ", 100);
			System.out.println("�̸� = "+cc.getName()+" ���� ="+cc.getAge());
			PersonTest dd = new PersonTest();
			dd.setData();
	}
}
//set�� ���� �޴°�
//get, is�� ���� �ִ°�