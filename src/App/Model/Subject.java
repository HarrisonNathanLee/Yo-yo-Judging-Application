package App.Model;

import java.util.Collection;

public class Subject {

    protected Collection<Observer> observers;

    public void addObserver(Observer o){
        if (!observers.contains(o)){
            observers.add(o);
        }
    }

    public void removeObserver(Observer o){
        if(observers.contains(o)){
            observers.remove(o);
        }
    }

    public void notifyObserver(PlayerFun p){
        for (Observer o: observers){
            o.update(p);
        }
    }
}
