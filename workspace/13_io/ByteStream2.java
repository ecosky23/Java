import java.io.*;
class ByteStream2{
	public static void main(String[] args)throws IOException{
		File file = new File("data.txt");

		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		int size = (int)file.length();//������ ũ��

		byte[] b = new byte[size];

		bis.read(b, 0, size);// �迭 b, �� ��° ���������, ũ��

		System.out.println(new String(b));
			
		bis.close();
	}
}
