import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Server {
    public void go(){

        try{
            ServerSocket server = new ServerSocket(3301);

            System.out.println("Server running: " + server);
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket);
            String s = "";

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream outr = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            boolean exit = false;

            while(!exit){

                try{
                    s = input.readLine();
                    out.writeUTF(s);
                    out.flush();

                    String line = outr.readUTF();
                    System.out.println(line);

                }catch(IOException e){
                    System.out.println("Server stopped" + e.getMessage());
                    exit = true;
                }
            }
            socket.close();
            outr.close();
            out.close();

        }catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }


    }

    public static void main(String[] args) {
        Server server = new Server();
        server.go();
    }


}
