import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class URLTest{
	public static void main(String[] args)throws MalformedURLException, IOException{
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("�������� = "+url.getProtocol());
		System.out.println("ȣ��Ʈ ="+url.getHost());
		System.out.println("��Ʈ ="+url.getPort());//��Ʈ�� ������ ���� �ʾƼ� -1�� ���´�.
		System.out.println("�⺻ ��Ʈ ="+url.getDefaultPort());//HTTPS : 443
		System.out.println("���� ="+url.getFile());
		System.out.println();

		//----------------------------
		
		
		InputStreamReader isr = new InputStreamReader(url.openStream());
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		while((line=br.readLine()) != null){//������ ���� ���پ� �б�
			System.out.println(line);
		}
		br.close();
	}
}

//URL
//URI - ������ �� ũ�� 
