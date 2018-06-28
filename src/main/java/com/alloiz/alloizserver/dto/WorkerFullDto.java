package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.model.Incumbency;

public class WorkerFullDto extends WorkerShortDto<WorkerFullDto> {

  private Incumbency incumbency;

  public Incumbency getIncumbency() {
    return incumbency;
  }

  public WorkerFullDto setIncumbency(Incumbency incumbency) {
    this.incumbency = incumbency;
    return this;
  }

  @Override
  public String toString() {
    return "WorkerFullDto{" +
        "incumbency=" + (incumbency  == null? "null": incumbency) +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", image='" + image + '\'' +
        ", available=" + available +
        "} " + super.toString();
  }
}
