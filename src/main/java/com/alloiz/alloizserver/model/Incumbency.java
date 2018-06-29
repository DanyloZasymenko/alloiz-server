package com.alloiz.alloizserver.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Incumbency extends GeneralName<Incumbency> {

  @ManyToMany
  @JoinTable(name = "worker_specialization",
          joinColumns = @JoinColumn(name = "incumbency_id"),
          inverseJoinColumns = @JoinColumn(name = "worker_id"))
  private List<Worker> workerList;

  private Boolean isOpen;

  public List<Worker> getWorkerList() {
    return workerList;
  }

  public Incumbency setWorkerList(List<Worker> workerList) {
    this.workerList = workerList;
    return this;
  }

  public Incumbency() {
  }

  public Boolean getOpen() {
    return isOpen;
  }

  public Incumbency setOpen(Boolean open) {
    isOpen = open;
    return this;
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
