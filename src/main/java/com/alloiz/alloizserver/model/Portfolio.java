package com.alloiz.alloizserver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class Portfolio extends GeneralName<Portfolio> {

    private String link;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.REMOVE)
    private List<Image> images;

    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioDescription> portfolioDescriptions;

    public String getLink() {
        return link;
    }

    public Portfolio setLink(String link) {
        this.link = link;
        return this;
    }

    public List<Image> getImages() {
        return images;
    }

    public Portfolio setImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public List<PortfolioDescription> getPortfolioDescriptions() {
        return portfolioDescriptions;
    }

    public Portfolio setPortfolioDescriptions(List<PortfolioDescription> portfolioDescriptions) {
        this.portfolioDescriptions = portfolioDescriptions;
        return this;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "link='" + link + '\'' +
                ", images=" + images.stream().map(Image::getId).collect(toList()) +
                ", portfolioDescriptions=" + portfolioDescriptions.stream().map(PortfolioDescription::getId).collect(toList()) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
