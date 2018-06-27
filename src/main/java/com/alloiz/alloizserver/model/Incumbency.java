package com.alloiz.alloizserver.model;

import javax.persistence.Entity;

@Entity
public class Incumbency extends General{

  private Boolean isOpen;

  public Incumbency() {
  }

  public Boolean getOpen() {
    return isOpen;
  }

  public void setOpen(Boolean open) {
    isOpen = open;
  }

  @Override
  public String toString() {
    return "Incumbency{" +
        "isOpen=" + isOpen +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        "} " + super.toString();
  }
}
