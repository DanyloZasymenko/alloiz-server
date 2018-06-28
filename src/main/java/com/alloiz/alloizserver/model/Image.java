package com.alloiz.alloizserver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Image extends GeneralName<Image> {

    private String path;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Portfolio portfolio;

    public String getPath() {
        return path;
    }

    public Image setPath(String path) {
        this.path = path;
        return this;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public Image setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
        return this;
    }

    @Override
    public String toString() {
        return "Image{" +
                "path='" + path + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                "} " + super.toString();
    }
}
