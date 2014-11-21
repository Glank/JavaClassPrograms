package gridworld;
import gridworld.com.ControllerClient;
import gridworld.com.ControllerResponse;
import gridworld.com.ControllerRequest;
import java.io.IOException;

public class SimpleController{
    private ControllerClient client;
    public SimpleController(){
        try{
            client = new ControllerClient();
        }catch(IOException ex){
            System.err.println(
                "Error: Could not connect controller. "+
                "Is GridWorld started?"
            );
            throw new RuntimeException();
        }
    }
    public void setLevel(String levelName){
        try{
            ControllerResponse response = client.sendRequest(
                new ControllerRequest("set_level", levelName));
            if(response.errorMessage!=null){
                System.err.println("The level \""+levelName+
                    "\" does not exist. Did you spell it wrong?");
                throw new RuntimeException();
            }
        }catch(IOException ex){
            System.err.println(
                "Error: Controller disconnected. "+
                "Did you close GridWorld?"
            );
            throw new RuntimeException();
        }
    }
    private boolean move(int dx, int dy){
        try{
            ControllerResponse response = client.sendRequest(new ControllerRequest("move",dx,dy));
            if(response.errorMessage!=null)
                return false;
        }catch(IOException ex){
            System.err.println(
                "Error: Controller disconnected. "+
                "Did you close GridWorld?"
            );
            throw new RuntimeException();
        }
        return true;
    }
    public void waitForPlayer(){
        try{
            ControllerResponse response = client.sendRequest(
                new ControllerRequest("spawn"));
            if(response.errorMessage!=null){
                System.err.println(
                    "The player never spawned. "+
                    "Did you select a level?"
                );
                throw new RuntimeException();
            }
        }catch(IOException ex){
            System.err.println(
                "Error: Controller disconnected. "+
                "Did you close GridWorld?"
            );
            throw new RuntimeException();
        }
    }
    public boolean moveUp(){
        return move(0,-1);
    }
    public boolean moveDown(){
        return move(0,1);
    }
    public boolean moveLeft(){
        return move(-1,0);
    }
    public boolean moveRight(){
        return move(1,0);
    }
}
