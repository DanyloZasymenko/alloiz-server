package com.alloiz.alloizserver.model;

import static java.util.stream.Collectors.toList;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Worker extends General<Worker> {

  private String surname;
  private String image;

  @ManyToMany(cascade = CascadeType.REFRESH)
  private List<Incumbency> incumbencies;

  public Worker() {
  }

  public List<Incumbency> getIncumbencies() {
    return incumbencies;
  }

  public Worker setIncumbencies(
      List<Incumbency> incumbencies) {
    this.incumbencies = incumbencies;
    return this;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Worker setName(String name) {
    this.name = name;
    return this;
  }

  public String getSurname() {
    return surname;
  }

  public Worker setSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public String getImage() {
    return image;
  }

  public Worker setImage(String image) {
    this.image = image;
    return this;
  }

  @Override
  public String toString() {
    return "Worker{" +
        "surname='" + surname + '\'' +
        ", image='" + image + '\'' +
        ", incumbency=" + incumbencies.stream().map(Incumbency::getName).collect(toList()) +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        "} " + super.toString();
  }
}
