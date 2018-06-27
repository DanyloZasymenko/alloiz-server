package com.alloiz.alloizserver.model;

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
