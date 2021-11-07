package Server;

import common.RemoteMessageList;
import common.ReplyTo;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList {

    private ArrayList<String> list;

    public RemoteMessageServer() throws RemoteException, MalformedURLException {
        this.list = new ArrayList<>();
        //startup the registry so we can upload the server to the registry
        Registry registry = LocateRegistry.getRegistry(1099);
        System.out.println("Registry started..");
        //making the server remote object so the client can call the server
        UnicastRemoteObject.exportObject(this,0);
        //we upload the server to the registry so the client can find the server
        Naming.rebind("server", this);
    }

    @Override
    public void addMessage(String msg, ReplyTo who) throws RemoteException {
         list.add(msg);
         who.replyMessage("thank you!");
    }
}
