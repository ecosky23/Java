import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class URLTest2{
	
	public static void main(String[] args)throws IOException{
		
		URL url = new URL("http://www.liebli.com/");
		
	//	InputStreamReader isr = new InputStreamReader(url.openStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		int count = 0;
		int gold = 0;
		int idx;
		String k = null;
			while((k = br.readLine()) != null){//null�� ���ö� ���� ������ ���� ���پ� �б�
					k=k.toLowerCase();//�ҹ��ڷ� ��ȯ
					idx=0;
					while((idx = k.indexOf("14k", idx))!=-1){//-1���ö� ���� ��� ����
						count++;
						idx=idx+("14k".length());//�ѹ� ã�� 14k�� ���� �ٽ� ã�� ���� �ʱ� ����
													//14k������ �������� �ٽ� ã�� �Ϸ��� ���̰� ����.
					}
				
				/*if(k.contains("14k") || k.contains("14K")){
					 count++;
				}else if(k.contains("18k") || k.contains("18K")){
					gold++;
				}*/
				//System.out.println(k);
			}

		System.out.println("14k�� ���� = "+ count);
		System.out.println("18k�� ���� = "+ gold);
		br.close();
	}
}
