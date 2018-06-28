package com.alloiz.alloizserver.model;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Technology extends General<Technology>{

    private String image;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    public Technology() {
    }

    public String getImage() {
        return image;
    }

    public Technology setImage(String image) {
        this.image = image;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Technology setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
