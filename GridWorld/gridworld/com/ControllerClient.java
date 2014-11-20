package gridworld.com;
import gridworld.Configs;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ControllerClient{
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    public ControllerClient() throws IOException{
        String portString = Configs.getKWConfig("controller_port");
        int port = Integer.parseInt(portString);
        socket = new Socket("localhost", port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public ControllerResponse sendRequest(ControllerRequest request) throws IOException{
        try{
            out.writeObject(request);
            return (ControllerResponse)in.readObject();
        }catch(ClassNotFoundException ex){
            throw new RuntimeException("Invalid response object: "+ex);
        }
    }
}
