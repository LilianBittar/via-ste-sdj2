import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageClient implements ReplyTo {

    private RemoteMessageList server;

    public RemoteMessageClient() throws RemoteException, MalformedURLException, NotBoundException {
        UnicastRemoteObject.exportObject(this,0);
        server = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/server");
        server.addMessage("hello from client",this);
    }

    @Override
    public void replyMessage(String msg) {
        System.out.println(msg);
    }

}
