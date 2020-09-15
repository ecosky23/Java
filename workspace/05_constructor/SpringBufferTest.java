import java.util.Scanner;
class SpringBufferTest {
	private int dan;
	public SpringBufferTest(){// 2.aa객체를 만들면서 생성자가 처음 실행된다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 단을 입력: ");
		this.dan = scanner.nextInt();
	}
	
	public void display(){//4.구구단실행
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
														//생성자 실행
		aa.display();//3.디스플레이 실행
		
		
	}
}
