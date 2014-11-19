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
        int port = Integer.parseInt(Configs.getKWConfig("controller_port"));
        try{
            System.out.println("Connecting controller...");
            socket = new Socket("localhost", port);
            System.out.println("Controller connected...");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }catch(IOException ex){
            throw new RuntimeException("Error connecting controller: "+ex);
        }
    }

    public ControllerResponse sendRequest(ControllerRequest request){
        try{
            System.out.println("Sending request...");
            out.writeObject(request);
            System.out.println("Awaiting response...");
            return (ControllerResponse)in.readObject();
        }catch(Exception ex){
            throw new RuntimeException("Error sending request: "+ex);
        }
    }
}
