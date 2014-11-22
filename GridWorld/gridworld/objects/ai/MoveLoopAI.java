package gridworld.objects.ai;
import gridworld.objects.Killer;
import gridworld.objects.KillerAI;

public class MoveLoopAI implements KillerAI{
    private int[][] deltas;
    private int index = 0;
    public MoveLoopAI(int[][] deltas){
        this.deltas = deltas;
    }
    public void update(Killer killer){
        killer.move(deltas[index][0], deltas[index][1]);
        index = (index+1)%deltas.length;
    }
}
