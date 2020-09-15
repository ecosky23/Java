import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
class ObjectMain{
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		PersonDTO dto = new PersonDTO("홍길동",25,185.3);

/*
		ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream("result2.txt"));//텍스트 파일을 만들고
		oos.writeObject(dto);											//내용을 안으로 집어늠
		oos.close();
*/


		ObjectInputStream ois = 
			new ObjectInputStream(new FileInputStream("result2.txt"));//result2에 있는 내용을 가져오게 하기 
		PersonDTO dto2 = (PersonDTO)ois.readObject();//object데이터 타입을 PersonDTO로 형변환
		System.out.println("이름 = "+dto2.getName());
		System.out.println("나이 = "+dto2.getAge());
		System.out.println("키 = "+dto2.getHeight());
		ois.close();

	}
}
