package com.example.Spring2022_01.domain;

import javax.persistence.*;

@Entity
@Table (name= "Person")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name= "id")
    private long id;

    @Column (name= "name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column( name= "age")
    private int age;

    @Column (name= "eMail")
    private String eMail;


    public Person(long id, String name, String surname, int age, String eMail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.eMail = eMail;
    }

    public Person(String name, String surname, int age, String eMail) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.eMail = eMail;
    }

    public Person() {
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
