package com.alloiz.alloizserver.dto;

import com.alloiz.alloizserver.dto.utils.annotations.Dto;

@Dto
public class WorkerShortDto {

    protected Long id;
    protected String name;
    protected String surname;
    protected String image;
    protected Boolean available;

    public WorkerShortDto(Long id, String name, String surname, String image, Boolean available) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.image = image;
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public WorkerShortDto setAvailable(Boolean available) {
        this.available = available;
        return this;
    }

    public Long getId() {
        return id;
    }

    public WorkerShortDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public WorkerShortDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public WorkerShortDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getImage() {
        return image;
    }

    public WorkerShortDto setImage(String image) {
        this.image = image;
        return this;
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
