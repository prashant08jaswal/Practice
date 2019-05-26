package com.pshat.learning.designpatterns.observerdp.interfaces.impl;


import com.pshat.learning.designpatterns.observerdp.interfaces.Observer;
import com.pshat.learning.designpatterns.observerdp.interfaces.Subject;
import com.pshat.learning.designpatterns.observerdp.model.ObserverEnums;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by Prashant on 26-05-2019.
 */
public class StatusOnChangeObserver implements Observer {

    private Subject subject;
    /*
    On Object creation this obserer will be registered with the Subject.
     */
    public StatusOnChangeObserver(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    private Logger logger = Logger.getLogger(getClass());

    /*
    Whenever there is an update, Subject will inform the Observers.
     */
    public void execute(Map<String, String> properties) {
        logger.warn("StatusOnChangeObserver observer executed");

       String eventType = properties.get(ObserverEnums.EVENT_TYPE.getValue());
        if(ObserverEnums.STATUS_EVENT.getValue().equals(eventType)){
            logger.info("Status Changed has executed the trigger");
            logger.info("New Properties are : " + properties);
        }
    }
}
