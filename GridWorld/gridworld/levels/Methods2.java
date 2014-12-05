package gridworld.levels;
import gridworld.Level;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;
import gridworld.objects.GoalSquare;
import gridworld.objects.GridButton;
import gridworld.objects.Gate;
import gridworld.updates.ReachedGoalUpdate;
import gridworld.updates.PlayerKilled;

public class Methods2 extends Level{

    public Methods2(GameConsole console){
        super("Methods2", console);
    }

    public static void addButtonAndGate(Grid grid, int buttonX, int buttonY,
        int gateX, int gateY){
        GridButton button  = new GridButton(buttonX, buttonY);
        Gate gate = new Gate(gateX, gateY, false,false);
        gate.bindTo(button);
        grid.addObject(button);
        grid.addObject(gate);
    }

    public void setup(){
        GameConsole console = getConsole();
        GridWorld world = getWorld();
        //reset the world
        world.clearActions();
        world.clearUpdates();
        //create the initial grid state
        Grid grid = new Grid();
        //add static data
        loadStaticData(grid, "/gridworld/levels/data/methods2");
        GoalSquare goal = (GoalSquare)grid.getObjectByClass(GoalSquare.class);
        //load dynamic data
        //add a grid buttons and gates
        addButtonAndGate(grid,6,7,24,6);
        addButtonAndGate(grid,22,5,10,17);
        addButtonAndGate(grid,8,16,22,16);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
        world.addUpdate(new PlayerKilled(console));
    }
}
