import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

class ChatServerObject{
	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list;//����Ʈ�� �������̽��̴�. �׷��� new�� arraylist�� ���ش�.
			//����Ʈ �ȿ� üƮ �ڵ鷯�� ��ƾ� �Ѵ�. �׷��� ���ʸ����� ���ش�.
	public ChatServerObject(){
		try {
			serverSocket = new ServerSocket(9500);//��Ʈ���� �������� ����
			System.out.println("�����غ�Ϸ�...");

			list = new ArrayList<ChatHandlerObject>();

			while(true){//������ ä��ĥ�� Ŭ���̾�Ʈ ������ ���ö� ���� ����ä�� �ؼ� �ݺ����� ����.
				Socket socket = serverSocket.accept();

				ChatHandlerObject handler = new ChatHandlerObject(socket, list);//üƮ �ڵ鷯�� �����带 ��ӹް�  new�� �ؼ�  ������ ���� ����Ʈ�ȿ� �ڵ鷯�� �ֱ� ������ ����Ʈ�� ���̺����� �Ѵ�
				handler.start();//������ ����- ������ ����(run())

				list.add(handler);
				
			}//while
		}catch (IOException e) {
			 e.printStackTrace(); 
		}
	}

	public static void main(String[] args){
		new ChatServerObject();	
	}
}