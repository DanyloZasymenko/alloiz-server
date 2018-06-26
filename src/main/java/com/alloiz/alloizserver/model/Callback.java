package com.alloiz.alloizserver.model;

import com.alloiz.alloizserver.model.utils.DateDeserializer;
import com.alloiz.alloizserver.model.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;

@Entity
public class Callback extends General {

    private String email;
    private String phone;
    private String company;
    private Timestamp datetime;

    @Column(columnDefinition = "LONGTEXT")
    private String message;

    @OneToMany(mappedBy = "callback", cascade = CascadeType.REFRESH)
    private CallbackTopic callbackTopic;

    public String getEmail() {
        return email;
    }

    public Callback setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Callback setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Callback setCompany(String company) {
        this.company = company;
        return this;
    }

    @JsonSerialize(using = DateSerializer.class)
    public Timestamp getDatetime() {
        return datetime;
    }

    @JsonDeserialize(using = DateDeserializer.class)
    public Callback setDatetime(Timestamp datetime) {
        this.datetime = datetime;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Callback setMessage(String message) {
        this.message = message;
        return this;
    }

    public CallbackTopic getCallbackTopic() {
        return callbackTopic;
    }

    public Callback setCallbackTopic(CallbackTopic callbackTopic) {
        this.callbackTopic = callbackTopic;
        return this;
    }

    @Override
    public String toString() {
        return "Callback{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", datetime=" + datetime +
                ", message='" + message + '\'' +
                ", callbackTopic=" + (callbackTopic == null ? "null" : callbackTopic) +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }
}
