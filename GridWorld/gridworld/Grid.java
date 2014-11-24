package gridworld;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Vector;
import java.util.LinkedList;
import java.util.List;

public class Grid{
    public static final int GRID_SQUARE_WIDTH = 20;
    public static final int GRID_SQUARE_HEIGHT = 20;
    public static final int DEFAULT_WIDTH = 30;
    public static final int DEFAULT_HEIGHT = 20;
    private int width, height;
    private Vector<GridObject> objects = new Vector<GridObject>();
    private List[][] objectsByLoc; //Object type of List<GridObject>

    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        objectsByLoc = new List[width][height];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                objectsByLoc[x][y] = new LinkedList<GridObject>();
            }
        }
    }
    public Grid(){
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public synchronized void addObject(GridObject obj){
        if(obj.isSolid())
            objects.add(obj);
        else
            objects.add(0, obj);
        objectsByLoc[obj.getX()][obj.getY()].add(obj);
        obj.__setGrid(this);
    }
    public synchronized void removeObject(GridObject obj){
        objects.remove(obj);
        ((List<GridObject>)objectsByLoc[obj.getX()][obj.getY()]).remove(obj);
        obj.__setGrid(null);
    }
    public synchronized GridObject getObjectByClass(Class clazz){
        for(GridObject obj:objects)
            if(clazz.isInstance(obj))
                return obj;
        return null;
    }
    public synchronized Vector<GridObject> getObjectsByClass(
        Class clazz){
        Vector<GridObject> matches = new Vector<GridObject>();
        for(GridObject obj:objects)
            if(clazz.isInstance(obj))
                matches.add(obj);
        return matches;
    }

    public synchronized void updateAllObjects(){
        //need to make a copy before updating because
        //updates may add or remove objects
        GridObject[] curObjects = new GridObject[objects.size()];
        objects.toArray(curObjects);
        for(GridObject obj:curObjects){
            //if the object hasn't been removed
            if(obj.getGrid()==this)
                obj.update();
        }
    }

    public synchronized void changeSolidState(
        GridObject obj, boolean solid){
        if(obj.isSolid()==solid)
            return;
        removeObject(obj);
        obj.__setSolid(solid);
        addObject(obj);
    }

    public synchronized void moveObjectTo(
        GridObject obj, int new_x, int new_y){
        ((List<GridObject>)objectsByLoc[obj.getX()][obj.getY()]).remove(obj);
        obj.__setLoc(new_x, new_y);
        ((List<GridObject>)objectsByLoc[obj.getX()][obj.getY()]).add(obj);
    }

    public synchronized Vector<GridObject> getObjectsAt(int x, int y){
        Vector<GridObject> objectsAt = new Vector<GridObject>();
        objectsAt.addAll((List<GridObject>)objectsByLoc[x][y]);
        return objectsAt;
    }

    public synchronized boolean containsSquare(int x, int y){
        return 0<=x && x<getWidth() && 0<=y && y<getHeight();
    }

    public synchronized boolean isFreeSquare(int x, int y){
        if(!containsSquare(x,y))
            return false;
        for(GridObject object:getObjectsAt(x,y)){
            if(object.isSolid())
                return false;
        }
        return true;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public BufferedImage generateCanvas(){
        BufferedImage img = new BufferedImage(
            getWidth()*GRID_SQUARE_WIDTH,
            getHeight()*GRID_SQUARE_HEIGHT,
            BufferedImage.TYPE_INT_RGB
        );
        return img;
    }

    public synchronized void draw(Graphics g){
        //draw checkerboard background
        g.setColor(Color.WHITE);
        g.fillRect(
            0, 0, 
            getWidth()*GRID_SQUARE_WIDTH,
            getHeight()*GRID_SQUARE_HEIGHT
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
