package gridworld.updates;
import gridworld.Grid;
import gridworld.GridObject;
import gridworld.GridWorld;
import gridworld.GridUpdate;
import gridworld.gui.GameConsole;
import gridworld.objects.Player;
import gridworld.objects.Killer;

public class PlayerKilled implements GridUpdate{
    private GameConsole console;
    public PlayerKilled(GameConsole console){
        this.console = console;
    }
    public void update(Grid grid){
        Player player = (Player)grid.getObjectByClass(Player.class);
        if(player==null)
            return;
        else if(player.hasReachedGoal())
            return;
        boolean killed = false;
        for(GridObject obj: grid.getObjectsAt(player.getX(), player.getY())){
            //if player overlaps a killer
            if(obj instanceof Killer)
                killed = true;
        }
        if(killed)
            grid.removeObject(player);
    }
}
