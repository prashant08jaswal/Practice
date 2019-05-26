package com.pshat.learning.designpatterns.observerdp.interfaces;

import java.util.Map;

/**
 * Created by Prashant on 26-05-2019.
 */
public interface Observer {
    void execute(Map<String, String> properties);
}
