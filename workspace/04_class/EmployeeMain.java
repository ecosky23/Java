/*�������� ������ ����ϴ� ���α׷�
- �׸��� �̸�(name), ����(position), �⺻��(basicPay), 
		����(extraPay), ����(taxRate), ����(salary)
- ������ �⺻���� 200���� ���� : 1(0.01)%
-			 400���� ���� : 2%(0.02)
-			 400���� �ʰ� : 3%(0.03)���� ����
- ���� = �⺻�� + ���� - (�⺻�� + ����) * ����
-setter / getter �޼ҵ� ����, calcPay()���
[������]
�̸� : ȫ�浿
���� : ����
�⺻�� : 2500000
���� : 1000000

ȫ�浿 ���� 2500000 1000000 0.02 3430000
*/
import java.util.Scanner;
class EmployeeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		String position;
		int basicPay;
		int extraPay;
		double taxRate;
		int salary;
		
		EmployeeDTO aa = new EmployeeDTO();
		
		System.out.println("�̸� : ");
			name = scanner.nextLine();
		System.out.println("����: ");
			position = scanner.nextLine();
		System.out.println("�⺻��: ");
			basicPay = scanner.nextInt();
		System.out.println("����: ");
			extraPay = scanner.nextInt();	
		aa.setData(name,position,basicPay,extraPay);
		aa.setTaxRate(0.02);
		aa.calcPay();
		
		System.out.println(aa.getName()+"\t"
					+aa.getPosition()+"\t"
					+aa.getBasicPay()+"\t"
					+aa.getExtraPay()+"\t"
					+aa.getTaxRate()+"\t"
						+aa.calcPay());
	}
}
