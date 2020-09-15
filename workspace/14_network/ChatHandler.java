import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

class ChatHandler extends Thread{//ó���� �ڵ鷯�ȿ� ������ ����Ʈ�� ���־ ����Ʈ�ȿ� ��ƾ� �Ѵ�.
	private BufferedReader reader;
    private PrintWriter writer;
	private Socket socket;
	private List<ChatHandler> list;

	public ChatHandler(Socket socket, List<ChatHandler> list){
		this.socket = socket;
		this.list = list;
		
		try {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Ŭ���̾�Ʈ�� ���� ���� ���� �ޱ�
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//Ŭ���̾�Ʈ�� �ٽú����ֱ�
		 }catch (IOException e) {
            
		  e.printStackTrace();
           
        }
	}

	public void run(){
		//Ŭ���̾�Ʈ�κ��� �ޱ�
		//�г����� ������
		try {
		String nickName = reader. readLine();//�г��� â�� ������ �ϱ�
		broadcast(nickName+"�� �����Ͽ����ϴ�.");//��� Ŭ���̾�Ʈ���� ���� �޼����� ������ �Ѵ�.

		String line;
		while(true){
			line = reader. readLine();//â�� �޽����� ��ӳ��;� �ϴϱ� �ݺ����� ����Ѵ�.
			if(line==null || line.equals("exit")){
				//�������� exit�� ���� Ŭ���̾�Ʈ���� �亯 ������
			 	 writer.println("exit");
			 	 writer.flush();

				 reader.close();
                 writer.close();
                 socket.close();

				//�����ִ� Ŭ���̾�Ʈ���� ����޼��� ������
				 list.remove(this);//ä�ù��� ������ ����Ʈ�ȿ� �ִ� handler�� ������� �Ѵ�.
				 
				broadcast(nickName+"�� �����Ͽ����ϴ�.");//broadcast�� �������ٸ� ���Ͽ��� �޽����� �����ش�.
				break;								//list �ȿ��� handler���� ������� �Ѵ�.
			}//if
			//��� Ŭ���̾�Ʈ���� �޼��� ������
			broadcast("["+nickName+"]"+line);

		}//while



		}catch (IOException e) {
            
		  e.printStackTrace();
           
        }
		//Ŭ���̾�Ʈ�� ������
	}

	public void broadcast(String msg){
		for(ChatHandler handler : list){//����Ʈ�ȿ� �ڵ鷯�� �ϳ��� ������ ������ ���۸� ����ִ°��� �ݺ��Ѵ�.
			handler.writer.println(msg);//�ڵ鷯 �ȿ��� �����͸� ����ؼ� msg�� ��Ӻ����ֱ�
			handler.writer.flush();

		}//for
	}
}
