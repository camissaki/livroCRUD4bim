package com.javacami.cadastro_usuario.controller;

import com.javacami.cadastro_usuario.business.LivroService;
import com.javacami.cadastro_usuario.infrastructure.enttys.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Void> salvarLivro(@RequestBody Livro livro) {
        livroService.salvarLivro(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Livro> buscarLivroPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(livroService.buscarLivroPorTitulo(titulo));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Livro>> buscarTodosLivros() {
        return ResponseEntity.ok(livroService.buscarTodosLivros());
    }

    @GetMapping("/autor")
    public ResponseEntity<List<Livro>> buscarLivrosPorAutor(@RequestParam String autor) {
        return ResponseEntity.ok(livroService.buscarLivrosPorAutor(autor));
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Livro>> buscarLivrosPorGenero(@RequestParam String genero) {
        return ResponseEntity.ok(livroService.buscarLivrosPorGenero(genero));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivroPorId(@PathVariable Integer id) {
        livroService.deletarLivroPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarLivroPorId(
            @PathVariable Integer id,
            @RequestBody Livro livro) {
        livroService.atualizarLivroPorId(id, livro);
        return ResponseEntity.ok().build();
    }
}