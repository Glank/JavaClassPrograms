package gridworld.levels;
import gridworld.Level;
import gridworld.gui.GameConsole;
import java.util.HashMap;

public class LevelRegistry{
    private HashMap<String,Level> levels = new HashMap<String,Level>();
    public LevelRegistry(GameConsole console){
        addLevel(new ExampleLevel(console));
        addLevel(new ZigZag(console));
        addLevel(new Steps(console));
        addLevel(new Spiral(console));
        addLevel(new Methods(console));
        addLevel(new Methods2(console));
        addLevel(new BadGuys(console));
    }
    private void addLevel(Level level){
        String name = level.getName().toUpperCase();
        if(levels.containsKey(name))
            throw new RuntimeException(
                "Multiple levels for name: "+name);
        levels.put(name, level);
    }
    public boolean hasLevel(String name){
        return levels.containsKey(name.toUpperCase());
    }
    public void loadLevel(String name){
        levels.get(name.toUpperCase()).setup();
    }
}
