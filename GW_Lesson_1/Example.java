import gridworld.SimpleController;

public class Example{
    public static void main(String[] args) throws Throwable{
        SimpleController controller = new SimpleController();
        controller.setLevel("example level");
        controller.waitForPlayer();
        for(int i = 0; i < 3; i++)
            controller.moveRight();
        for(int i = 0; i < 2; i++)
            controller.moveUp();
    }
}