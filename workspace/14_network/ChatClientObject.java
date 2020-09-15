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

        sendBtn = new JButton("보내기");

        output = new JTextArea();
        output.setFont(new Font("돋음체", Font.BOLD, 15));
        output.setEditable(false);// 글자 못들어가게 막기

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

        // 서버IP
        // String serverIP = JOptionPane.showInputDialog(this,"서버IP를
        // 입력하세요","서버IP",JOptionPane.INFORMATION_MESSAGE);
        String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요", "192.168.0.18");
        if (serverIP == null || serverIP.length() == 0) {
            System.out.println("서버IP가 입력되지 않았습니다.");
            System.exit(0);
        }

        // 닉네임 생성

        String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
        if (nickName == null || nickName.length() == 0) {
            nickName = "guest";

        }

        // 소캣 생성

        try {
            socket = new Socket(serverIP, 9500);

            reader = new ObjectInputStream(socket.getInputStream());
            writer = new ObjectOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("서버와 연결이 안되었습니다.");
            e.printStackTrace();
            System.exit(0);
        }

		InfoDTO infoDTO = new InfoDTO();
		infoDTO.setCommand(Info.JOIN);
		infoDTO.setNickName(nickName);

		try{
        // 서버로 닉네임을 보내기
			writer.writeObject(infoDTO);
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}

        // 스레드 생성
        Thread t = new Thread(this);// 스레드 생성

        t.start();// 스레드 시작

        // 이벤트
        input.addActionListener(this);
        sendBtn.addActionListener(this);

    }

    @Override
    public void run() {
        // 서버로 받기
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
						output.setCaretPosition(pos);//자동으로 스크롤이 따라가게 만들기
					}	
				
			}catch (IOException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
                e.printStackTrace();
            }
		}
	}
	
    public void actionPerformed(ActionEvent e) {
        // 서버로 보내기
        String data = input.getText();// input의 내용을 데이터에 넣어주고

		InfoDTO infoDTO = new InfoDTO();
		if(data.equals("exit")){
			infoDTO.setCommand(Info.EXIT);
		}else{
			infoDTO.setCommand(Info.SEND);
			infoDTO.setMessage(data);
		}
		try{
        writer.writeObject(infoDTO);// 읽은 다음 서버로 보낸다
        writer.flush();// 비워준다
		}catch(IOException io){
            io.printStackTrace();
        }
        input.setText("");// 원래글을 지워줌

        // JTextField의 값을 꺼내오기
        // 꺼내온 데이터를 서버로 보내기
        // 버퍼비우기
        // JTextField의 값 초기화
    }

    public static void main(String[] args) {
        new ChatClientObject().service();
    }
}
