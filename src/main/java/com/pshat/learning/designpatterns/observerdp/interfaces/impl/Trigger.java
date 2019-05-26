package com.pshat.learning.designpatterns.observerdp.interfaces.impl;


import com.pshat.learning.designpatterns.observerdp.interfaces.*;
import com.pshat.learning.designpatterns.observerdp.interfaces.Observer;

import java.util.*;

/**
 * Created by Prashant on 26-05-2019.
 */
public class Trigger implements Subject {
    private Map<String,String> properties = new HashMap();
    private Set<Observer> observerSet = new LinkedHashSet();

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
