/*������ ����
********
1.����
2.����
3.���
4.��
********
��ȣ:
*/
import java.util.Scanner;
class ArrayTest3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[] car = new boolean[5];
		while(true){
			System.out.println();
			System.out.println("********");
			System.out.println("1.����");
			System.out.println("2.����");
			System.out.println("3.���");
			System.out.println("4.��");
			System.out.println("********");
			System.out.print("��ȣ: ");
			int number = scanner.nextInt();
			System.out.println();
			if(number == 1){
				System.out.print("����ڸ��� �����Ͻðڽ��ϱ�?");
				int park = scanner.nextInt();
				if(car[park-1]==false){
					car[park-1]=true;
					System.out.println(park+"��ġ������ ���� �մϴ�.");
					System.out.println(park+"��° ��ġ�� ���� �Ǿ����ϴ�.");
				}else {
					System.out.println(park+"���� �Ұ��� �մϴ�.");
				}
			}else if(number == 2){
				System.out.print("���° �ڸ����� �����Ͻðڽ��ϱ�?");
					int park = scanner.nextInt();
				if(car[park-1]==true){
					car[park-1]=false;
					System.out.println(park+"��° �ڸ����� ���� �Ǿ����ϴ�.");				
				}else {
					System.out.println(park+"��° ��ġ�� ���������ϴ�.");
				}
			}else if(number == 3){
				for(int i = 0; i < car.length; i++){
					System.out.println((i+1)+"��° ��ġ: "+car[i]);
				}//for
					
			}else if(number == 4){
				System.out.println("�̿� ��~~");
				break;
			}
			
		}
	}
}
