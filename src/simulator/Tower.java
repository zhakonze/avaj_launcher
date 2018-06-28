package simulator;

import simulator.transport.Flyable;

import java.util.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> observers2 = new ArrayList<>();


    public void register(Flyable flyable)
    {
        if(observers.contains(flyable))
            return;
        else
            observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        if(observers2.contains(flyable))
            return;
        else
        observers2.add(flyable);
    }

    protected void conditionsChanged()
    {
        for (Flyable flyable : observers)
        {
            flyable.updateConditions();
        }
        observers.removeAll(observers2);

    }
}

