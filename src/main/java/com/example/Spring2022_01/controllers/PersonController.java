package com.example.Spring2022_01.controllers;

import com.example.Spring2022_01.domain.Person;
import com.example.Spring2022_01.mappers.Mapper;
import com.example.Spring2022_01.repositories.PersonRepo;
import com.example.Spring2022_01.ui.PersonWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {

    final
    PersonRepo personRepo;
    final
    Mapper mapper;

    public PersonController(PersonRepo personRepo, Mapper mapper) {
        this.personRepo = personRepo;
        this.mapper = mapper;
    }


    @GetMapping()
    public String index(Model model) {

        List<PersonWeb> allWebPersons= new ArrayList<>();
        personRepo.findAll().forEach(person -> allWebPersons.add(mapper.mapFromSQL(person)));
        model.addAttribute("sarakstsPeople", allWebPersons);

        return "people/index"; // norādam kādā lapā rādīsies atrastais
    }

    @GetMapping("/{id}") // liekam figūriekavās jo tas ir mainīgais
    public String show(@PathVariable("id") int id, Model model) {
        PersonWeb personWeb = mapper.mapFromSQL(personRepo.findById(Long.valueOf(id)).get());
        model.addAttribute("vienaPerson", personWeb);
        return "people/show";

    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("vienaPersonaNew", new PersonWeb());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("atklaVienaPersona") PersonWeb personWeb) { // @ModelAttribute nodrošina:
        // jauna objekta izveidi (Person new person),
        // lauku aizpildīšanu (setName (name), setSurname (surname), utt
        // pievieno šo objektu modeli (model.addAttribute( "person", person)

        personRepo.save(mapper.mapFromPersonWeb(personWeb));
        return "redirect:/people";
    }

    // lai paraditu labojamo personu pēc id
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        PersonWeb personWeb = mapper.mapFromSQL(personRepo.findById(Long.valueOf(id)).get());
        model.addAttribute("labojamaisPerson", personWeb);
        return "people/edit";
    }

    //labotu personu kas atrasta. html lapā ir slēptais lauks _method kas nodrošina PATCH nosūtīšanu.
    // Bet to vēl vajag apstrādāt Spring pusē- jāizveido aplication.Properties sekojoss lauks:
    // spring.mvc.hiddenmethod.filter.enabled=true
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("labojamaisPerson") PersonWeb personWeb, @PathVariable("id") int id) {
        personRepo.save(mapper.mapFromPersonWeb(personWeb));
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        long longId = id;
        personRepo.deleteById(longId);
        return "redirect:/people";
    }

}
