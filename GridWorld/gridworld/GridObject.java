package gridworld;
import java.awt.Graphics;

public abstract class GridObject{
    private int x, y;
    private boolean solid = true;    
    private Grid grid;

    public GridObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveTo(int new_x, int new_y){
        //the grid controls the location of objects, as it may
        //eventually have an internal mechanism which keeps
        //track of objects based on their location for faster
        //referencing.
        grid.moveObjectTo(this, new_x, new_y);
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    /**
    * These methods are only to be called by Grid.
    */
    private void  __assertGridCalling(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        assert(stackTraceElements[3].getClassName().equals("gridworld.Grid"));
    }
    void __setLoc(int x, int y){
        __assertGridCalling();
        this.x = x;
        this.y = y;
    }
    void __setGrid(Grid grid){
        __assertGridCalling();
        this.grid = grid;
    }


    /**
    * Draw this object with it's top left corner at 0,0
    */
    protected abstract void draw(Graphics g);

    /**
    * Move or do whatever.
    */
    public void update(){}
}
