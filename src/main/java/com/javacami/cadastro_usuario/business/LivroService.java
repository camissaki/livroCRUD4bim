package com.javacami.cadastro_usuario.business;

import com.javacami.cadastro_usuario.infrastructure.enttys.Usuario;
import com.javacami.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));
    }

    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuarioEntity.setEmail(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail());
        usuarioEntity.setNome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome());

        repository.saveAndFlush(usuarioEntity);
    }
}