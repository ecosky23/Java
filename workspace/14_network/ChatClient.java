import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

class ChatClient extends JFrame implements ActionListener, Runnable {

    private JButton sendBtn;
    private JTextArea output;
    private JTextField input;
    private JScrollPane scroll;
    private BufferedReader reader;
    private Socket socket;
    private ServerSocket serverSocket;
    private PrintWriter writer;
    private String line;

    public ChatClient() {

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
                writer.println("exit");
                writer.flush();
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

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("서버와 연결이 안되었습니다.");
            e.printStackTrace();
            System.exit(0);
        }

        // 서버로 닉네임을 보내기
        writer.println(nickName);
        writer.flush();

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
        String line;
        try {
            while (true) {
                line = reader.readLine();
                if (line == null || line.equals("exit")) {
                    reader.close();
                    writer.close();
                    socket.close();
                    
                    System.exit(0);
                }
                output.append(line+"\n");
                
                int pos = output.getText().length();
                output.setCaretPosition(pos);//자동으로 스크롤이 따라가게 만들기
            }//while
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        // 서버로 보내기
        String data = input.getText();// input의 내용을 데이터에 넣어주고
        writer.println(data);// 읽은 다음 서버로 보낸다
        writer.flush();// 비워준다
        input.setText("");// 원래글을 지워줌

        // JTextField의 값을 꺼내오기
        // 꺼내온 데이터를 서버로 보내기
        // 버퍼비우기
        // JTextField의 값 초기화
    }

    public static void main(String[] args) {
        new ChatClient().service();
    }
}