import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ChatServerObject {
	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list;

	public ChatServerObject(){
		try{
			serverSocket = new ServerSocket(9500);
			System.out.println("�����غ�Ϸ�..");

			list = new ArrayList<ChatHandlerObject>();

			while(true){
				Socket socket = serverSocket.accept();//����æ��

				ChatHandlerObject handler = new ChatHandlerObject(socket, list);//������ ����
				handler.start();//������ ����-������ ����(run())

				list.add(handler);
			}//while
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServerObject();
	}
}
