import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

class ChatHandlerObject extends Thread {//처리부 핸들러안에 리더와 라이트가 다있어서 리스트안에 담아야 한다.
	private ObjectInputStream reader;
    private ObjectOutputStream writer;
	private Socket socket;
	private List<ChatHandlerObject> list;
	

	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException{
		this.socket = socket;
		this.list = list;
	
			writer = new ObjectOutputStream(socket.getOutputStream());//클라이언트로 다시보내주기
			reader = new ObjectInputStream(socket.getInputStream());//클라이언트로 부터 오는 것을 받기
		
	}
	
	public void run(){
		//클라이언트로부터 받기
		//닉네임이 먼저옴
		InfoDTO infoDTO = null;
		String nickName = null;

		while(true){
			try {
				infoDTO = (InfoDTO)reader.readObject();

				if(infoDTO.getCommand() == Info.JOIN){
					nickName = infoDTO.getNickName();

					//모든 클라이언트에게 입장 메세지를 보내기
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"님이 입장하였습니다.");

					broadcast(sendDTO);

				}else if(infoDTO.getCommand() == Info.EXIT){
					InfoDTO sendDTO = new InfoDTO();
					//나가려고 exit를 보낸 클라이언트에게 답변 보내기
					sendDTO.setCommand(Info.EXIT);
					writer.writeObject(sendDTO);
					writer.flush();

					 reader.close();
					 writer.close();
					 socket.close();

					//남아있는 클라이언트에게 퇴장메세지 보내기
					list.remove(this);

					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"님이 퇴장하였습니다.");

					broadcast(sendDTO);

					break;

				}else if(infoDTO.getCommand() == Info.SEND){
					InfoDTO sendDTO = new InfoDTO();

					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("["+nickName+"]"+infoDTO.getMessage());

					broadcast(sendDTO);
				}
			}catch(IOException io){
				io.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			}//while	
			//클라이언트로 보내기
		}

	public void broadcast(InfoDTO sendDTO){
		for(ChatHandlerObject handler : list){//리스트안에 핸들러를 하나씩 꺼내서 보내고 버퍼를 비워주는것을 반복한다.
			try{
				handler.writer.writeObject(sendDTO);//핸들러 안에서 라이터를 사용해서 msg를 계속보내주기
				handler.writer.flush();
			}catch (IOException e) {
			  e.printStackTrace();
			 }
		}//for
	}
}
