package com.example.Spring2022_01.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {

    @Test
    void index() {
        PersonDAO personDAO = new PersonDAO();
        System.out.println(personDAO.index());
    }

    @Test
    void show() {
        PersonDAO personDAO = new PersonDAO();
        System.out.println(personDAO.show(1));
    }
}