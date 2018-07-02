package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;
import java.sql.Timestamp;

@Dto
public class CallbackShortDto<T extends CallbackShortDto> {

  protected Long id;
  protected String name;
  protected Boolean available;
  protected String email;
  protected String phone;
  protected String company;
  protected String message;
  protected Timestamp datetime;

  public Long getId() {
    return id;
  }

  public T setId(Long id) {
    this.id = id;
    return (T) this;
  }

  public String getName() {
    return name;
  }

  public T setName(String name) {
    this.name = name;
    return (T) this;
  }

  public Boolean getAvailable() {
    return available;
  }

  public T setAvailable(Boolean available) {
    this.available = available;
    return (T) this;
  }

  public String getEmail() {
    return email;
  }

  public T setEmail(String email) {
    this.email = email;
    return (T) this;
  }

  public String getPhone() {
    return phone;
  }

  public T setPhone(String phone) {
    this.phone = phone;
    return (T) this;
  }

  public String getCompany() {
    return company;
  }

  public T setCompany(String company) {
    this.company = company;
    return (T) this;
  }

  public Timestamp getDatetime() {
    return datetime;
  }

  public T setDatetime(Timestamp datetime) {
    this.datetime = datetime;
    return (T) this;
  }

  public String getMessage() {
    return message;
  }

  public CallbackShortDto<T> setMessage(String message) {
    this.message = message;
    return this;
  }

  @Override
  public String toString() {
    return "CallbackShortDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", available=" + available +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", company='" + company + '\'' +
            ", message='" + message + '\'' +
            ", datetime=" + datetime +
            '}';
  }
}
