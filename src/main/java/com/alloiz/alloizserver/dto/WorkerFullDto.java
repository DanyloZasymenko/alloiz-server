package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.model.Incumbency;

import java.util.List;

public class WorkerFullDto extends WorkerShortDto<WorkerFullDto> {

  private List<Incumbency> incumbencies;

  public List<Incumbency> getIncumbencies() {
    return incumbencies;
  }

  public WorkerFullDto setIncumbencies(List<Incumbency> incumbencies) {
    this.incumbencies = incumbencies;
    return this;
  }

  @Override
  public String toString() {
    return "WorkerFullDto{" +
        "incumbency=" + (incumbencies  == null? "null": incumbencies) +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", image='" + image + '\'' +
        ", available=" + available +
        "} " + super.toString();
  }
}
