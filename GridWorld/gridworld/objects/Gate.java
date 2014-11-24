package gridworld.objects;
import gridworld.Grid;
import gridworld.GridObject;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Gate extends GridObject{
    private boolean horizontal;
    public Gate(int x, int y, boolean horizontal, boolean open){
        super(x,y,!open);
        this.horizontal = horizontal;
    }
    public void open(){
        setSolid(false);
    }
    public void close(){
        setSolid(true);
    }
    public boolean isOpen(){
        return !isSolid();
    }
    public void draw(Graphics g){
        int x,y,w,h;
        if(horizontal){
            x = 2;
            y = 8;
        }
        else{
            x = 8;
            y = 2;
        }
        w = Grid.GRID_SQUARE_WIDTH-(2*x);
        h = Grid.GRID_SQUARE_HEIGHT-(2*y);
        g.setColor(Color.BLACK);
        if(isOpen())
            g.drawRect(x,y,w,h);
        else
            g.fillRect(x,y,w,h);
    }
    public void bindTo(GridButton button){
        button.addListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                open();
            }
        });
    }
}
