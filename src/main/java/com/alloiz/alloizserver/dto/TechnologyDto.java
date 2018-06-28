package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.model.TechnologyDescription;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TechnologyDto {

    private Long id;
    private String name;
    private Boolean available;
    private String image;
    private List<TechnologyDescriptionDto> technologyDescription;

    public Long getId() {
        return id;
    }

    public TechnologyDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TechnologyDto setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public TechnologyDto setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public String getImage() {
        return image;
    }

    public TechnologyDto setImage(String image) {
        this.image = image;
        return this;
    }

    public List<TechnologyDescriptionDto> getTechnologyDescription() {
        return technologyDescription;
    }

    public TechnologyDto setTechnologyDescription(List<TechnologyDescriptionDto> technologyDescription) {
        this.technologyDescription = technologyDescription;
        return this;
    }

    @Override
    public String toString() {
        return "TechnologyDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", image='" + image + '\'' +
                ", technologyDescriptionDtos=" + technologyDescription.stream().map(TechnologyDescriptionDto::getId).collect(toList()) +
                '}';
    }
}
