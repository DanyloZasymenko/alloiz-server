package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;
import com.alloiz.alloizserver.model.enums.Language;

@Dto
public class PortfolioDescriptionDto {

    private Language language;
    private Long id;
    private String description;
    private Boolean available;

    public Language getLanguage() {
        return language;
    }

    public PortfolioDescriptionDto setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PortfolioDescriptionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public PortfolioDescriptionDto setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PortfolioDescriptionDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "PortfolioDescriptionDto{" +
                "language=" + language +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
