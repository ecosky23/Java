import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;

class NumberTest{
	public static void main(String[] args){
		NumberFormat nf = new DecimalFormat(); //데시멀 포맷은 넘버포맷의 자식형이다.
		//DecimalFormat 3자리 마다 쉼표(,)를 찍는다. 소수점 이하 3자리 까지 나타남
		System.out.println(nf.format(12345678.456789));//자식 클레스 이용
		System.out.println(nf.format(12345678));
		System.out.println();

		NumberFormat nf2 = new DecimalFormat("#,###.##원"); 
		//유효숫자가 아닌것은 표현하지 않는다.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		NumberFormat nf3 = new DecimalFormat("#,###.00원"); 
		//0은 강제로 표시
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();

		//NumberFormat nf4 = NumberFormat.getInstance();//메소드를 이용해서 생성 이안에서 클래스를
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();//환율 원가 표시:￦
		nf4.setMaximumFractionDigits(2);//소수이하 2째짜리 까지 보여줌
		nf4.setMinimumFractionDigits(2);//소수이하 값이 없어도 0이 강제로 출력된다.
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();

		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();

	
	
	}
}
/*		1,234.57		1234
#,###.## 1,234.57		1,234
#,###.00 1,234.57		1,234.00



*/