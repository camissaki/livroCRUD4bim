package com.javacami.cadastro_usuario.infrastructure.repository;

import com.javacami.cadastro_usuario.infrastructure.enttys.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    Optional<Livro> findByTitulo(String titulo);


    List<Livro> findByAutorContainingIgnoreCase(String autor);

    List<Livro> findByGeneroContainingIgnoreCase(String genero);
}
