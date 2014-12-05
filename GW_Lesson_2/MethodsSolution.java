import gridworld.gui.GameConsole;
import gridworld.SimpleController;

public class MethodsSolution{
  public static SimpleController controller;
  public static void main(String[] args){
    //start the game console
    GameConsole console = new GameConsole();
    console.setVisible(true);
    
    //'pick up' a controller
    controller = new SimpleController();
    
    //start the level "methods"
    //you should also try "methods2" and "badguys"
    controller.setLevel("methods");
    
    //wait for the player to spawn
    controller.waitForPlayer();
    
    //do stuff
    for(int i = 0; i < 3; i++){
      moveAround();
      controller.moveRight();
    }
    moveAround();
  }
  
  public static void moveAround(){
    controller.moveUp();
    controller.moveLeft();
    controller.moveDown();
    controller.moveRight();
  }
}