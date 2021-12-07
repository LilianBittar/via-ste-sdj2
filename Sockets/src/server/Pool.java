package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pool {
    private List<ServerSocketHandler> connections;
    public Pool(){
        connections = new ArrayList<ServerSocketHandler>();
    }
    public synchronized void broadcast(String msg) throws IOException {
      for (int i = 0; i < connections.size(); i++){
          connections.get(i).sendMessage(msg);
      }
    }
    public synchronized void addConn(ServerSocketHandler ssh){
        connections.add(ssh);
    }
    public synchronized void removeConn(ServerSocketHandler ssh){
        connections.remove(ssh);
    }
}
