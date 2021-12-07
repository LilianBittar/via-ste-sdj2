package server;

import transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//represents a thread responsible for handling each individual client
public class ServerSocketHandler  implements Runnable{
    private Socket socket;
    private Pool pool;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    public ServerSocketHandler(Socket socket, Pool pool) throws IOException{
        this.socket = socket;
        this.pool = pool;
        //initialize the input and output streams for the socket connection
        inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
    }
    //method to send message to our particular client
    public void sendMessage(String msg) throws IOException {
        outputStream.writeObject(new Message(msg));
    }
    @Override
    public void run() {
        try {
            System.out.println("Hello from the server. Write your name");

            while (true) {
                //waiting to get an input message from the client
                String messageFromClient = ((Message) inputStream.readObject()).getMsg();
                //print the message out to the console in the server
                System.out.println("Message:" + messageFromClient);
                if (messageFromClient.equals("exit")) {
                    pool.removeConn(this);
                    break;
                }
                pool.broadcast(messageFromClient);
            }
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
