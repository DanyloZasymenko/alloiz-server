package com.alloiz.alloizserver.model;

import javax.persistence.Entity;

@Entity
public class CallbackTopic extends General{

  public CallbackTopic() {
  }

  @Override
  public String toString() {
    return "CallbackTopic{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        "} " + super.toString();
  }
}
