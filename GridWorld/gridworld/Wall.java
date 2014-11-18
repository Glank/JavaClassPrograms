package gridworld;
import java.awt.Graphics;
import java.awt.Color;

public class Wall extends GridObject{
    public Wall(int x, int y){
        super(x,y);
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Grid.GRID_SQUARE_WIDTH,Grid.GRID_SQUARE_HEIGHT);
    }
}
