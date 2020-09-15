import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

class ChatHandler extends Thread{//처리부 핸들러안에 리더와 라이트가 다있어서 리스트안에 담아야 한다.
	private BufferedReader reader;
    private PrintWriter writer;
	private Socket socket;
	private List<ChatHandler> list;

	public ChatHandler(Socket socket, List<ChatHandler> list){
		this.socket = socket;
		this.list = list;
		
		try {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//클라이언트로 부터 오는 것을 받기
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//클라이언트로 다시보내주기
		 }catch (IOException e) {
            
		  e.printStackTrace();
           
        }
	}

	public void run(){
		//클라이언트로부터 받기
		//닉네임이 먼저옴
		try {
		String nickName = reader. readLine();//닉네임 창에 나오게 하기
		broadcast(nickName+"님 입장하였습니다.");//모든 클라이언트에게 입장 메세지를 보내야 한다.

		String line;
		while(true){
			line = reader. readLine();//창에 메시지가 계속나와야 하니까 반복문을 사용한다.
			if(line==null || line.equals("exit")){
				//나가려고 exit를 보낸 클라이언트에게 답변 보내기
			 	 writer.println("exit");
			 	 writer.flush();

				 reader.close();
                 writer.close();
                 socket.close();

				//남아있는 클라이언트에게 퇴장메세지 보내기
				 list.remove(this);//채팅방을 나가면 리스트안에 있는 handler도 지워줘야 한다.
				 
				broadcast(nickName+"님 퇴장하였습니다.");//broadcast는 나머지다른 소켓에도 메시지를 보내준다.
				break;								//list 안에도 handler에도 지워줘야 한다.
			}//if
			//모든 클라이언트에게 메세지 보내기
			broadcast("["+nickName+"]"+line);

		}//while



		}catch (IOException e) {
            
		  e.printStackTrace();
           
        }
		//클라이언트로 보내기
	}

	public void broadcast(String msg){
		for(ChatHandler handler : list){//리스트안에 핸들러를 하나씩 꺼내서 보내고 버퍼를 비워주는것을 반복한다.
			handler.writer.println(msg);//핸들러 안에서 라이터를 사용해서 msg를 계속보내주기
			handler.writer.flush();

		}//for
	}
}
