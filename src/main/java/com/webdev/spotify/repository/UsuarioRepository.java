package com.webdev.spotify.repository;

import com.webdev.spotify.entity.Usuario;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmailIgnoreCase(String email);

    long countByEmailIgnoreCase(String email);

}