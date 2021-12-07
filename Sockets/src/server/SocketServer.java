package server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private Pool pool;

    public SocketServer(){
        pool = new Pool();
    }

    public void StartServer(){
        System.out.println("Starting server..");
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);

            while (true) {
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected");

                ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
