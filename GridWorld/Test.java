import gridworld.*;
import gridworld.gui.*;
import gridworld.com.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;
import java.util.Random;

public class Test{
    public static void main(String[] args) throws Throwable{
        System.out.println(Configs.getKWConfig("controller_port"));
        Grid grid = new Grid(10,10);
        grid.addObject(new Wall(1,0));
        grid.addObject(new Wall(1,1));
        grid.addObject(new Wall(1,2));
        final Player player = new Player(2,2);
        final GoalSquare goal = new GoalSquare(8,8);
        grid.addObject(player);
        grid.addObject(goal);

        GridWorld world = new GridWorld(grid);

        JFrame frame = new JFrame();
        frame.add(new GridWorldDisplay(world));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        ControllerServer server = new ControllerServer(player, world);
        server.addHandler(new ControllerRequestHandler("move"){
            public ControllerResponse handle(ControllerRequest request){
                int dx = (Integer)request.args[0];
                int dy = (Integer)request.args[1];
                TurnAction action = new TurnAction(player){
                    public void performTurn(){
                        GridObject obj = getObject();
                        obj.move(1, 1);
                    }
                };
                getWorld().doAction(action);
                synchronized(action){
                    try{
                        while(!action.isFinished())
                            action.wait();
                    }catch(InterruptedException ex){}
                }
                return new ControllerResponse();
            }
        });
        server.start();
        
        System.out.println("Server started.");
        ControllerClient client = new ControllerClient();
        System.out.println("Client connected.");
        Thread.sleep(500);
        for(int i = 0; i < 6; i++){
            client.sendRequest(new ControllerRequest("move",1,1));
        }

        /*
        final Random rand = new Random();
        for(int i = 0; i < 25; i++){
            world.doAction(new TurnAction(player){
                public void performTurn(){
                    GridObject obj = getObject();
                    obj.move(1, 1);
                }
            });
        }

        world.addUpdate(new GridUpdate(){
            public void update(Grid grid){
                if(player.getX()==goal.getX() && player.getY()==goal.getY())
                    grid.removeObject(player);
            }
        });
        */
    }
}
