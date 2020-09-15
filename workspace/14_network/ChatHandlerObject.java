import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

class ChatHandlerObject extends Thread {//ó���� �ڵ鷯�ȿ� ������ ����Ʈ�� ���־ ����Ʈ�ȿ� ��ƾ� �Ѵ�.
	private ObjectInputStream reader;
    private ObjectOutputStream writer;
	private Socket socket;
	private List<ChatHandlerObject> list;
	

	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException{
		this.socket = socket;
		this.list = list;
	
			writer = new ObjectOutputStream(socket.getOutputStream());//Ŭ���̾�Ʈ�� �ٽú����ֱ�
			reader = new ObjectInputStream(socket.getInputStream());//Ŭ���̾�Ʈ�� ���� ���� ���� �ޱ�
		
	}
	
	public void run(){
		//Ŭ���̾�Ʈ�κ��� �ޱ�
		//�г����� ������
		InfoDTO infoDTO = null;
		String nickName = null;

		while(true){
			try {
				infoDTO = (InfoDTO)reader.readObject();

				if(infoDTO.getCommand() == Info.JOIN){
					nickName = infoDTO.getNickName();

					//��� Ŭ���̾�Ʈ���� ���� �޼����� ������
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"���� �����Ͽ����ϴ�.");

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
					sendDTO.setMessage(nickName+"���� �����Ͽ����ϴ�.");

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
			//Ŭ���̾�Ʈ�� ������
		}

	public void broadcast(InfoDTO sendDTO){
		for(ChatHandlerObject handler : list){//����Ʈ�ȿ� �ڵ鷯�� �ϳ��� ������ ������ ���۸� ����ִ°��� �ݺ��Ѵ�.
			try{
				handler.writer.writeObject(sendDTO);//�ڵ鷯 �ȿ��� �����͸� ����ؼ� msg�� ��Ӻ����ֱ�
				handler.writer.flush();
			}catch (IOException e) {
			  e.printStackTrace();
			 }
		}//for
	}
}
