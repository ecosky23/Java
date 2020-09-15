import java.net.InetAddress;
import java.net.UnknownHostException;
class InetAddressTest{
	public static void main(String[] args)throws UnknownHostException{
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("NAVAR IP ="+naver.getHostAddress());
		System.out.println();
		//서버 - 서비스를 제공

		InetAddress local = InetAddress.getLocalHost();//자신의 아이피를 얻기위해
		System.out.println("localhost IP ="+ local.getHostAddress());
		System.out.println();

		InetAddress[] ar = InetAddress.getAllByName("www.daum.net");
		for(InetAddress data : ar){
		System.out.println("Daum IP ="+data.getHostAddress());
		}
	}
}
