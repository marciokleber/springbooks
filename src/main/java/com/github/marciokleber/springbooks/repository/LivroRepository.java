package com.github.marciokleber.springbooks.repository;

import com.github.marciokleber.springbooks.domain.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> { }
