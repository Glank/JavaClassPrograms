package gridworld.levels;
import gridworld.Level;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;
import gridworld.objects.GoalSquare;
import gridworld.objects.Killer;
import gridworld.objects.ai.MoveLoopAI;
import gridworld.objects.GridButton;
import gridworld.objects.Gate;
import gridworld.updates.ReachedGoalUpdate;
import gridworld.updates.PlayerKilled;

public class BadGuys extends Level{

    public BadGuys(GameConsole console){
        super("BadGuys", console);
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
        loadStaticData(grid, "/gridworld/levels/data/badguys");
        GoalSquare goal = (GoalSquare)grid.getObjectByClass(GoalSquare.class);
        //load dynamic data
        Killer killer;
        int[][] killer_moves;
        //cycle killer
        killer = new Killer(11,4);
        killer_moves = new int[][]{
            {-1,0},{-1,0},{-1,0},{0,1},{0,1},{0,1},
            {1,0},{1,0},{1,0},{0,-1},{0,-1},{0,-1}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        //left-right killers
        killer = new Killer(14,6);
        killer_moves = new int[][]{
            {1,0},{1,0},{1,0},{1,0},{-1,0},{-1,0},{-1,0},{-1,0}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        killer = new Killer(16,9);
        killer_moves = new int[][]{
            {1,0},{1,0},{-1,0},{-1,0},{-1,0},{-1,0},{1,0},{1,0}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        killer = new Killer(18,12);
        killer_moves = new int[][]{
            {-1,0},{-1,0},{-1,0},{-1,0},{1,0},{1,0},{1,0},{1,0}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        //add a grid button and gate
        GridButton button = new GridButton(9,11);
        Gate gate = new Gate(21,5,false,false);
        gate.bindTo(button);
        grid.addObject(button);
        grid.addObject(gate);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
        world.addUpdate(new PlayerKilled(console));
    }
}
