/*
���� ���� �� ����
������ 1, ������ 2, ���ڱ�� 3���� �����ϰڴ�. ��������
��ǻ�ʹ� 1~3������ ���� �߻�
while������ ���ѹݺ�
���� 1000������ �����Ѵ�.
[������]
********
1. ���� 
2. ����
3. ��
********
��ȣ �Է�: 2

���ñݾ�: 200

����� ������ Enter�� ġ����:

��ǻ��: ����   ��: ����

You win.. ����� �ݾ��� 1200�� �Դϴ�.

*/

import java.util.Scanner;
class Game{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int money = 1000;
		int count = 200;
		String yn;
		while(true){
		int cn = (int)(Math.random()*3)+1;
		System.out.println();
		System.out.println("[������]");
		System.out.println("**********");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ��");
		System.out.println("**********");
		System.out.println();
		System.out.print("��ȣ �Է�: ");
		int number = scanner.nextInt();
		scanner.nextLine();
		System.out.println("����� ������ ENTER�� ġ����!!!!!");
		String result = scanner.nextLine();
		
		if(number == cn){
			System.out.println("�����ϴ�.");
			if(number == 1){System.out.print("��: ����\t");
				if(cn == 1){System.out.println("��ǻ��: ����");}
					}else if(number == 2){System.out.print("��: ����\t");
				if(cn == 2){System.out.println("��ǻ��: ����");}
					}else if(number == 3){
						System.out.print("��: ��\t");
				if(cn == 3){System.out.println("��ǻ��: ��");}
			}	
		}else if(number==1 && cn==3 || 
				number==2 && cn==1 ||
				number==3 && cn==2){
				money += count;
				if(number == 1){System.out.println("��: ����\t��ǻ��: ��");
					}else if(number ==2){System.out.println("��: ����\t��ǻ��: ����");
					}else if(number ==3){System.out.println("��: ��\t��ǻ��: ����");}
				System.out.println();
				System.out.println("You win!!! ����� �ݾ���"+money+"�Դϴ�.");
		}else if(number==1 && cn==2 || 
				number==2 && cn==3 || 
				number==3 && cn==1){
				money -= count;
				if(number==1){System.out.println("��: ����\t��ǻ��: ����");
					}else if(number==2){System.out.println("��: ����\t��ǻ��: ��");		
					}else if(number==3){System.out.println("��: ��\t��ǻ��: ����");}	
				System.out.println();
				System.out.println("You lose"+money+"�� ���ҽ��ϴ�.");}
			if(money == 0){
					System.out.println("���ҷ�(Y/N)");
					yn = scanner.next();

					if(yn.equals("N") || yn.equals("n"))break;//for�� �����
					else money =1000;
			}
		}//while
		System.out.println("���α׷��� �����մϴ�.");
	}//���θ޼ҵ�
}//Ŭ����
