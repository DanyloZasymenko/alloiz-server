package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;
import com.alloiz.alloizserver.model.Technology;
import com.alloiz.alloizserver.model.enums.Language;

@Dto
public class TechnologyDescriptionDto {

  private Technology technology;
  private Language language;
  protected Long id;
  protected Boolean available;

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
