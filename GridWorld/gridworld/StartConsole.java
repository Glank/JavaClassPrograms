package gridworld;
import gridworld.gui.GameConsole;
import javax.swing.JFrame;
public class StartConsole{
    public static void main(String[] args){
        boolean locked = args.length>=1 && args[0].equals("locked");
        GameConsole console = new GameConsole();
        if(locked){
            console.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            console.setAlwaysOnTop(true);
        }
        else
            console.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        console.setVisible(true);
    }
}
