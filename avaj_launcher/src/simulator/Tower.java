package simulator;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> observers2 = new ArrayList<>();


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
        for (Flyable flyable: observers)
        {
            flyable.updateConditions();
        }
        observers.removeAll(observers2);

    }
}

