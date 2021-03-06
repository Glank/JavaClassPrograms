package gridworld.com;
import gridworld.gui.GameConsole;
import gridworld.Configs;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ControllerServer extends Thread{
    private GameConsole console;
    private ServerSocket serverSocket;
    private HashMap<String,ControllerRequestHandler> handlers;
    private boolean closed = false;

    public ControllerServer(GameConsole console){
        this.console = console;
        String portString = Configs.getKWConfig("controller_port");
        int port = Integer.parseInt(portString);
        try{
            this.serverSocket = new ServerSocket(port);
        }
        catch(IOException ex){
            throw new RuntimeException(
                "Unable to bind port "+port+": "+ex);
        }
        setDaemon(true);
        handlers = new HashMap<String,ControllerRequestHandler>();
    }

    public void close(){
        this.closed = true;
    }

    public boolean isClosed(){
        return closed;
    }

    public void addHandler(ControllerRequestHandler handler){
        synchronized(handlers){
            String action = handler.getAction();
            if(handlers.containsKey(handler))
                throw new RuntimeException(
                    "Multiple handlers for action: "+action);
            handler.setConsole(console);
            handlers.put(action, handler);
        }
    }

    public ControllerRequestHandler getHandler(String action){
        synchronized(handlers){
            return handlers.get(action);
        }
    }

    public void run(){
        try{
            while(!closed){
                Socket sock = serverSocket.accept();
                ControllerConnection connection = 
                    new ControllerConnection(sock, this);
                connection.start();
            }
        }
        catch(IOException ex){
            throw new RuntimeException(
                "Problem with Controller Server: "+ex);
        }
        finally{
            try{
                serverSocket.close();
            }catch(Throwable t){}
        }
    }

    private static class ControllerConnection extends Thread{
        private ControllerServer server;
        private Socket socket;
        private ObjectInputStream in;
        private ObjectOutputStream out;
        public ControllerConnection(Socket socket, ControllerServer server){
            this.socket = socket;
            this.server = server;
            setDaemon(true);
            try{
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
            }catch(Throwable t){
                this.socket = null;
                t.printStackTrace();
            }
        }
        public void run(){
            try{
                while(!server.isClosed()){
                    ControllerRequest request = (ControllerRequest)in.readObject();
                    ControllerRequestHandler handler = server.getHandler(request.action);
                    ControllerResponse response = handler.handle(request);
                    out.writeObject(response);
                }
            }catch(Throwable t){
                t.printStackTrace();
            }finally{
                try{
                    socket.close();
                }catch(Throwable t){}
            }
        }
    }
}
