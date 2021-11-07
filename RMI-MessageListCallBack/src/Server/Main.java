package Server;

import java.net.MalformedURLException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, RemoteException {
        //System.setProperty("java.security.policy", "security.policy");
        //System.setSecurityManager(new RMISecurityManager());
        //we initialize a remote server object
        RemoteMessageServer remoteMessageServer = new RemoteMessageServer();
    }
}
