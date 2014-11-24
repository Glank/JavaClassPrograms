package gridworld;
import gridworld.gui.GameConsole;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import gridworld.objects.Wall;
import gridworld.objects.StartSquare;
import gridworld.objects.GoalSquare;
import gridworld.objects.Killer;

public abstract class Level{
    public static final int BLACK_ARGB = 0xFF000000;
    public static final int BLUE_ARGB = 0xFF0000FF;
    public static final int GREEN_ARGB = 0xFF00FF00;
    public static final int RED_ARGB = 0xFFFF0000;

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
    public void loadStaticData(Grid grid, String pathToStaticResource){
        try{
            BufferedImage data = ImageIO.read(
                Level.class.getResourceAsStream(pathToStaticResource)
            );
            int argb;
            for(int x = 0; x < data.getWidth(); x++){
                for(int y = 0; y < data.getHeight(); y++){
                    argb = data.getRGB(x,y);
                    if(argb==BLACK_ARGB)
                        grid.addObject(new Wall(x,y));
                    else if(argb==BLUE_ARGB)
                        grid.addObject(new StartSquare(x,y));
                    else if(argb==GREEN_ARGB)
                        grid.addObject(new GoalSquare(x,y));
                    else if(argb==RED_ARGB)
                        grid.addObject(new Killer(x,y));
                }
            }
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
