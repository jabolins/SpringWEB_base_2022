package com.example.Spring2022_01.mappers;

import com.example.Spring2022_01.domain.Person;
import com.example.Spring2022_01.ui.PersonWeb;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Person mapFromPersonWeb(PersonWeb personWeb){

        Person person = new Person(
                personWeb.getName()
                , personWeb.getSurname());
        return person;
    }

    public PersonWeb mapFromSQL(Person person){
        PersonWeb personWeb = new PersonWeb(
                person.getId()
                , person.getName()
                , person.getSurname());
        return personWeb;
    }
}
