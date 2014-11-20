package gridworld.com;
import gridworld.GridWorld;

public class SpawnRequestHandler extends ControllerRequestHandler{
    public static final int TIMEOUT = 10;
    public SpawnRequestHandler(){
        super("spawn");
    }
    public ControllerResponse handle(ControllerRequest request){
        GridWorld world = getWorld();
        int turns = 0;
        synchronized(world){
            try{
                for(turns = 0; turns<TIMEOUT && getPlayer()==null; turns++)
                    world.wait();
            }catch(InterruptedException ex){}
        }
        if(turns==TIMEOUT)
            return new ControllerResponse("timeout");
        return new ControllerResponse();
    }
}
