/*
객체배열
이름 : 홍길동
직급 : 과장
기본급 : 2500000
수당 : 1000000

이름 : 남도일
직급 : 부장
기본급 : 4200000
수당 : 2000000
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
		System.out.println("이름 : ");
			 name = scanner.nextLine();
		System.out.println("직급: ");
			 position = scanner.nextLine();
		System.out.println("기본급: ");
			 basicPay = scanner.nextInt();
		System.out.println("수당: ");
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
