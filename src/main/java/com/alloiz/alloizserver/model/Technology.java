package com.alloiz.alloizserver.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class Technology extends GeneralName<Technology> {

    private String image;

    @OneToMany(mappedBy = "technology",cascade = CascadeType.ALL)
    private List<TechnologyDescription> descriptions;

    public Technology() {
    }

    public String getImage() {
        return image;
    }

    public Technology setImage(String image) {
        this.image = image;
        return this;
    }

    public List<TechnologyDescription> getDescriptions() {
        return descriptions;
    }

    public Technology setDescriptions(List<TechnologyDescription> descriptions) {
        this.descriptions = descriptions;
        return this;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "image='" + image + '\'' +
                ", descriptions=" + descriptions.stream().map(TechnologyDescription::getId).collect(toList()) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
