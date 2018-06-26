package com.alloiz.alloizserver.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class General {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected Boolean available;

    public Long getId() {
        return id;
    }

    public General setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public General setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public General setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    @Override
    public String toString() {
        return "General{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
