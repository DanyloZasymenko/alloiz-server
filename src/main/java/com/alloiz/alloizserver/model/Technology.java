package com.alloiz.alloizserver.model;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class Technology extends GeneralName<Technology> {

    private String image;

    @OneToMany(mappedBy = "technology")
    private List<TechnologyDescription> technologyDescriptions;

    public Technology() {
    }

    public String getImage() {
        return image;
    }

    public Technology setImage(String image) {
        this.image = image;
        return this;
    }

    public List<TechnologyDescription> getTechnologyDescriptions() {
        return technologyDescriptions;
    }

    public Technology setTechnologyDescriptions(List<TechnologyDescription> technologyDescriptions) {
        this.technologyDescriptions = technologyDescriptions;
        return this;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "image='" + image + '\'' +
                ", technologyDescriptions=" + technologyDescriptions.stream().map(TechnologyDescription::getId).collect(toList()) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
