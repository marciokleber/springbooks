package com.github.marciokleber.springbooks.controller;


import com.github.marciokleber.springbooks.domain.entities.Livro;
import com.github.marciokleber.springbooks.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@AllArgsConstructor
public class LivroController {

    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @PostMapping
    public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @Valid @RequestBody Livro updateLivro) {
        return livroRepository.findById(id)
                .map(livro -> ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(updateLivro)))
                .orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        livroRepository.findById(id).ifPresentOrElse(
                livro -> livroRepository.deleteById(id),
                () -> {
                    throw new EntityNotFoundException();
                }
        );
    }
}
