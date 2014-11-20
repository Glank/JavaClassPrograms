package gridworld.com;
import gridworld.Player;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;

public abstract class ControllerRequestHandler{
    private String action;
    private GameConsole console;
    public ControllerRequestHandler(String action){
        this.action = action;
    }
    public String getAction(){
        return action;
    }
    public Player getPlayer(){
        Grid grid = getWorld().getGrid();
        return (Player)grid.getObjectByClass(Player.class);
    }
    public GridWorld getWorld(){
        return console.getWorld();
    }
    public void setConsole(GameConsole console){
        this.console = console;
    }
    public GameConsole getConsole(){
        return console;
    }
    public abstract ControllerResponse handle(
        ControllerRequest request);
}
