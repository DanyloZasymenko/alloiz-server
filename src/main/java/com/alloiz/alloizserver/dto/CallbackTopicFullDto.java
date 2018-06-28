package com.alloiz.alloizserver.dto;

public class CallbackTopicFullDto extends CallbackTopicShortDto<CallbackTopicFullDto> {

    private CallbackShortDto callback;

    public CallbackShortDto getCallback() {
        return callback;
    }

    public CallbackTopicFullDto setCallback(CallbackShortDto callback) {
        this.callback = callback;
        return this;
    }

    @Override
    public String toString() {
        return "CallbackTopicFullDto{" +
                "callback=" + (callback == null ? "null" : callback) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
