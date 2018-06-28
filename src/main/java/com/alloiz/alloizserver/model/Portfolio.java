package com.alloiz.alloizserver.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Portfolio extends General<Portfolio>{

  private String link;
  private List<String> images;

  @Column(columnDefinition = "LONGTEXT")
  private String description;

  public Portfolio() {
    images = new ArrayList<String>();
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
