/*
�⵵ �Է� : 2002
�� �Է� : 10	

��	��	ȭ	��	��	��	��
		1	2	3	4	5
6	7	8	9	10	11	12
13	14	15	16	17	18	19
20	21	22	23	24	25	26
27	28	29	30	31

������ - �⵵, �� �Է� (Scanner)
find() - �����ϴ� ����?, �Ŵ��� ?�Ϸ� ��������?
display()
*/

import java.util.Calendar;
import java.util.Scanner;

class CalendarTest {
	private int year, month, week, lastDay;
	
	public CalendarTest(){
		Scanner scan = new Scanner(System.in);
		System.out.print("�⵵ �Է� : ");
		year = scan.nextInt();
		System.out.print("�� �Է� : ");
		month = scan.nextInt();
	}

	public void find(){
		Calendar cal = Calendar.getInstance(); //�ý��� ��¥ 2020 - 04 - 17
		//cal.set(Calendar.YEAR, year); 2000
		//cal.set(Calendar.MONTH, month-1); 2
		//cal.set(Calendar.DAY_OF_MONTH, 1); 17

		cal.set(year, month-1, 1);

		week = cal.get(Calendar.DAY_OF_WEEK);//1,2,3,4,5,6,7
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//31, 30, 28, 29
	}

	public void display(){
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
		for(int i=1; i<week; i++){
			System.out.print("\t");
		}//for
		for(int i=1; i<=lastDay; i++){
			System.out.print(i+"\t");

			if(week%7==0) System.out.println();
			week++;
		}//for
	}
}
//------------
class CalendarMain {
	public static void main(String[] args) {
		 CalendarTest ct = new CalendarTest();
		 ct.find();
		 ct.display();
	}
}
