package gridworld;
public abstract class TurnAction{
    private GridObject object;
    private boolean finished = false;
    public TurnAction(GridObject object){
        this.object = object;
    }
    public GridObject getObject(){
        return object;
    }
    public synchronized void finish(){
        finished = true;
        notifyAll();
    }
    public synchronized boolean isFinished(){
        return finished;
    }
    public abstract void performTurn();
}
