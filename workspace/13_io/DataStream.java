import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
class DataStream{
	public static void main(String[] args) throws IOException{
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		//DataOutputStream���� ���۷� �����͸� ������ FileOutputStream ���� �����͸� ������ 
		// result.txt�� ������.
		FileOutputStream fos = new FileOutputStream("result.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("ȫ�浿");//�Է�
		dos.writeInt(25);
		dos.writeDouble(185.3);
		dos.close();//�ݾ���� �Ѵ�.

		FileInputStream fis = new FileInputStream("result.txt");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println("�̸� = "+dis.readUTF());
		System.out.println("���� = "+dis.readInt());
		System.out.println("Ű = "+dis.readDouble());
	}
}
