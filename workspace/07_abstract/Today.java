import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Today{
	public static void main(String[] args) throws ParseException{
		Date date = new Date();//날짜를 변수로 선언하기
		System.out.println("오늘 날짜 : "+ date);

		SimpleDateFormat adf = new SimpleDateFormat("y년 MM월 dd일 E요일 H:m:s");//영어맞춰줘야됨
		System.out.println("오늘 날짜 : "+ adf.format(date));//adf형식으로 날짜를 찍어라
		System.out.println();
		
		//19910717 152510
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910717152510");//String형식을 Date 형식으로 변환시켜주는함수
		
		System.out.println("내 생일: "+birth);
		System.out.println("내 생일: "+adf.format(birth));//sdf 형식으로 내생일을 찍어라
		System.out.println();

		//Calendar cal = new Calendar 추상클래스라서 이렇게 하면 에러가 뜬다
		//Calendar cal = new GregorianCalendar 추상클래스라서 자식클래스를 이용해야한다.
		Calendar cal = Calendar.getInstance();//메소드 이용하는 방법 - 시스템 날짜, 시간 이용
		//int year = cal.get(Calendar.YEAR);// 연도가 static final이기 때문에 대문자로 사용된다.
		int year = cal.get(1);//Calendar.YEAR가 자바에 1로 표현된다.
		int month = cal.get(Calendar.MONTH);//달을 가져온다
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//그 주의 요일을 표시
		String week = null;
		switch(dayOfWeek){
			case 1 : week = "일요일"; break;
			case 2 : week = "월요일"; break;
			case 3 : week = "화요일"; break;
			case 4 : week = "수요일"; break;
			case 5 : week = "목요일"; break;
			case 6 : week = "금요일"; break;
			case 7 : week = "토요일"; break;
		}
		System.out.println(year+"년"+(month+1)+"월"+day+"일"+week);
	}
}
