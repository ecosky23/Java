import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class URLTest{
	public static void main(String[] args)throws MalformedURLException, IOException{
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("프로토콜 = "+url.getProtocol());
		System.out.println("호스트 ="+url.getHost());
		System.out.println("포트 ="+url.getPort());//포트가 정해져 있지 않아서 -1이 나온다.
		System.out.println("기본 포트 ="+url.getDefaultPort());//HTTPS : 443
		System.out.println("파일 ="+url.getFile());
		System.out.println();

		//----------------------------
		
		
		InputStreamReader isr = new InputStreamReader(url.openStream());
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		while((line=br.readLine()) != null){//라인의 것을 한줄씩 읽기
			System.out.println(line);
		}
		br.close();
	}
}

//URL
//URI - 범위가 더 크다 
