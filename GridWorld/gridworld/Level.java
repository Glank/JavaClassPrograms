package gridworld;
import gridworld.gui.GameConsole;

public abstract class Level{
    private String name;
    private GameConsole console;
    public Level(String name, GameConsole console){
        this.name = name;
        this.console = console;
    }
    public String getName(){
        return name;
    }
    public GameConsole getConsole(){
        return console;
    }
    public GridWorld getWorld(){
        return getConsole().getWorld();
    }
    public abstract void setup();
}
