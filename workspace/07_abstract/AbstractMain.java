class AbstractMain extends AbstractTest{
	
	@Override
	public void setName(String name){// �߻�Ŭ���� ������ �ݵ�� override �ؾ��Ѵ�.
		this.name = name;
	}

	public static void main(String[] args) {
	//	AbstractTest at = new AbstractTest();//�߻�Ŭ������ ��ü���� �޸𸮻����� �ȵȴ�.
		AbstractTest at = new AbstractMain();//������ �ڽĲ����ϰ� ������ �θ𲨷� ����
												//������ Main���� �ϸ� Test���η� ������ ����
	}
}

/*
abstract class AA{
	public abstract void sub();
	public void disp(){}
	}
class BB extends AA{
	public void sub(){} //Override�ؾ��Ѵ�.
	public void disp(){}
}


*/