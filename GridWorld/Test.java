import gridworld.*;
import java.awt.Graphics;

public class Test{
    public static void main(String[] args){
        GridObject testObj = new GridObject(0,0){
            protected void draw(Graphics g){}
        };
        Grid grid = new Grid(5,5);
        grid.addObject(testObj);
        testObj.moveTo(1,3);
    }
}
