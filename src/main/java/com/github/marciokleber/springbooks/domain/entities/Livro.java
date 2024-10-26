package com.github.marciokleber.springbooks.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIVRO")
    @SequenceGenerator(name = "SEQ_LIVRO", sequenceName = "SEQ_LIVRO", initialValue = 1)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @Comments(@Comment("TÍTULO DO LIVOR"))
    private String titulo;

    @NotBlank
    @Column(nullable = false)
    @Comments(@Comment("AUTOR DO LIVRO"))
    private String autor;

    @Comments(@Comment("INTERNATION STANDARD BOOK NUMBER"))
    private String isbn;

    @Comments(@Comment("NÚMERO DE PÁGINAS DO LIVRO"))
    private Integer numeroPaginas;

    @Comments(@Comment("EDITORA DO LIVRO"))
    private String editora;

    @Comments(@Comment("DATA DE PUBLICAÇÃO LIVRO"))
    private LocalDate dataPublicacao;

}

