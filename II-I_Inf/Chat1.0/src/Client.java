import java.io.*;
import java.net.Socket;

public class Client {

    public void go() {

        try{

            Socket socket = new Socket("127.0.0.1", 3301);

            System.out.println("Server connected: " + socket);

            String s = "";

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream outr = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            while (!s.equals("exit")) {

                try {

                    s = input.readLine();
                    out.writeUTF(s);
                    out.flush();

                    String line = outr.readUTF();
                    System.out.println(line);

                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }

            }

            socket.close();
            input.close();
            out.close();
            outr.close();

        } catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }

}
