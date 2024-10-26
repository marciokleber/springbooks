package com.github.marciokleber.springbooks.repository.specification;

import com.github.marciokleber.springbooks.domain.entities.Livro;
import org.springframework.data.jpa.domain.Specification;

public abstract class LivroSpecification {

    public static Specification<Livro> byStatus(String status){
        return (root, query,cb) -> cb.equal(root.get("status"), status);
    }
}
