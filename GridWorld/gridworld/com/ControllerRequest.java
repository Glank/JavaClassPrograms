package gridworld.com;
import java.io.Serializable;

public class ControllerRequest implements Serializable{
    private static final long serialVersionUID = -32738789012845L;
    public String action;
    public Serializable[] args;

    public ControllerRequest(String action, Serializable... args){
        this.action = action;
        this.args = args;
    }
}
