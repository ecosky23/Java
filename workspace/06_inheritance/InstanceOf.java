class AA{}

class BB extends AA{}

//������ -> ���������� �����ǰ��� �� �޾��ش�. �θ�Ŭ������ �ڽ�Ŭ������ �������� ������.

class InstanceOf{
	public static void main(String[] args){
		AA aa = new AA();
		AA bb = new BB();
		AA aa2 = new BB();

		AA aa3 = aa;
		if(aa instanceof AA) System.out.println("1.TRUE");//aa�� AA�� Ŭ������ ������
		else System.out.println("1.FALSE");		//aa�� casting�� �ȴ�.
												//aa�� ����Ű�� ������ AAŸ���� Ŭ������ �ִ�.
		AA aa4 = bb;//�θ� = �ڽ� �ڽ��� ���� �θ𿡰� �����ִ�.
		if(bb instanceof AA) System.out.println("2.TRUE");
		else System.out.println("2.FALSE");

//		BB bb2 = aa; ERROR �θ��� ���� �ڽĿ��� ������. �Ϸ��� �θ� �ڽ����� �ɽ����ؾ��Ѵ�.
		BB bb2 = (BB)aa2;	//�ڽ� = (�ڽ�)�θ� �̷��� �ڽ����� ����ȯ �ؾ��Ѵ�. 
		if(aa2 instanceof BB) System.out.println("3.TRUE");
		else System.out.println("3.FALSE");

		//BB bb3 = (BB)aa; error ��ü������ BB�� ����������� ��� aa�� ĳ������ �ȵȴ�.
		if(aa instanceof BB) System.out.println("4.TRUE");
		else System.out.println("4.FALSE");
	}											
}
 