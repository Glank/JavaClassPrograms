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
    public ControllerClient(){
        String portString = Configs.getKWConfig("controller_port");
        int port = Integer.parseInt(portString);
        try{
            socket = new Socket("localhost", port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }catch(IOException ex){
            throw new RuntimeException(
                "Error connecting controller: "+ex);
        }
    }

    public ControllerResponse sendRequest(ControllerRequest request){
        try{
            out.writeObject(request);
            return (ControllerResponse)in.readObject();
        }catch(Exception ex){
            throw new RuntimeException("Error sending request: "+ex);
        }
    }
}
