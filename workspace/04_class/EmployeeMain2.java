/*
��ü�迭
�̸� : ȫ�浿
���� : ����
�⺻�� : 2500000
���� : 1000000

�̸� : ������
���� : ����
�⺻�� : 4200000
���� : 2000000
*/
import java.util.Scanner;
class EmployeeMain2{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeDTO[] ar = new EmployeeDTO[2];
		String name;
		String position;
		int basicPay;
		int extraPay;

		for(int i = 0; i < ar.length; i++){
			ar[i] = new EmployeeDTO();
		System.out.println("�̸� : ");
			 name = scanner.nextLine();
		System.out.println("����: ");
			 position = scanner.nextLine();
		System.out.println("�⺻��: ");
			 basicPay = scanner.nextInt();
		System.out.println("����: ");
			 extraPay = scanner.nextInt();
		ar[i].setData(name,position,basicPay,extraPay);
		ar[i].setTaxRate(0.02);
		ar[i].calcPay();
		System.out.println();
		}//for i
		for(EmployeeDTO data: ar){
			System.out.println(data.getName()+"\t"
					+data.getPosition()+"\t"
					+data.getBasicPay()+"\t"
					+data.getExtraPay()+"\t"
					+data.getTaxRate()+"\t"
						+data.calcPay());
		}
	}
}
