package com.webdev.spotify.controller;

import com.webdev.spotify.dto.EmailTakenDto;
import com.webdev.spotify.dto.LoginDto;
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

    @GetMapping("/users/{email}/")
    @CrossOrigin(originPatterns = "*localhost*")
    public EmailTakenDto checarEmailJaCadastrado(@PathVariable String email) {
        EmailTakenDto emailTakenDto = new EmailTakenDto();
        emailTakenDto.setTaken(usuarioRepository.countByEmailIgnoreCase(email) > 0);
        return emailTakenDto;
    }

    @PostMapping("/users/{idusuario}")
    @CrossOrigin(originPatterns = "*localhost*")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario, @PathVariable Long idusuario) {
        return this.usuarioRepository.save(usuario);
    }

    @PatchMapping("/users/{idusuario}")
    @CrossOrigin(originPatterns = "*localhost*")
    public Usuario alterarUsuario(@RequestBody Usuario usuario, @PathVariable Long idusuario) {
        return this.usuarioRepository.save(usuario);
    }

    @PostMapping("/users/validate/")
    @CrossOrigin(originPatterns = "*localhost*")
    public UsuarioDto validarLogin(@RequestBody LoginDto loginDto) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmailIgnoreCase(loginDto.getEmail());
        UsuarioDto usuarioDto = null;
        Usuario usuario;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.get();
            if (loginDto.getPassword().equals(usuario.getPassword())) {
                return new UsuarioDto(usuario.getId(), usuario.getEmail(), usuario.getEmailConfirm(), usuario.getPassword(), usuario.getName(), usuario.getBirthdate(), usuario.getGender(), usuario.getCheck1(), usuario.getCheck2(), true);
            } else {
                return new UsuarioDto(false);
            }
        }
        return new UsuarioDto();
    }
}
