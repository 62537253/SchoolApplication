package kuzstu.com.Applications.controller;


import kuzstu.com.Applications.model.Card;
import kuzstu.com.Applications.repository.CardRepositoryH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Applications/card")
public class CardController {

    private final CardRepositoryH2 repository;
    @Autowired
    public CardController(CardRepositoryH2 repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Card> readAllClass() {
        return repository.readAll();
    }

    @GetMapping("/{id}")
    public Card readCard(@PathVariable("id") int id) {
        return repository.readCard(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createCard(@RequestBody Card card) {
        repository.createCard(card);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateCard(@RequestBody Card card, @PathVariable("id") int id) {
        repository.updateClass(card, id);
    }

}
