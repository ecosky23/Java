import java.util.Vector;
	class VectorTest{
	public static void main(String[] args){
		Vector<String> v = new Vector<String>();//�⺻ �뷮 10��, 10���� ����
		System.out.println("���� ũ�� = "+ v.size());//0
		System.out.println("���� �뷮 = "+ v.capacity());//10
		System.out.println();

		System.out.println("�׸� �߰�");
		for(int i=1; i<=10; i++){
			v.add(i+"");
		}
		System.out.println("���� ũ�� = "+ v.size());//10
		System.out.println("���� �뷮 = "+ v.capacity());//10
		System.out.println();
		
		v.addElement(5+"");
		System.out.println("���� ũ�� = "+ v.size());//11 ũ�Ⱑ �Ѿ �� �뷮�� 10�� �þ��.
		System.out.println("���� �뷮 = "+ v.capacity());//20
		System.out.println();

		System.out.println(v);
		
		System.out.println("�׸����");
		v.remove(10);
	}
}
