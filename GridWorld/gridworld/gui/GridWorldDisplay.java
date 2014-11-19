package gridworld.gui;
import gridworld.GridWorld;
import gridworld.Grid;

public class GridWorldDisplay extends GridDisplay{
    private GridWorld world;
    public GridWorldDisplay(GridWorld world){
        super(world.getGrid());
        this.world = world;
        //start repaint thread
        RepaintThread thread = new RepaintThread();
        thread.world = world;
        thread.component = this;
        thread.setDaemon(true);
        thread.start();
    }

    private static class RepaintThread extends Thread{
        GridWorld world;
        GridWorldDisplay component;
        public void run(){
            while(!world.isStopped()){
                synchronized(world){
                    try{world.wait();}
                    catch(InterruptedException ex){}
                }
                component.render();
                component.repaint();
            }
        }
    }
}
