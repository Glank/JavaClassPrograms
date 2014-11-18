package gridworld;
import java.awt.Graphics;
import java.awt.Color;

public class Player extends GridObject{
    public Player(int x, int y){
        super(x,y);
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(0,0,Grid.GRID_SQUARE_WIDTH-1,Grid.GRID_SQUARE_HEIGHT-1);
    }
}
