abstract class AbstractTest{ //POJO(Plain Old Java Object)
	protected String name;

	public abstract void setName(String name);//�߻�޼ҵ� �̷��޼ҵ尡 ������̴� �����ϴ� ��
										//�߻�޼ҵ�� �߻�޼ҵ��� ǥ���ؾ��Ѵ�.

	public String getName(){// �޼ҵ��� ������   ���͸� ���ؼ� return���� ������ ����
		return name;
	}

}
//�߻� �޼ҵ�� �߻� Ŭ������ �־�� �Ѵ�. but �߻�Ŭ������ �߻� �޼ҵ尡 ���� ���� �ִ�.