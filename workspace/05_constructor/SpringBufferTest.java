import java.util.Scanner;
class SpringBufferTest {
	private int dan;
	public SpringBufferTest(){// 2.aa��ü�� ����鼭 �����ڰ� ó�� ����ȴ�.
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ϴ� ���� �Է�: ");
		this.dan = scanner.nextInt();
	}
	
	public void display(){//4.�����ܽ���
		StringBuffer buffer = new StringBuffer();

		for(int i = 1; i <=9; i++){
		//System.out.println(this.dan + "*" + i + "=" + dan*i);
		buffer.append(dan);
		buffer.append("*");
		buffer.append(i);
		buffer.append("=");
		buffer.append(dan*i);
		System.out.println(buffer);
		buffer.delete(0,buffer.length());
		}
	}
	public static void main(String[] args){
		SpringBufferTest aa = new SpringBufferTest();//1.SpringBufferTest
														//������ ����
		aa.display();//3.���÷��� ����
		
		
	}
}
