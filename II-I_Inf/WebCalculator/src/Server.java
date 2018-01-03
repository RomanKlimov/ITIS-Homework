import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private static ServerSocket serverSocket;
    private static Socket socket;
    /**
     * Port to listen.
     */
    private static final int PORT = 8080;
    /**
     * Default response
     */
    private static final String DEFAULT_MESSAGE = "Should be like x=?&y=?&operation=?(sum, div, mul, sub)";

    public Server() {
        try {
            // Create server listening PORT
            serverSocket = new ServerSocket(Server.PORT);
            // Get new connection
            while ((socket = serverSocket.accept()) != null) {
                // REad request
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                int n = 0;
                boolean GET = false;
                boolean POST = false;
                String param = "";
                while (true) {
                    String s = br.readLine();
                    if (s == null || s.trim().length() == 0) {
                        break;
                    }
                    if (s.split("/")[0].trim().equals("POST")) {
                        POST = true;
                    }
                    if (s.split("/")[0].trim().equals("GET")) {
                        GET = true;
                        if (s.split("/")[1].contains("?")) {
                            s = s.split("/")[1];
                            param = s.substring(s.indexOf("?") + 1, s.indexOf(" ")).trim();
                        }
                    }
                    if (s.split(":")[0].equals("Content-Length")) {
                        n = Integer.parseInt(s.split(":")[1].trim());
                    }
                    System.out.println(s);
                }

                if (!GET && POST && n > 0 && param.length() == 0)
                    for (int i = 0; i < n; i++) {
                        param += (char)br.read();
                    }
                String[] sp = param.split("&");
                int x = 0;
                int y = 0;
                int rez = -1;
                for (String str: sp) {
                    if (str.split("=")[0].equals("x")){
                        x = Integer.parseInt(str.split("=")[1]);
                    }
                    if (str.split("=")[0].equals("y")){
                        y = Integer.parseInt(str.split("=")[1]);
                    }
                    if (str.split("=")[0].equals("operation")){
                        if (str.split("=")[1].equals("sum")){
                            rez = 0;
                        } else if (str.split("=")[1].equals("sub")) {
                            rez = 1;
                        } else if (str.split("=")[1].equals("mul")) {
                            rez = 2;
                        } else if (str.split("=")[1].equals("div")) {
                            rez = 3;
                        } else {
                            rez = 4;
                        }
                    }
                }

                switch (rez){
                    case 0:
                        param = "Rez: " + (x + y);
                        break;
                    case 1:
                        param = "Rez:" + (x - y);
                        break;
                    case 2:
                        param = "Rez:" + (x * y);
                        break;
                    case 3:
                        try {
                            param = "Rez:" + (x / y);
                        } catch (ArithmeticException ex) {
                            param = "infinite";
                        }
                        break;
                    default:
                        param = Server.DEFAULT_MESSAGE;

                }

                // Create and send response
                PrintWriter pr = new PrintWriter(socket.getOutputStream());
                pr.println("HTTP/1.1 200 OK");
                pr.println("Content-type:text/plain;Charset:UTF-8");
                pr.println("Content-length:" + param.length());
                pr.println();

                pr.println(param);
                pr.flush();
                socket.close();
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}