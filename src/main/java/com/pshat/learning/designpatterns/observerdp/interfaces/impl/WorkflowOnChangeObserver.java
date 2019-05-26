package com.pshat.learning.designpatterns.observerdp.interfaces.impl;

import com.pshat.learning.designpatterns.observerdp.interfaces.Observer;
import com.pshat.learning.designpatterns.observerdp.interfaces.Subject;
import com.pshat.learning.designpatterns.observerdp.model.ObserverEnums;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by Prashant on 26-05-2019.
 */

/*
    One of the observer, although it will be called whenever there is state change
    but it's execute method will execute business logic on certain conditions.
 */
public class WorkflowOnChangeObserver implements Observer{
    private Subject subject;
    private Logger logger = Logger.getLogger(getClass());

    public WorkflowOnChangeObserver(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    /*
        Whenever there is an update, Subject will inform the Observers.
    */
    public void execute(Map<String, String> properties) {
        logger.warn("WorkflowOnChangeObserver observer executed");

        String eventType = properties.get(ObserverEnums.EVENT_TYPE.getValue());
        if(ObserverEnums.WORKFLOW_EVENT.getValue().equals(eventType)){
            logger.info("Workflow Changed has executed the trigger");
            logger.info("New Properties are : " + properties);
        }
    }
}
