import java.io.*;
class ByteStream2{
	public static void main(String[] args)throws IOException{
		File file = new File("data.txt");

		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		int size = (int)file.length();//파일의 크기

		byte[] b = new byte[size];

		bis.read(b, 0, size);// 배열 b, 몇 번째 방부터인지, 크기

		System.out.println(new String(b));
			
		bis.close();
	}
}
