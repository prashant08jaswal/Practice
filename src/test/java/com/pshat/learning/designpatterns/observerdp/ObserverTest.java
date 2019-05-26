package com.pshat.learning.designpatterns.observerdp;

import com.pshat.learning.designpatterns.observerdp.interfaces.impl.StatusOnChangeObserver;
import com.pshat.learning.designpatterns.observerdp.interfaces.impl.Trigger;
import com.pshat.learning.designpatterns.observerdp.interfaces.impl.WorkflowOnChangeObserver;
import com.pshat.learning.designpatterns.observerdp.model.ObserverEnums;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prashant on 26-05-2019.
 */
public class ObserverTest {

    private static Trigger subject;
    private static WorkflowOnChangeObserver workflowObserver;
    private static StatusOnChangeObserver statusObserver;
    private static Map<String,String> properties;

    @BeforeClass
    public static void beforeClass() throws Exception {
        subject = new Trigger();
        workflowObserver = new WorkflowOnChangeObserver(subject);
        statusObserver = new StatusOnChangeObserver(subject);
        properties = new HashMap<>();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        subject = null;
        workflowObserver = null;
        statusObserver = null;
        properties = null;
    }

    @After
    public void after() throws Exception{
        properties.clear();
    }

    @Test
    public void testStatusObserver(){
        properties.put(ObserverEnums.EVENT_TYPE.getValue(),ObserverEnums.STATUS_EVENT.getValue());
        subject.setProperties(properties);
    }

    @Test
    public void testWorkflowObserver(){
        properties.put(ObserverEnums.EVENT_TYPE.getValue(),ObserverEnums.WORKFLOW_EVENT.getValue());
        subject.setProperties(properties);
    }
}
