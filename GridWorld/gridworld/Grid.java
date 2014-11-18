package gridworld;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Vector;

public class Grid{
    public static final int GRID_SQUARE_WIDTH = 20;
    public static final int GRID_SQUARE_HEIGHT = 20;
    private int width, height;
    private Vector<GridObject> objects = new Vector<GridObject>();

    public Grid(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void addObject(GridObject obj){
        objects.add(obj);
        obj.__setGrid(this);
    }

    public void moveObjectTo(GridObject obj, int new_x, int new_y){
        obj.__setLoc(new_x, new_y);
    }

    public Vector<GridObject> getObjectsAt(int x, int y){
        Vector<GridObject> objectsAt = new Vector<GridObject>();
        for(GridObject obj:objects){
            if(obj.getX()==x && obj.getY()==y)
                objectsAt.add(obj);
        }
        return objectsAt;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void draw(Graphics g){
        //draw checkerboard background
        g.setColor(Color.WHITE);
        g.fillRect(
            0, 0, getWidth()*GRID_SQUARE_WIDTH, getHeight()*GRID_SQUARE_HEIGHT
        );
        g.setColor(Color.LIGHT_GRAY);
        for(int x = 0; x < getWidth(); x++){
            for(int y = 0; y < getHeight(); y++){
                if((x+y)%2==1){
                    g.fillRect(
                        x*GRID_SQUARE_WIDTH, y*GRID_SQUARE_HEIGHT,
                        GRID_SQUARE_WIDTH, GRID_SQUARE_HEIGHT
                    );
                }
            }
        }
        //draw objects
        for(GridObject obj:objects){
            int x = GRID_SQUARE_WIDTH*obj.getX();
            int y = GRID_SQUARE_HEIGHT*obj.getY();
            g.translate(x,y); //translate
            obj.draw(g);
            g.translate(-x,-y); //untranslate
        }
    }
}
