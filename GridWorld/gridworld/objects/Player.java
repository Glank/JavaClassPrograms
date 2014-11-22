package gridworld.objects;
import gridworld.Grid;
import gridworld.GridObject;
import java.awt.Graphics;
import java.awt.Color;

public class Player extends GridObject{
    private boolean reachedGoal = false;
    public Player(int x, int y){
        super(x,y);
    }
    public void moveTo(int x, int y){
        if(!reachedGoal)
            super.moveTo(x,y);
    }
    public void reachGoal(){
        reachedGoal = true;
    }
    public boolean hasReachedGoal(){
        return reachedGoal;
    }
    public void draw(Graphics g){
        if(reachedGoal)
            g.setColor(Color.MAGENTA);
        else
            g.setColor(Color.BLUE);
        g.fillOval(1,1,Grid.GRID_SQUARE_WIDTH-3,Grid.GRID_SQUARE_HEIGHT-3);
    }
}
