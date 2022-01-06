package com.example.Spring2022_01.ui;

public class PersonUI {
    private long id;
    private String name;
    private String surname;
    private int age;
    private String eMail;

    public PersonUI(long id, String name, String surname, int age, String eMail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.eMail = eMail;
    }

    public PersonUI(String name, String surname, int age, String eMail) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.eMail = eMail;
    }

    public PersonUI() {
    }

    public long getId() {
        return id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "PersonUI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
