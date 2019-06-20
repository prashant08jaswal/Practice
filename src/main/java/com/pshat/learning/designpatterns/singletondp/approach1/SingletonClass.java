package com.pshat.learning.designpatterns.singletondp.approach1;

// thread safety remaining.
public class SingletonClass extends CommonUtils{
    private SingletonClass(){}
    /*
    Without volatile modifier it's possible for another thread in Java to see half initialized state of instance variable, but with
    volatile variable guaranteeing happens-before relationship, all the write will happen on volatile instance before any read of
    instance variable.

    This was not the case prior to Java 5, and that's why double checked locking was broken before. Now, with happens-before guarantee,
    you can safely assume that this will work.By the way this is not the best way to create thread-safe Singleton,
    you can use Enum as Singleton, which provides inbuilt thread-safety during instance creation. Another way is to use static holder
    pattern.

    Atomic operations are performed in a single unit of task without interference from other operations

    http://javarevisited.blogspot.in/2011/03/10-interview-questions-on-singleton.html
     */
    private volatile static SingletonClass instance;

    public static final SingletonClass getSingletonInstance(){
        if(instance==null){ //1st null check without lock
            synchronized (SingletonClass.class){
                if (instance == null){ //2nd null check with lock
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
