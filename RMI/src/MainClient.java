import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        RemoteMessageClient remoteMessageClient = new RemoteMessageClient();
    }

}
