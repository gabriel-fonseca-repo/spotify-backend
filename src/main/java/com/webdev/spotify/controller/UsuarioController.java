package com.webdev.spotify.controller;

import com.webdev.spotify.dto.UsuarioDto;
import com.webdev.spotify.entity.Usuario;
import com.webdev.spotify.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/users/{email}")
    @CrossOrigin(originPatterns = "*localhost*")
    public UsuarioDto isUsuarioCadastrado(@PathVariable("email") String email) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmailIgnoreCase(email);
        UsuarioDto usuarioDto;
        Usuario usuario;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.get();
            usuarioDto = new UsuarioDto(usuario.getId(), usuario.getEmail(), usuario.getEmailConfirm(), usuario.getPassword(), usuario.getName(), usuario.getBirthdate(), usuario.getGender(), usuario.getCheck1(), usuario.getCheck2());
        } else {
            usuarioDto = new UsuarioDto();
        }
        return usuarioDto;
    }
}
