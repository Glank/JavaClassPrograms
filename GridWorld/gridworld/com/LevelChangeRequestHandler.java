package gridworld.com;
import gridworld.gui.GameConsole;
import gridworld.levels.LevelRegistry;

public class LevelChangeRequestHandler extends ControllerRequestHandler{
    public LevelChangeRequestHandler(){
        super("set_level");
    }
    public ControllerResponse handle(ControllerRequest request){
        GameConsole console = getConsole();
        String level = (String)request.args[0];
        LevelRegistry registry = console.getLevelRegistry();
        if(!registry.hasLevel(level))
            return new ControllerResponse("invalid");
        registry.loadLevel(level);
        return new ControllerResponse();
    }
}
