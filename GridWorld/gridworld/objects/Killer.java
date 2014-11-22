package gridworld.objects;
import gridworld.Grid;
import gridworld.GridObject;
import java.awt.Graphics;
import java.awt.Color;

public class Killer extends GridObject{
    private KillerAI ai;
    public Killer(int x, int y){
        super(x,y,false); // not solid, so the player can run into them
    }

    public void setAI(KillerAI ai){
        this.ai = ai;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(0,0,Grid.GRID_SQUARE_WIDTH-1,Grid.GRID_SQUARE_HEIGHT-1);
    }

    public void update(){
        if(ai!=null)
            ai.update(this);
    }
}
