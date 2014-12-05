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
    //You should also try "steps", "zigzag", "spiral", and "badguys"
    controller.setLevel("example level");
    
    //wait for the player to spawn
    controller.waitForPlayer();
    
    //move right 3 spaces then up 2 spaces
    for(int i = 0; i < 3; i++)
      controller.moveRight();
    
    //move left once
    controller.moveLeft();
    
    //twice: move up then move right
    for(int i = 0; i < 2; i++){
      controller.moveUp();
      controller.moveRight();
    }
    
  }
}