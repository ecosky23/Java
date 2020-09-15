import java.util.Scanner;
import java.util.Calendar;
/*
�� �� ȭ �� �� �� ��
        1 2  3  4 

������ �Է� - �⵵, ��
���� �Է��� ������ 
calculator() ���� �ʿ��� �޼ҵ� ��ƿͼ�
�����ϴ� ������ �� �ٸ�. �Ŵ� ���Ϸ� ��������? 
�����ϴ� ���Ϻ��� 1�� �����ϰ�, 7�� ����� �Ǹ� �ڸ�.

display()
*/
class CalendarTest{
    public int userYear;
    public int userMonth;
     int startDay;   // �� ���� ����
     int lastDay;    // �� ������ ��¥

    
   
    public CalendarTest(){
		 Scanner scanner = new Scanner(System.in);
        System.out.println("������ �Է��Ͻÿ�");
        userYear = scanner.nextInt();
        System.out.println("���� �Է��Ͻÿ�");
        userMonth = scanner.nextInt();
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR , userYear);
        cal.set(Calendar.MONTH , userMonth-1);
		cal.set(Calendar.DAY_OF_MONTH,1);
        startDay = cal.get(Calendar.DAY_OF_WEEK);//1,2,3,4,5,6,7
        lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//31.30.28.29
    }
    
    public void display(){
        
                
        System.out.println("��\t��\tȭ\t��\t��\t��\t��");
        
        int date = 1;
        
        for ( int i = 1 ; i <startDay+lastDay ;i++) {
            if(i<startDay) {
                System.out.print("\t");
            }else if (i%7 ==6) {
                System.out.print(date+"\t");
                date++;
                System.out.println();
            }else if(i>=startDay) {
                System.out.print(date+"\t");
                date++;
            }
        }
        
        
    }


}
public class CalendarTestMain {
    
        public static void main(String[] args)  {
        CalendarTest ct = new CalendarTest();
        ct.display();

        }
    }

