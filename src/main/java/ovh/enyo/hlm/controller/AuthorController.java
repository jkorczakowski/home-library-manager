package ovh.enyo.hlm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ovh.enyo.hlm.model.Author;
import ovh.enyo.hlm.repository.AuthorRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class AuthorController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/authors")
    ResponseEntity<Author> createAuthor(@RequestBody @Valid Author toCreate) {
        Author result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping(value = "/authors", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Author>> readAllAuthors() {
        logger.warn("Exposing all the authors!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/authors")
    ResponseEntity<List<Author>> readAllAuthors(Pageable page) {
        logger.info("Custom pageable!");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @GetMapping("/authors/{id}")
    ResponseEntity<Author> readAuthorById(@PathVariable int id) {
        return repository.findById(id)
                .map(author -> ResponseEntity.ok(author))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/authors/{id}")
    ResponseEntity<?> updateAuthor(@PathVariable int id, @RequestBody @Valid Author toUpdate) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();

        }
        repository.findById(id)
                .ifPresent(author -> {
                    author.updateFrom(toUpdate);
                    repository.save(author);
                });
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/authors/{id}")
    public ResponseEntity<?> toggleAuthor(@PathVariable int id) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(author -> author.setCreated(!author.isCreated()));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/authors/{id}")
    ResponseEntity<Author> deleteAuthorById(@PathVariable int id) {
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
