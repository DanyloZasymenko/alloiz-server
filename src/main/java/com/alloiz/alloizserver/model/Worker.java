package com.alloiz.alloizserver.model;

import javax.persistence.Entity;

@Entity
public class Worker extends General {

    private String surname;
    private String image;

    public Worker() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Worker setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Worker setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Worker setImage(String image) {
        this.image = image;
        return this;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
