package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;
import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.model.enums.Language;

@Dto
public class TechnologyDescriptionDto {

  protected Long id;
  protected Technology technology;
  protected Language language;
  protected Boolean available;
  protected String description;


  public String getDescription() {
    return description;
  }

  public TechnologyDescriptionDto setDescription(String description) {
    this.description = description;
    return this;
  }

  public Technology getTechnology() {
    return technology;
  }

  public TechnologyDescriptionDto setTechnology(Technology technology) {
    this.technology = technology;
    return this;
  }

  public Language getLanguage() {
    return language;
  }

  public TechnologyDescriptionDto setLanguage(Language language) {
    this.language = language;
    return this;
  }

  public Long getId() {
    return id;
  }

  public TechnologyDescriptionDto setId(Long id) {
    this.id = id;
    return this;
  }

  public Boolean getAvailable() {
    return available;
  }

  public TechnologyDescriptionDto setAvailable(Boolean available) {
    this.available = available;
    return this;
  }

  @Override
  public String toString() {
    return "TechnologyDescriptionDto{" +
        "technology=" + technology +
        ", language=" + language +
        ", id=" + id +
        ", available=" + available +
        '}';
  }
}
