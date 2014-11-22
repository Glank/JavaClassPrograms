import gridworld.gui.GameConsole;
import gridworld.SimpleController;

public class Example{
  public static void main(String[] args){
    //start the game console
    GameConsole console = new GameConsole();
    console.setVisible(true);
    
    //'pick up' a controller
    SimpleController controller = new SimpleController();
    
    //start the level "example level"
    controller.setLevel("example level");
    
    //wait for the player to spawn
    controller.waitForPlayer();
    
    //move right 3 spaces then up 2 spaces
    for(int i = 0; i < 3; i++)
      controller.moveRight();
    for(int i = 0; i < 2; i++)
      controller.moveUp();
  }
}