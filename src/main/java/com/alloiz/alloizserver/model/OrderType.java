package com.alloiz.alloizserver.model;

import javax.persistence.Entity;

@Entity
public class OrderType extends General<OrderType>{

    public OrderType() {
    }

    @Override
    public String toString() {
        return "OrderType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
