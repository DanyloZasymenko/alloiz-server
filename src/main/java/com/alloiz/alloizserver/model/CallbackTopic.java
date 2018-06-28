package com.alloiz.alloizserver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class CallbackTopic extends General<CallbackTopic> {

    @OneToMany(mappedBy = "callbackTopic", cascade = CascadeType.REFRESH)
    private List<Callback> callbacks;

    public List<Callback> getCallbacks() {
        return callbacks;
    }

    public CallbackTopic setCallbacks(List<Callback> callbacks) {
        this.callbacks = callbacks;
        return this;
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
