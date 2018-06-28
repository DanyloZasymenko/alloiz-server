package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;

@Dto
public class ImageDto {

  protected String path;
  protected Long id;
  protected String name;
  protected Boolean available;

  public String getPath() {
    return path;
  }

  public ImageDto setPath(String path) {
    this.path = path;
    return this;
  }

  public Long getId() {
    return id;
  }

  public ImageDto setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public ImageDto setName(String name) {
    this.name = name;
    return this;
  }

  public Boolean getAvailable() {
    return available;
  }

  public ImageDto setAvailable(Boolean available) {
    this.available = available;
    return this;
  }

  @Override
  public String toString() {
    return "ImageDto{" +
        "path='" + path + '\'' +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        '}';
  }
}
