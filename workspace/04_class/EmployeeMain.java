/*직원들의 월급을 계산하는 프로그램
- 항목은 이름(name), 직급(position), 기본급(basicPay), 
		수당(extraPay), 세율(taxRate), 월급(salary)
- 세율은 기본급이 200만원 이하 : 1(0.01)%
-			 400만원 이하 : 2%(0.02)
-			 400만원 초과 : 3%(0.03)으로 설정
- 월급 = 기본급 + 수당 - (기본급 + 수당) * 세율
-setter / getter 메소드 설정, calcPay()계산
[실행결과]
이름 : 홍길동
직급 : 과장
기본급 : 2500000
수당 : 1000000

홍길동 과장 2500000 1000000 0.02 3430000
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
		
		System.out.println("이름 : ");
			name = scanner.nextLine();
		System.out.println("직급: ");
			position = scanner.nextLine();
		System.out.println("기본급: ");
			basicPay = scanner.nextInt();
		System.out.println("수당: ");
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
