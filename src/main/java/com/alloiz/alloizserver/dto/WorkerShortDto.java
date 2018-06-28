package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;

@Dto
public class WorkerShortDto <T extends WorkerShortDto>{

    protected Long id;
    protected String name;
    protected String surname;
    protected String image;
    protected Boolean available;


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

    public String getSurname() {
        return surname;
    }

    public T setSurname(String surname) {
        this.surname = surname;
        return (T) this;
    }

    public String getImage() {
        return image;
    }

    public T setImage(String image) {
        this.image = image;
        return (T) this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public T setAvailable(Boolean available) {
        this.available = available;
        return (T) this;
    }

    @Override
    public String toString() {
        return "WorkerShortDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
