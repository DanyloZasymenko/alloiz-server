package com.alloiz.alloizserver.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeneralName<T extends GeneralName> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;
  protected String name;
  protected Boolean available;

  public GeneralName() {
  }

  public Long getId() {
    return id;
  }

  public T setId(Long id) {
    this.id = id;
    return (T) this;
  }

  public String getName() {
    return name;
  }

  public T setName(String name) {
    this.name = name;
    return (T) this;
  }

  public Boolean getAvailable() {
    return available;
  }

  public T setAvailable(Boolean available) {
    this.available = available;
    return (T) this;
  }

  @Override
  public String toString() {
    return "GeneralName{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        '}';
  }
}
