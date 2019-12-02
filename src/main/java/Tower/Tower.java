package Tower;

import Aircraft.Ballon;
import Aircraft.Flyable;

import java.util.List;
import java.util.ArrayList;

public class Tower {

private List <Flyable> observers = new ArrayList<>();

public void register(Flyable flyable){
//    if (!observers.contains(flyable))
    observers.add(flyable);
}
public void unregister(Flyable flyable){
    observers.remove(flyable);
}



protected void conditionChange(){

    for(int i = 0; i < observers.size(); i++)
    {
        observers.get(i).updateConditions();
    }
}

}
