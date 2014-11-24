package gridworld.com;
import gridworld.GridWorld;

public class WaitRequestHandler extends ControllerRequestHandler{
    public WaitRequestHandler(){
        super("wait");
    }
    public ControllerResponse handle(ControllerRequest request){
        int count = (Integer)request.args[0];
        if(count>100)
            return new ControllerResponse("max exceeded");
        GridWorld world = getWorld();
        //wait for count
        synchronized(world){
            try{
                while(count>0){
                    world.wait();
                    count--;
                }
            }catch(InterruptedException ex){}
        }
        return new ControllerResponse();
    }
}
