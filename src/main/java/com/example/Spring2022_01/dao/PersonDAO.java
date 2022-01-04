package com.example.Spring2022_01.dao;

import com.example.Spring2022_01.domain.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
private static int PEOPLE_COUNT;
   private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Janis", "Karklins"));
        people.add(new Person(++PEOPLE_COUNT, "Peteris", "Ozolls"));
        people.add(new Person(++PEOPLE_COUNT, "Anna", "Berzina"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id ).findAny().orElse(null); // ar stream
        // iziet cauri visam masīvam, atfiltrē pēc parson.get(id) salīdinot ar padoto mainīgo "id". Atrod
        // visus, un ja nē (else) tad atgriež "null"
    }
}
