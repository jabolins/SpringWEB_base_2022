package com.example.Spring2022_01.ui;

import org.springframework.stereotype.Component;

public class PersonWeb {
    private long id;
    private String name;
    private String surname;

    public PersonWeb(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public PersonWeb(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public PersonWeb() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "PersonWeb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
