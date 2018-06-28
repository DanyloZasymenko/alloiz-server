package com.alloiz.alloizserver.dto;

public class CallbackFullDto extends CallbackShortDto<CallbackFullDto> {

  private CallbackTopicShortDto callbackTopic;

  public CallbackTopicShortDto getCallbackTopic() {
    return callbackTopic;
  }

  public CallbackFullDto setCallbackTopic(
      CallbackTopicShortDto callbackTopic) {
    this.callbackTopic = callbackTopic;
    return this;
  }

  @Override
  public String toString() {
    return "CallbackFullDto{" +
        "callbackTopic=" + (callbackTopic == null? "null": callbackTopic) +
        ", id=" + id +
        ", name='" + name + '\'' +
        ", available=" + available +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", company='" + company + '\'' +
        ", datetime=" + datetime +
        "} " + super.toString();
  }
}
