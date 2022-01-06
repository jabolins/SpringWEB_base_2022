package com.example.Spring2022_01.mappers;

import com.example.Spring2022_01.domain.Person;
import com.example.Spring2022_01.ui.PersonUI;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Person mapFromPersonWeb(PersonUI personWeb) {

        Person person = new Person(
                personWeb.getName()
                , personWeb.getSurname()
                , personWeb.getAge()
                , personWeb.getEMail());
        return person;
    }

    public PersonUI mapFromSQL(Person person) {
        PersonUI personUI = new PersonUI(
                person.getId()
                , person.getName()
                , person.getSurname()
                , person.getAge()
                , person.geteMail());
        return personUI;
    }
}
