package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;
import com.alloiz.alloizserver.model.Portfolio;
import com.alloiz.alloizserver.model.enums.Language;

@Dto
public class PortfolioDescriptionDto {

  private Portfolio portfolio;
  private Language language;
  protected Long id;
  protected Boolean available;

  public Portfolio getPortfolio() {
    return portfolio;
  }

  public PortfolioDescriptionDto setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
    return this;
  }

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

  @Override
  public String toString() {
    return "PortfolioDescriptionDto{" +
        "portfolio=" + portfolio +
        ", language=" + language +
        ", id=" + id +
        ", available=" + available +
        '}';
  }
}
