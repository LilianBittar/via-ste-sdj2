import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList {

    private ArrayList<String> list;

    public RemoteMessageServer() throws RemoteException, MalformedURLException {
        this.list = new ArrayList<>();

        // Making the server remote object so the client can call the server.
        UnicastRemoteObject.exportObject(this, 0);

        // We upload the server to the registry so the client can find the server.
        Naming.rebind("server", this);
    }

    @Override
    public void addMessage(String msg, ReplyTo who) throws RemoteException {
         list.add(msg);
         System.out.println("Message from client: " + msg);
         who.replyMessage("thank you!");
    }
}
