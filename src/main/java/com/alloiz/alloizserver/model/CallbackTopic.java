package com.alloiz.alloizserver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CallbackTopic extends General {

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Callback callback;

    public CallbackTopic() {
    }

    @Override
    public String toString() {
        return "CallbackTopic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                "} " + super.toString();
    }
}
