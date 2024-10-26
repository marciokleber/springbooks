package com.github.marciokleber.springbooks.repository;

import com.github.marciokleber.springbooks.domain.entities.Livro;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LivroRepository extends JpaRepository<Livro, Long>, JpaSpecificationExecutor<Livro> {


}
