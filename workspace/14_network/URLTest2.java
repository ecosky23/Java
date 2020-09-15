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
			while((k = br.readLine()) != null){//null이 나올때 까지 라인의 것을 한줄씩 읽기
					k=k.toLowerCase();//소문자로 전환
					idx=0;
					while((idx = k.indexOf("14k", idx))!=-1){//-1나올때 까지 계속 돌림
						count++;
						idx=idx+("14k".length());//한번 찾은 14k의 값을 다시 찾게 하지 않기 위해
													//14k순서의 다음부터 다시 찾게 하려고 길이가 들어갔다.
					}
				
				/*if(k.contains("14k") || k.contains("14K")){
					 count++;
				}else if(k.contains("18k") || k.contains("18K")){
					gold++;
				}*/
				//System.out.println(k);
			}

		System.out.println("14k의 개수 = "+ count);
		System.out.println("18k의 개수 = "+ gold);
		br.close();
	}
}
