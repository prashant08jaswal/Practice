package com.pshat.learning.designpatterns.singletondp.approach1;

import java.io.Serializable;

public class CommonUtils implements Cloneable,Serializable{
    private static final long serialVersionUID=2L;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
