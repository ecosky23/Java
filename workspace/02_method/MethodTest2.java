class MethodTest2 {
	
	public static void main(String[] args) {
	 
	MethodTest2 aa = new MethodTest2();
		System.out.println("�� = "+ aa.sum(25, 36));//61
		System.out.println("�� = "+ aa.sub(25, 36));//
		System.out.println("�� = "+ aa.mul(25, 36));//
		System.out.println("�� = "+ aa.div(25, 36));//
	
	}
	
	
	public int sum(int a, int b){//����
	
	return a+b; //��ȯ
	}
	public int sub(int a, int b){//����
	
	return a-b; //��ȯ
	}
	public int mul(int a, int b){//����
	
	return a*b; //��ȯ
	}
	public double div(double a, double b){//����
	
	return a/b; //��ȯ
	}
}



// �޼ҵ� = �Լ�(parameter(�Ű�����), argument(�μ�)) ������ ���� �Ķ���� �μ�����Ѵ�.