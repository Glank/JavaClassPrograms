package gridworld.actions;
import gridworld.TurnAction;
import gridworld.Player;
public class MovePlayer extends TurnAction{
    private int dx, dy;
    public MovePlayer(Player player, int dx, int dy){
        super(player);
        this.dx = dx;
        this.dy = dy;
    }
    public void performTurn(){
        getObject().move(dx, dy);
    }
}
