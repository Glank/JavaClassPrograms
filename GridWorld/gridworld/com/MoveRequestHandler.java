package gridworld.com;
import gridworld.Player;
import gridworld.actions.MovePlayer;

public class MoveRequestHandler extends ControllerRequestHandler{
    public MoveRequestHandler(){
        super("move");
    }
    public ControllerResponse handle(ControllerRequest request){
        Player player = getPlayer();
        if(player==null)
            return new ControllerResponse();
        int dx = (Integer)request.args[0];
        int dy = (Integer)request.args[1];
        //move
        MovePlayer action = new MovePlayer(player,dx,dy);
        getWorld().doAction(action);
        //wait for move to be done
        synchronized(action){
            try{
                while(!action.isFinished())
                    action.wait();
            }catch(InterruptedException ex){}
        }
        return new ControllerResponse();
    }
}
