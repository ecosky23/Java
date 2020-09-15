import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Today{
	public static void main(String[] args) throws ParseException{
		Date date = new Date();//��¥�� ������ �����ϱ�
		System.out.println("���� ��¥ : "+ date);

		SimpleDateFormat adf = new SimpleDateFormat("y�� MM�� dd�� E���� H:m:s");//���������ߵ�
		System.out.println("���� ��¥ : "+ adf.format(date));//adf�������� ��¥�� ����
		System.out.println();
		
		//19910717 152510
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910717152510");//String������ Date �������� ��ȯ�����ִ��Լ�
		
		System.out.println("�� ����: "+birth);
		System.out.println("�� ����: "+adf.format(birth));//sdf �������� �������� ����
		System.out.println();

		//Calendar cal = new Calendar �߻�Ŭ������ �̷��� �ϸ� ������ ���
		//Calendar cal = new GregorianCalendar �߻�Ŭ������ �ڽ�Ŭ������ �̿��ؾ��Ѵ�.
		Calendar cal = Calendar.getInstance();//�޼ҵ� �̿��ϴ� ��� - �ý��� ��¥, �ð� �̿�
		//int year = cal.get(Calendar.YEAR);// ������ static final�̱� ������ �빮�ڷ� ���ȴ�.
		int year = cal.get(1);//Calendar.YEAR�� �ڹٿ� 1�� ǥ���ȴ�.
		int month = cal.get(Calendar.MONTH);//���� �����´�
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//�� ���� ������ ǥ��
		String week = null;
		switch(dayOfWeek){
			case 1 : week = "�Ͽ���"; break;
			case 2 : week = "������"; break;
			case 3 : week = "ȭ����"; break;
			case 4 : week = "������"; break;
			case 5 : week = "�����"; break;
			case 6 : week = "�ݿ���"; break;
			case 7 : week = "�����"; break;
		}
		System.out.println(year+"��"+(month+1)+"��"+day+"��"+week);
	}
}
