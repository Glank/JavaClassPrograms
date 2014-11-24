package gridworld.objects;
import gridworld.Grid;
import gridworld.GridObject;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.LinkedList;

public class GridButton extends GridObject{
    private boolean pressed = false;
    private LinkedList<ChangeListener> listeners = new LinkedList<ChangeListener>();
    public GridButton(int x, int y){
        super(x,y,false);
    }
    public void addListener(ChangeListener listener){
        synchronized(listeners){
            this.listeners.add(listener);
        }
    }
    public void removeListener(ChangeListener listener){
        synchronized(listeners){
            this.listeners.remove(listener);
        }
    }
    public void draw(Graphics g){
        if(!pressed){
            g.setColor(Color.BLACK);
            g.fillOval(5,5,Grid.GRID_SQUARE_WIDTH-11,Grid.GRID_SQUARE_HEIGHT-11);
            g.setColor(Color.DARK_GRAY);
            g.fillOval(4,4,Grid.GRID_SQUARE_WIDTH-11,Grid.GRID_SQUARE_HEIGHT-11);
        }
        else{
            g.setColor(Color.DARK_GRAY);
            g.fillOval(5,5,Grid.GRID_SQUARE_WIDTH-11,Grid.GRID_SQUARE_HEIGHT-11);
        }
    }
    public boolean isPressed(){
        return pressed;
    }
    public void update(){
        Grid grid = getGrid();
        if(grid==null)
            return;
        boolean playerOn = false;
        for(GridObject obj: grid.getObjectsAt(getX(), getY())){
            if(obj instanceof Player)
                playerOn = true;
        }
        if(playerOn && !pressed){
            pressed = true;
            ChangeEvent event = new ChangeEvent(this);
            synchronized(listeners){
                for(ChangeListener listener:listeners)
                    listener.stateChanged(event);
            }
        }
    }
}
