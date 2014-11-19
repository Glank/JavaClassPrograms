package gridworld;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;

public class GridWorld implements Runnable{
    private LinkedList<TurnAction> actionQueue = 
        new LinkedList<TurnAction>();
    private LinkedList<GridChangeListener> gcListeners =
        new LinkedList<GridChangeListener>();
    private LinkedList<GridUpdate> updates =
        new LinkedList<GridUpdate>();
    private Grid grid;
    private boolean stopped = false;
    public GridWorld(Grid grid){
        this.grid = grid;
        startDaemonThread();
    }

    public Grid getGrid(){
        return grid;
    }

    public void setGrid(Grid grid){
        this.grid = grid;
        synchronized(gcListeners){
            for(GridChangeListener listener: gcListeners)
                listener.gridChanged(grid);
        }
    }

    public void addListener(GridChangeListener listener){
        synchronized(gcListeners){
            gcListeners.add(listener);
        }
    }

    public void addUpdate(GridUpdate update){
        synchronized(updates){
            updates.add(update);
        }
    }

    private void startDaemonThread(){
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public void doAction(TurnAction action){
        synchronized(actionQueue){
            actionQueue.add(action);
        }
    }

    private void doTurn(){
        synchronized(actionQueue){
            //each object get's to have a turn if it has requested
            HashSet<GridObject> hasHadTurn = new HashSet<GridObject>();
            Iterator<TurnAction> iterator = actionQueue.iterator();
            while(iterator.hasNext()){
                TurnAction action = iterator.next();
                GridObject object = action.getObject();
                //if the object hasn't had a turn yet
                if(!hasHadTurn.contains(object)){
                    //remove action from the queue
                    iterator.remove(); 
                    action.performTurn();
                    action.finish();
                    hasHadTurn.add(object);
                }
                //else we'll get to it in a later turn
            }
        }
    }

    public void run(){
        while(!stopped){
            //sleep for half a second
            try{Thread.sleep(500);}catch(InterruptedException ex){}
            //do the next turn
            doTurn();
            //run all the grid updates
            synchronized(updates){
                for(GridUpdate update:updates){
                    update.update(grid);
                }
            }
            //notify everything waiting for a turn update
            synchronized(this){notifyAll();}
        }
        //notify everything that this is stopped
        synchronized(this){notifyAll();}
    }

    public void close(){
        stopped = true;
    }

    public boolean isStopped(){
        return stopped;
    }
}
