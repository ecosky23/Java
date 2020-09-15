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
                writer.println("exit");
                writer.flush();
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

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("������ ������ �ȵǾ����ϴ�.");
            e.printStackTrace();
            System.exit(0);
        }

        // ������ �г����� ������
        writer.println(nickName);
        writer.flush();

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
                output.setCaretPosition(pos);//�ڵ����� ��ũ���� ���󰡰� �����
            }//while
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        // ������ ������
        String data = input.getText();// input�� ������ �����Ϳ� �־��ְ�
        writer.println(data);// ���� ���� ������ ������
        writer.flush();// ����ش�
        input.setText("");// �������� ������

        // JTextField�� ���� ��������
        // ������ �����͸� ������ ������
        // ���ۺ���
        // JTextField�� �� �ʱ�ȭ
    }

    public static void main(String[] args) {
        new ChatClient().service();
    }
}