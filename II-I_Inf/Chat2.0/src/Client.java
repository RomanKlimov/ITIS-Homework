import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }

    public void go() {
        setUpNetworking();

        Thread readerThred = new Thread(new IncomingReader());
        readerThred.start();

        String line = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (!line.equals("exit")){
            try {
                line = input.readLine();
                writer.println(line);
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 3301);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null){
                    System.out.println("read " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
