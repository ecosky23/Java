/*
�л��� �̸��� ������� �Է� �޾Ƽ� ������ ���Ͻÿ�

[������]
�̸� �Է�: ȫ�浿
����� �Է�: "12141" 5������ ���

�̸�  1  2  3  4  5 ���� index[] �迭�� �� �Ʒ� ù��°�� �� �ι�°�� ��for�� Ȥ�� if�� ���� ���
ȫ�浿 o  x  o  x  o 60��
������ ����
������ ����


*/

import java.util.Scanner;
class Quiz3{
	public static void main(String[] args) {
		final String ANSWER = "11111";   //���ȭ ������ ����
		String name, dab = "";
		int score = 0;
		char[] ox = new char[5];
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���: ");
		name = scanner.nextLine();
		System.out.print("������� �Է��ϼ���: ");
		dab = scanner.nextLine();
		
			
			for(int i = 0; 0 < 5; i++){
				
				if(ANSWER.charAt(i) == dab.charAt(i)){
					ox[i] = 'o';
					score = score+20;
				}else{	ox[i] = 'x';
						}
			System.out.printf("�̸� 1 2 3 4 5 ����");
			System.out.println(name+"\t\t");
			}
			
			
			for(int i = 0; i<ox.length; i++){
				System.out.println(ox[i]+" ");
			}
			System.out.println("\t"+score + "��");
			
	}
}
