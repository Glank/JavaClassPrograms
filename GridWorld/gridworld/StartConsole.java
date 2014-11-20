package gridworld;
import gridworld.gui.GameConsole;
import javax.swing.JFrame;
public class StartConsole{
    public static void main(String[] args){
        GameConsole console = new GameConsole();
        console.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        console.setVisible(true);
    }
}
