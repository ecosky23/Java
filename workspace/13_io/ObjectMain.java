import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
class ObjectMain{
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		PersonDTO dto = new PersonDTO("ȫ�浿",25,185.3);

/*
		ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream("result2.txt"));//�ؽ�Ʈ ������ �����
		oos.writeObject(dto);											//������ ������ �����
		oos.close();
*/


		ObjectInputStream ois = 
			new ObjectInputStream(new FileInputStream("result2.txt"));//result2�� �ִ� ������ �������� �ϱ� 
		PersonDTO dto2 = (PersonDTO)ois.readObject();//object������ Ÿ���� PersonDTO�� ����ȯ
		System.out.println("�̸� = "+dto2.getName());
		System.out.println("���� = "+dto2.getAge());
		System.out.println("Ű = "+dto2.getHeight());
		ois.close();

	}
}
