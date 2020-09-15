import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
class DataStream{
	public static void main(String[] args) throws IOException{
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		//DataOutputStream으로 버퍼로 데이터를 보내고 FileOutputStream 으로 데이터를 파일인 
		// result.txt로 보낸다.
		FileOutputStream fos = new FileOutputStream("result.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("홍길동");//입력
		dos.writeInt(25);
		dos.writeDouble(185.3);
		dos.close();//닫아줘야 한다.

		FileInputStream fis = new FileInputStream("result.txt");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println("이름 = "+dis.readUTF());
		System.out.println("나이 = "+dis.readInt());
		System.out.println("키 = "+dis.readDouble());
	}
}
