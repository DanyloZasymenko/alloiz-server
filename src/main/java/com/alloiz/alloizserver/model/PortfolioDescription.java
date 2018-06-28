package com.alloiz.alloizserver.model;

import com.alloiz.alloizserver.model.enums.Language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PortfolioDescription extends General<PortfolioDescription> {

    @ManyToOne
    private Portfolio portfolio;
    private Language language;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public PortfolioDescription setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public PortfolioDescription setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PortfolioDescription setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "PortfolioDescription{" +
                "portfolio=" + (portfolio == null ? "null" : portfolio) +
                ", language=" + (language == null ? "null" : language) +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", available=" + available +
                '}';
    }
}
