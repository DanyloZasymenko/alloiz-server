package com.alloiz.alloizserver.dto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PortfolioDto {

    private Long id;
    private String name;
    private Boolean available;
    private String link;
    private List<ImageDto> images;
    private List<PortfolioDescriptionDto> descriptions;

    public Long getId() {
        return id;
    }

    public PortfolioDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PortfolioDto setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public PortfolioDto setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public String getLink() {
        return link;
    }

    public PortfolioDto setLink(String link) {
        this.link = link;
        return this;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public PortfolioDto setImages(List<ImageDto> images) {
        this.images = images;
        return this;
    }

    public List<PortfolioDescriptionDto> getDescriptions() {
        return descriptions;
    }

    public PortfolioDto setDescriptions(List<PortfolioDescriptionDto> descriptions) {
        this.descriptions = descriptions;
        return this;
    }

    @Override
    public String toString() {
        return "PortfolioDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", link='" + link + '\'' +
                ", images=" + images.stream().map(ImageDto::getId).collect(toList()) +
                ", descriptions=" + descriptions.stream().map(PortfolioDescriptionDto::getId).collect(toList()) +
                '}';
    }
}
