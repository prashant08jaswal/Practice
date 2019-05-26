package com.pshat.learning.designpatterns.observerdp.model;

/**
 * Created by Prashant on 26-05-2019.
 */
public enum ObserverEnums {
    EVENT_TYPE("eventType"),
    STATUS_EVENT("Status"),
    WORKFLOW_EVENT("Workflow");

    private String value;
    private ObserverEnums(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
