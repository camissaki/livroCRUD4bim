package com.javacami.cadastro_usuario.infrastructure.repository;



import com.javacami.cadastro_usuario.infrastructure.enttys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Transactional
    void  deleteByEmail(String email);
}