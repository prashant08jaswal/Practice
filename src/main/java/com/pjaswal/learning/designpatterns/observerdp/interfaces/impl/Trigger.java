package com.pjaswal.learning.designpatterns.observerdp.interfaces.impl;


import com.pjaswal.learning.designpatterns.observerdp.interfaces.*;
import com.pjaswal.learning.designpatterns.observerdp.interfaces.Observer;

import java.util.*;

/**
 * Created by Prashant on 26-05-2019.
 */


/*
Disadvantage of Observer Design Pattern in Java:
 1   The disadvantage is that the sometime if any problem comes,
    debugging becomes very difficult because flow of control is implicitly between observers and observable
    we can predict that now observer is going to fire and if there is chain between observers then debugging become more complex.
 2  Another issue is Memory management because subject will hold all the reference of all the observers if we not unregister the object it can create the memory issue.
 */

public class Trigger implements Subject {
    /*
      Data properties, taken as map, so in case new property needs to be added,
      there won't be any change in the Structure.
    */
    private Map<String,String> properties = new HashMap<>();

    /*
        List of observers.
     */
    private List<Observer> observerSet = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observerSet.add(observer);
    }

    public void unregisterObserver(Observer observer) {
        observerSet.remove(observer);
    }

    public void notifyObservers() {
        observerSet.forEach(observer -> observer.execute(properties));
    }

    public void setProperties(Map<String,String> properties){
        this.properties = properties;
        notifyObservers();
    }
}
