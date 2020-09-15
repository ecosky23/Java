import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

class ChatClientObject extends JFrame implements ActionListener, Runnable {

    private JButton sendBtn;
    private JTextArea output;
    private JTextField input;
    private JScrollPane scroll;
    private ObjectInputStream reader;
    private Socket socket;
    private ServerSocket serverSocket;
    private ObjectOutputStream writer;
    private InfoDTO infoDTO;

    public ChatClientObject() {

        sendBtn = new JButton("������");

        output = new JTextArea();
        output.setFont(new Font("����ü", Font.BOLD, 15));
        output.setEditable(false);// ���� ������ ����

        input = new JTextField();

        scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Container c = getContentPane();

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(1, 1, 5, 5));

        JPanel p2 = new JPanel();

        p2.setLayout(new BorderLayout());

        p1.add(scroll);
        p2.add(input);
        p2.add("East", sendBtn);

        c.add("Center", p1);
        c.add("South", p2);

        setBounds(700, 200, 300, 300);
        setVisible(true);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
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

    public void service() {

        // ����IP
        // String serverIP = JOptionPane.showInputDialog(this,"����IP��
        // �Է��ϼ���","����IP",JOptionPane.INFORMATION_MESSAGE);
        String serverIP = JOptionPane.showInputDialog(this, "����IP�� �Է��ϼ���", "192.168.0.18");
        if (serverIP == null || serverIP.length() == 0) {
            System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�.");
            System.exit(0);
        }

        // �г��� ����

        String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���", "�г���", JOptionPane.INFORMATION_MESSAGE);
        if (nickName == null || nickName.length() == 0) {
            nickName = "guest";

        }

        // ��Ĺ ����

        try {
            socket = new Socket(serverIP, 9500);

            reader = new ObjectInputStream(socket.getInputStream());
            writer = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("������ ������ �ȵǾ����ϴ�.");
            e.printStackTrace();
            System.exit(0);
        }

		InfoDTO infoDTO = new InfoDTO();
		infoDTO.setCommand(Info.JOIN);
		infoDTO.setNickName(nickName);

		try{
        // ������ �г����� ������
			writer.writeObject(infoDTO);
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}

        // ������ ����
        Thread t = new Thread(this);// ������ ����

        t.start();// ������ ����

        // �̺�Ʈ
        input.addActionListener(this);
        sendBtn.addActionListener(this);

    }

    @Override
    public void run() {
        // ������ �ޱ�
       InfoDTO infoDTO = null;

       
            while (true) {
				 try{
					infoDTO = (InfoDTO)reader.readObject();
					if (infoDTO.getCommand() == Info.EXIT) {
						reader.close();
						writer.close();
						socket.close();
                    
						System.exit(0);
					}else if(infoDTO.getCommand() == Info.SEND){
						output.append(infoDTO.getMessage()+"\n");
					
						int pos = output.getText().length();
						output.setCaretPosition(pos);//�ڵ����� ��ũ���� ���󰡰� �����
					}	
				
			}catch (IOException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
                e.printStackTrace();
            }
		}
	}
	
    public void actionPerformed(ActionEvent e) {
        // ������ ������
        String data = input.getText();// input�� ������ �����Ϳ� �־��ְ�

		InfoDTO infoDTO = new InfoDTO();
		if(data.equals("exit")){
			infoDTO.setCommand(Info.EXIT);
		}else{
			infoDTO.setCommand(Info.SEND);
			infoDTO.setMessage(data);
		}
		try{
        writer.writeObject(infoDTO);// ���� ���� ������ ������
        writer.flush();// ����ش�
		}catch(IOException io){
            io.printStackTrace();
        }
        input.setText("");// �������� ������

        // JTextField�� ���� ��������
        // ������ �����͸� ������ ������
        // ���ۺ���
        // JTextField�� �� �ʱ�ȭ
    }

    public static void main(String[] args) {
        new ChatClientObject().service();
    }
}
