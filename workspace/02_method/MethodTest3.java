import java.util.Random;
class MethodTest3 {
	public static void main(String[] args) {
	System.out.println("ū�� = " + Math.max(25, 36));  //�ڹ� Ŭ���� �ȿ� ���� �Ǿ��ִ� MATH��
	

	double power = Math.pow(2,5);
	System.out.println("���� �� = " +power);
	
	//���� - ��ǻ�Ͱ� �ұ�Ģ�ϰ� �߻��ϴ� ��, 0<����<=1
	int a;
	a = (int)(Math.random()*100)+1; // 1~ 100
	System.out.println(a);
	
	Double b;
	
	Random r = new Random();
		b = r.nextDouble();
		System.out.println(b);
	}

}


/*
�ڹ� - �޼ҵ� - 

*/