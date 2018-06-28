package com.alloiz.alloizserver.model;

import javax.persistence.Entity;

@Entity
public class Image extends General<Image>{

  private String path;

  public Image(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public Image setPath(String path) {
    this.path = path;
    return this;
  }

  @Override
  public String toString() {
    return "Image{" +
        "path='" + path + '\'' +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        "} " + super.toString();
  }
}
