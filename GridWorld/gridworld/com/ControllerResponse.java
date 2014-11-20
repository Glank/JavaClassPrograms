package gridworld.com;
import java.io.Serializable;

public class ControllerResponse implements Serializable{
    public String errorMessage = null;
    public ControllerResponse(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public ControllerResponse(){
        this(null);
    }
}
