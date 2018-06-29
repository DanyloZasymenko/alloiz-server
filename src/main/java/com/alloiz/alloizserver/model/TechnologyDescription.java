package com.alloiz.alloizserver.model;

import com.alloiz.alloizserver.model.enums.Language;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class TechnologyDescription extends General<TechnologyDescription> {

    @ManyToOne(cascade = CascadeType.ALL)
    private Technology technology;
    private Language language;
    @Column(columnDefinition = "LONGTEXT")
    private String description;


    public Technology getTechnology() {
        return technology;
    }

    public TechnologyDescription setTechnology(Technology technology) {
        this.technology = technology;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public TechnologyDescription setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TechnologyDescription setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "TechnologyDescription{" +
                "technology=" + (technology == null ? "null" : technology) +
                ", language=" + (language == null ? "null" : language) +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", available=" + available +
                '}';
    }
}
