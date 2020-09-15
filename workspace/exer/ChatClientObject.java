import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private ObjectInputStream reader;
	private ObjectOutputStream writer;

	public ChatClientObject(){
		output = new JTextArea();
		output.setFont(new Font("����ü", Font.BOLD, 16));
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		input = new JTextField();
		sendBtn = new JButton("������");

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add("Center", input);
		p.add("East", sendBtn);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);
		
		setBounds(700,200,300,300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void	windowClosing(WindowEvent e){
				InfoDTO infoDTO = new InfoDTO();
				infoDTO.setCommand(Info.EXIT);
				try{
					writer.writeObject(infoDTO);
					writer.flush();
				}catch(IOException io){
					io.printStackTrace();
				}
			}
		});
	}

	public void service(){
		//����IP
		//String serverIP = JOptionPane.showInputDialog(this,"����IP�� �Է��ϼ���","����IP",JOptionPane.INFORMATION_MESSAGE);
		String serverIP = JOptionPane.showInputDialog(this,"����IP�� �Է��ϼ���","192.168.0.18");
		if(serverIP==null || serverIP.length()==0){
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}

		//�г���
		String nickName = JOptionPane.showInputDialog(this,"�г����� �Է��ϼ���","�г���",JOptionPane.INFORMATION_MESSAGE);
		if(nickName==null || nickName.length()==0){
			nickName="guest";
		}
		
		try{
			//���� ����
			socket = new Socket(serverIP, 9500);

			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());

		}catch(UnknownHostException e){
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("������ ������ �ȵǾ����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}

		//������ �г��� ������
		InfoDTO infoDTO = new InfoDTO();
		infoDTO.setCommand(Info.JOIN);
		infoDTO.setNickName(nickName);
		try{
			writer.writeObject(infoDTO);
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}

		Thread t = new Thread(this);//������ ����
		t.start();//������ ���� - ������ ����

		//�̺�Ʈ
		input.addActionListener(this);
		sendBtn.addActionListener(this);
	}

	@Override
	public void run(){
		//�����κ��� �ޱ�
		InfoDTO infoDTO = null;

		while(true){
			try{
				infoDTO = (InfoDTO)reader.readObject();
				if(infoDTO.getCommand() == Info.EXIT) {
					reader.close();
					writer.close();
					socket.close();

					System.exit(0);

				}else if(infoDTO.getCommand() == Info.SEND){
					output.append(infoDTO.getMessage()+"\n");

					int pos = output.getText().length();
					output.setCaretPosition(pos);
				}

			}catch(IOException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}//while
	}

	@Override
	public void actionPerformed(ActionEvent e){
		//������ ������
		String data = input.getText();

		InfoDTO infoDTO = new InfoDTO();
		if(data.equals("exit")){
			infoDTO.setCommand(Info.EXIT);

		}else{
			infoDTO.setCommand(Info.SEND);
			infoDTO.setMessage(data);
		}
		
		try{
			writer.writeObject(infoDTO);
			writer.flush();
		}catch(IOException io){
			io.printStackTrace();
		}
		input.setText("");
	}

	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}
