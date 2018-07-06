package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.model.enums.CallbackTopic;
import com.alloiz.alloizserver.model.enums.OrderType;
import com.alloiz.alloizserver.model.utils.DateDeserializer;
import com.alloiz.alloizserver.model.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;

public class CallbackDto {

    protected Long id;
    protected String name;
    protected Boolean available;
    protected String email;
    protected String phone;
    protected String company;
    protected String message;
    protected Timestamp datetime;
    private CallbackTopic callbackTopic;
    private OrderType orderType;

    public CallbackDto() {
    }

    public Long getId() {
        return id;
    }

    public CallbackDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CallbackDto setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public CallbackDto setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CallbackDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CallbackDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public CallbackDto setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CallbackDto setMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonSerialize(using = DateSerializer.class)
    public Timestamp getDatetime() {
        return datetime;
    }

    @JsonDeserialize(using = DateDeserializer.class)
    public CallbackDto setDatetime(Timestamp datetime) {
        this.datetime = datetime;
        return this;
    }

    public CallbackTopic getCallbackTopic() {
        return callbackTopic;
    }

    public CallbackDto setCallbackTopic(CallbackTopic callbackTopic) {
        this.callbackTopic = callbackTopic;
        return this;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public CallbackDto setOrderType(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

    @Override
    public String toString() {
        return "CallbackDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", message='" + message + '\'' +
                ", datetime=" + datetime +
                ", callbackTopic=" + callbackTopic +
                ", orderType=" + orderType +
                '}';
    }
}
