package com.alloiz.alloizserver.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Portfolio extends General<Portfolio> {

  private String link;
  private List<String> images;

  @Column(columnDefinition = "LONGTEXT")
  private String description;

  public String getLink() {
    return link;
  }

  public Portfolio setLink(String link) {
    this.link = link;
    return this;
  }

  public List<String> getImages() {
    return images;
  }

  public Portfolio setImages(List<String> images) {
    this.images = images;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Portfolio setDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public String toString() {
    return "Portfolio{" +
        "link='" + link + '\'' +
        ", images=" + images +
        ", description='" + description + '\'' +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        "} " + super.toString();
  }
}
