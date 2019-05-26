package com.pshat.learning.designpatterns.observerdp.interfaces;

/**
 * Created by Prashant on 26-05-2019.
 */

/*
    Publisher will implement this method.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
}
