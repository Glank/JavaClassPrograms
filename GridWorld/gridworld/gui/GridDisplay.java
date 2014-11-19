package gridworld.gui;
import gridworld.Grid;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JComponent;

public class GridDisplay extends JComponent{
    private Grid grid;
    private BufferedImage displayCanvas, workCanvas;

    public GridDisplay(Grid grid){
        setGrid(grid);
    }

    public void setGrid(Grid grid){
        this.grid = grid;
        //create display and work-buffer images
        displayCanvas = grid.generateCanvas();
        workCanvas = grid.generateCanvas();
        //set size
        Dimension size = new Dimension(
            displayCanvas.getWidth(),
            displayCanvas.getHeight()
        );
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        //initial render
        render();
    }

    public void render(){
        //draw
        grid.draw(workCanvas.getGraphics());
        //swap work canvas for display canvas
        BufferedImage tmp = displayCanvas;
        displayCanvas = workCanvas;
        workCanvas = tmp;
    }

    public void paint(Graphics g){
        g.drawImage(displayCanvas, 0, 0, null);
    }
}
