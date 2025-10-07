package com.javacami.cadastro_usuario.business;

import com.javacami.cadastro_usuario.infrastructure.enttys.Livro;
import com.javacami.cadastro_usuario.infrastructure.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public void salvarLivro(Livro livro) {
        repository.saveAndFlush(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return repository.findByTitulo(titulo)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public List<Livro> buscarTodosLivros() {
        return repository.findAll();
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        return repository.findByAutorContainingIgnoreCase(autor);
    }

    public List<Livro> buscarLivrosPorGenero(String genero) {
        return repository.findByGeneroContainingIgnoreCase(genero);
    }


    public void deletarLivroPorId(Integer id) {
        repository.deleteById(id);
    }

    public void atualizarLivroPorId(Integer id, Livro livro) {
        Livro livroEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livroEntity.setTitulo(livro.getTitulo() != null ? livro.getTitulo() : livroEntity.getTitulo());
        livroEntity.setAutor(livro.getAutor() != null ? livro.getAutor() : livroEntity.getAutor());
        livroEntity.setIsbn(livro.getIsbn() != null ? livro.getIsbn() : livroEntity.getIsbn());
        livroEntity.setAnoPublicacao(livro.getAnoPublicacao() != null ? livro.getAnoPublicacao() : livroEntity.getAnoPublicacao());
        livroEntity.setGenero(livro.getGenero() != null ? livro.getGenero() : livroEntity.getGenero());
        livroEntity.setEditora(livro.getEditora() != null ? livro.getEditora() : livroEntity.getEditora());
        livroEntity.setDescricao(livro.getDescricao() != null ? livro.getDescricao() : livroEntity.getDescricao());

        repository.saveAndFlush(livroEntity);
    }
}
