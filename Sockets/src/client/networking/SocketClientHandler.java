package client.networking;

import transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//represents a thread to handle each message from the server
public class SocketClientHandler implements Runnable{
    private SocketClient client;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public SocketClientHandler(SocketClient client, Socket socket) throws IOException {
        this.client = client;
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
    }
    @Override
    public void run() {
        try {
            while (true) {
                //read from the server stream
                Message message = (Message) in.readObject();
                System.out.println("Read message " + message.getMsg());
                //the message we just receive we passed to socket client class that performs the needed functionality
                client.messageReceived(message.getMsg());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(String message) {
        try {
            //send a message to the server
            System.out.println("Sending message:" + message);
            out.writeObject(new Message(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
