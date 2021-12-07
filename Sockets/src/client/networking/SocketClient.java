package client.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    private SocketClientHandler handler;
    public SocketClient() {
    }
    public void start() throws IOException {
        try (
                //open a new socket with this host and port number
                Socket socket = new Socket("127.0.0.1", 1234);
        ) {
            //created a new socket handler class, then reference to ourselves so we can receive the message that was send from the server
            this.handler = new SocketClientHandler(this, socket);
            //making a new threat
            Thread handlerThread = new Thread(handler);
            //when you close the app it will close running thread
            handlerThread.setDaemon(true);
            //start the thread
            handlerThread.start();
            while (true) {
                String messageFromClient = new Scanner(System.in).nextLine();
                if (messageFromClient.equals("exit")){
                    break;
                }
                handler.sendMessage(messageFromClient);
            }
        }
    }
     //method called everytime from the client handler to process the received message
    public void messageReceived(String message) {
        System.out.println(message);
    }
}
