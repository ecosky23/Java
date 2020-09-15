import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ChatHandlerObject extends Thread {
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket socket;
	private List<ChatHandlerObject> list;

	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;

		writer = new ObjectOutputStream(socket.getOutputStream());
		reader = new ObjectInputStream(socket.getInputStream());
	}

	public void run(){
		InfoDTO infoDTO = null;
		String nickName = null;
		
		while(true){
			try{
				//Ŭ���̾�Ʈ�κ��� �ޱ�
				//�г���
				infoDTO = (InfoDTO)reader.readObject();

				if(infoDTO.getCommand() == Info.JOIN){
					nickName = infoDTO.getNickName();
					
					//��� Ŭ���̾�Ʈ���� ����޼����� ������
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"�� �����Ͽ����ϴ�");

					broadcast(sendDTO);

				}else if(infoDTO.getCommand() == Info.EXIT){
					InfoDTO sendDTO = new InfoDTO();

					//�������� exit�� ���� Ŭ���̾�Ʈ���� �亯 ������
					sendDTO.setCommand(Info.EXIT);
					writer.writeObject(sendDTO);
					writer.flush();

					reader.close();
					writer.close();
					socket.close();

					//�����ִ� Ŭ���̾�Ʈ���� ����޼��� ������
					list.remove(this);

					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"�� �����Ͽ����ϴ�");

					broadcast(sendDTO);

					break;

				}else if(infoDTO.getCommand() == Info.SEND){
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("["+nickName+"] " + infoDTO.getMessage());

					broadcast(sendDTO);
				}
			}catch(IOException io){
				io.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}//while
	}
	
	public void broadcast(InfoDTO sendDTO){
		for(ChatHandlerObject handler : list){
			try{
				handler.writer.writeObject(sendDTO);
				handler.writer.flush();
			}catch(IOException io){
				io.printStackTrace();
			}
		}//for
	}
}
