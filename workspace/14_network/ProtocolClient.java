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
            System.out.println("서버와 연결이 안되었습니다.");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void service() {
        while (true) {
            // 서버로 보내기
            try {
                msg = keyboard.readLine();
                // 엔터값도 가치간다
                writer.write(msg + "\n");// 위에서 엔터값을 보내서 여기서 처리해줘야 한다
                writer.flush();// 버퍼한번 비워 줘서 찌꺼기 없애기

            } catch (IOException e) {
                e.printStackTrace();
            }

            // 서버로부터 받기
            try {
                line = reader.readLine();

                System.out.println(line);
                String[] ar = msg.split(":");// :을 기준으로 배열로 나눠주기 " 200", "angel"
                if (ar[0].equals("200")) {
                    reader.close();
                    writer.close();
                    socket.close();// 한번씩 닫아줘야 한다.

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