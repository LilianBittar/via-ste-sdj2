package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private Pool pool;
    private ServerSocketHandler serverSocketHandler;

    public SocketServer(){
        pool = new Pool();
    }

    public void StartServer(){
        System.out.println("Starting server..");
        try {
            //initialize the server socket class in order to be able to accept new clients
            ServerSocket welcomeSocket = new ServerSocket(2910);
            while (true) {
                //waits and listens until a new client connects
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected");
                //create new socket server handler to handler a new client
                // we pass it a reference of the socket and the pool in order to communicate with the client
                serverSocketHandler = new ServerSocketHandler(socket, pool);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
