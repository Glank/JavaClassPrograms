package gridworld.actions;
import gridworld.TurnAction;
import gridworld.objects.Player;
public class MovePlayer extends TurnAction{
    private int dx, dy;
    private boolean success;
    public MovePlayer(Player player, int dx, int dy){
        super(player);
        this.dx = dx;
        this.dy = dy;
    }
    public void performTurn(){
        success = getObject().move(dx, dy);
    }
    public boolean wasSuccessfull(){
        return success;
    }
}
