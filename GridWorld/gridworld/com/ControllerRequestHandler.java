package gridworld.com;
import gridworld.Player;
import gridworld.GridWorld;

public abstract class ControllerRequestHandler{
    private String action;
    private Player player;
    private GridWorld world;
    public ControllerRequestHandler(String action){
        this.action = action;
    }
    public String getAction(){
        return action;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return player;
    }
    public void setWorld(GridWorld world){
        this.world = world;
    }
    public GridWorld getWorld(){
        return world;
    }
    public abstract ControllerResponse handle(ControllerRequest request);
}
