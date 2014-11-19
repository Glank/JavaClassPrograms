package gridworld;
import java.awt.Graphics;

public abstract class GridObject{
    private int x, y;
    private boolean solid;    
    private Grid grid;

    public GridObject(int x, int y){
        this(x,y,true);
    }

    public GridObject(int x, int y, boolean solid){
        this.x = x;
        this.y = y;
        this.solid = solid;
    }

    public boolean isSolid(){
        return solid;
    }

    public void moveTo(int newX, int newY){
        //the grid controls the location of objects, as it may
        //eventually have an internal mechanism which keeps
        //track of objects based on their location for faster
        //referencing.
        if(grid!=null)
            grid.moveObjectTo(this, newX, newY);
        else{
            this.x = newX;
            this.y = newY;
        }
    }

    public boolean move(int dx, int dy){
        if(grid==null)
            return false;
        int newX = x+dx;
        int newY = y+dy;
        if(isSolid()){
            if(grid.isFreeSquare(newX, newY))
                moveTo(newX, newY);
            else
                return false;
        }
        else{
            if(grid.containsSquare(newX, newY))
                moveTo(newX, newY);
            else
                return false;
        }
        return true;
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
        StackTraceElement[] stackTraceElements = 
            Thread.currentThread().getStackTrace();
        assert(stackTraceElements[3].getClassName().equals(
            "gridworld.Grid"
        ));
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
}
