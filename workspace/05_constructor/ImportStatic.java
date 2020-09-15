//import static java.lang.Math.random; //위에 메스가 존재하기 때문에 아래의 매스를 지워줘도 된다.
//import static java.lang.Math.pow;
import static java.lang.Math.*;        //스태틱이라 new를 안써도 된다.
import static java.lang.String.format;
import static java.lang.System.out;		//시스템도 렝이라서 위에사용하면 및에 안써도 된다.
class ImportStatic{
	public static void main(String[] args){
		out.println("난수 = " + random());//0<=난수<1
		out.println("제곱 = " + pow(2,5));
		out.println("소수 이하 2째 자리 = "+ format("%.2f",43.56789));

	}
}
