import java.io.*;
class ByteStream{
	public static void main(String[] args)throws IOException{
		FileInputStream fis = new FileInputStream("data.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
			
		int data;
		while((data=bis.read()) !=-1){//���̻� ���ڰ� ������ ������ ���ڰ� -1�� �ȴ�.
				System.out.println((char)data);//�ƽ�Ű �ڵ尪���� ���´� (����) 13,10�� �����̴�.
		}
	}
}
