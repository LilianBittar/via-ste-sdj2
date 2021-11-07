import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {
    public static void main(String[] args) throws MalformedURLException, RemoteException {

        // Startup the registry so we can upload the server to the registry.
        LocateRegistry.createRegistry(1099);
        System.out.println("Registry started...");

        RemoteMessageServer remoteMessageServer = new RemoteMessageServer();
    }
}
