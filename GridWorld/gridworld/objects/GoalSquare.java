package gridworld.objects;
import gridworld.Grid;
import gridworld.GridObject;
import java.awt.Graphics;
import java.awt.Color;

public class GoalSquare extends GridObject{
    public GoalSquare(int x, int y){
        super(x,y,false);
    }
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0,0,Grid.GRID_SQUARE_WIDTH,Grid.GRID_SQUARE_HEIGHT);
    }
}
