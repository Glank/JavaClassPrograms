package gridworld.updates;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.GridUpdate;
import gridworld.gui.GameConsole;
import gridworld.objects.Player;
import gridworld.objects.GoalSquare;

public class ReachedGoalUpdate implements GridUpdate{
    private GameConsole console;
    private GoalSquare goal;
    public ReachedGoalUpdate(GameConsole console, GoalSquare goal){
        this.console = console;
        this.goal = goal;
    }
    public void update(Grid grid){
        Player player = (Player)grid.getObjectByClass(Player.class);
        if(player==null)
            return;
        else if(player.hasReachedGoal())
            return;
        if(player.getX()==goal.getX() && player.getY()==goal.getY()){
            player.reachGoal();
            console.alert("Congratulations, you won!");
        }
        //remove remaining actions, we's done
        console.getWorld().clearActions();
    }
}
