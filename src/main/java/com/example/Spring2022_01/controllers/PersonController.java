package com.example.Spring2022_01.controllers;

import com.example.Spring2022_01.dao.PersonDAO;
import com.example.Spring2022_01.domain.Person;
import com.example.Spring2022_01.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {

    final
    PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    //private final PersonDAO personDAO;

//    public PersonController(PersonDAO personDAO) {
//        this.personDAO = personDAO;
//    }

    @GetMapping()
    public String index(Model model) {


        model.addAttribute("sarakstsPeople", personRepo.findAll());
        //model.addAttribute("sarakstsPeople", personDAO.index());

        return "people/index"; // norādam kādā lapā rādīsies atrastais
    }

    @GetMapping("/{id}") // liekam figūriekavās jo tas ir mainīgais

    public String show(@PathVariable("id") int id, Model model) {
        long longId = id;
        model.addAttribute("vienaPerson", personRepo.findById(longId));
        return "people/show";

    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("vienaPersonaNew", new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("atklaVienaPersona") Person person) { // @ModelAttribute nodrošina:
        // jauna objekta izveidi (Person new person),
        // lauku aizpildīšanu (setName (name), setSurname (surname), utt
        // pievieno šo objektu modeli (model.addAttribute( "person", person)

        personRepo.save(person);
        return "redirect:/people";
    }

    // lai paraditu labojamo personu pēc id
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        long longId = id;
        model.addAttribute("labojamaisPerson", personRepo.findById(longId));
        return "people/edit";
    }

    //labotu personu kas atrasta. html lapā ir slēptais lauks _method kas nodrošina PATCH nosūtīšanu.
    // Bet to vēl vajag apstrādāt Spring pusē- jāizveido aplication.Properties sekojoss lauks:
    // spring.mvc.hiddenmethod.filter.enabled=true
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("labojamaisPerson") Person person, @PathVariable("id") int id) {
        personRepo.save(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        long longId = id;
        personRepo.deleteById(longId);
        return "redirect:/people";
    }

}
