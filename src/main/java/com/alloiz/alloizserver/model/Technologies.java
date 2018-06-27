package com.alloiz.alloizserver.model;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Technologies extends General{

    private String image;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    public Technologies() {
    }

    public String getImage() {
        return image;
    }

    public Technologies setImage(String image) {
        this.image = image;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Technologies setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Technologies{" +
                "image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
