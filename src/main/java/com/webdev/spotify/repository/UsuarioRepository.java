package com.webdev.spotify.repository;

import com.webdev.spotify.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmailIgnoreCase(String email);

}