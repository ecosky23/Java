import java.io.*;
class ByteStream{
	public static void main(String[] args)throws IOException{
		FileInputStream fis = new FileInputStream("data.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
			
		int data;
		while((data=bis.read()) !=-1){//더이상 숫자가 없으면 마지막 숫자가 -1이 된다.
				System.out.println((char)data);//아스키 코드값으로 나온다 (숫자) 13,10은 엔터이다.
		}
	}
}
