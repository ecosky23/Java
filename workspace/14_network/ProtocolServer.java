import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ProtocolServer {
    private ServerSocket serverSocket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;

    public ProtocolServer() throws IOException {
        serverSocket = new ServerSocket(9500);
        System.out.println("서버준비완료");

        socket = serverSocket.accept();// 낚아 챈다.

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void service() {
        String line;

        while (true) {
            try {
                // 클라이 언트로 부터 오는 메시지 받기
                line = reader.readLine();
                String[] ar = line.split(":");
                if (ar[0].equals("100")) {// "100", "angel"
                    writer.write(ar[1] + "님 입장하였습니다.\n");
                    writer.flush();

                } else if (ar[0].equals("200")) {
                    writer.write(ar[1] + "님 퇴장하였습니다.\n");
                    writer.flush();

                    reader.close();
                    writer.close();
                    socket.close();

                    System.exit(0);

                } else if (ar[0].equals("300")) {
                    writer.write("[" + ar[1] + "]" + ar[2] + "\n");
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 클링언트로 보내기

        } // while

    }

    public static void main(String[] args) throws IOException {
        new ProtocolServer().service();
    }
}