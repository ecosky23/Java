import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

class ChatServer{
	private ServerSocket serverSocket;
	private List<ChatHandler> list;//리스트는 인터페이스이다. 그래서 new를 arraylist로 해준다.
			//리스트 안에 체트 핸들러를 담아야 한다. 그래서 제너릭으로 써준다.
	public ChatServer(){
		try {
			serverSocket = new ServerSocket(9500);//포트열고 서버소켓 생성
			System.out.println("서버준비완료...");

			list = new ArrayList();

			while(true){//여러면 채팅칠때 클라이언트 서버가 들어올때 마다 낚아채야 해서 반복문을 슨다.
				Socket socket = serverSocket.accept();

				ChatHandler handler = new ChatHandler(socket, list);//체트 핸들러가 스레드를 상속받고  new를 해서  스레드 생성 리스트안에 핸들러가 있기 때문에 리스트도 같이보내야 한다
				handler.start();//스레드 시작- 스레드 실행(run())

				list.add(handler);
				
			}//while
		}catch (IOException e) {
			 e.printStackTrace(); 
		}
	}

	public static void main(String[] args){
		new ChatServer();	
	}
}
