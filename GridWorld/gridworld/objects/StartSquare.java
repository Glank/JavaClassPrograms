package gridworld.objects;
import gridworld.Grid;
import gridworld.GridObject;
import java.awt.Graphics;
import java.awt.Color;

public class StartSquare extends GridObject{
    public StartSquare(int x, int y){
        super(x,y,false);
    }
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.drawOval(
            2,2,
            Grid.GRID_SQUARE_WIDTH-5,Grid.GRID_SQUARE_HEIGHT-5
        );
    }
    public void update(){
        Grid grid = getGrid();
        if(grid.getObjectByClass(Player.class)==null){
            grid.addObject(new Player(getX(), getY()));
        }
    }
}
