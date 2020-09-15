import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ProtocolClient {
    private Socket socket;
    private BufferedReader keyboard;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String msg;
    private String line;

    public ProtocolClient() {
        try {
            socket = new Socket("192.168.0.33", 9500);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            keyboard = new BufferedReader(new InputStreamReader(System.in));

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("������ ������ �ȵǾ����ϴ�.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void service() {
        while (true) {
            // ������ ������
            try {
                msg = keyboard.readLine();
                // ���Ͱ��� ��ġ����
                writer.write(msg + "\n");// ������ ���Ͱ��� ������ ���⼭ ó������� �Ѵ�
                writer.flush();// �����ѹ� ��� �༭ ��� ���ֱ�

            } catch (IOException e) {
                e.printStackTrace();
            }

            // �����κ��� �ޱ�
            try {
                line = reader.readLine();

                System.out.println(line);
                String[] ar = msg.split(":");// :�� �������� �迭�� �����ֱ� " 200", "angel"
                if (ar[0].equals("200")) {
                    reader.close();
                    writer.close();
                    socket.close();// �ѹ��� �ݾ���� �Ѵ�.

                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } // while

    }

    public static void main(String[] args) throws IOException {
        new ProtocolClient().service();
    }
}