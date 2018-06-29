package com.alloiz.alloizserver.model;

import javax.persistence.Entity;

@Entity
public class Incumbency extends GeneralName<Incumbency> {


    private Boolean isOpen;

    public Incumbency() {
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public Incumbency setOpen(Boolean open) {
        isOpen = open;
        return this;
    }

    @Override
    public String toString() {
        return "Incumbency{" +
                "isOpen=" + isOpen +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                "} " + super.toString();
    }
}
