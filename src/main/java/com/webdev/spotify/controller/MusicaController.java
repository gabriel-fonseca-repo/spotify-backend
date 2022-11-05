package com.webdev.spotify.controller;

import com.webdev.spotify.entity.Musica;
import com.webdev.spotify.repository.MusicaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musicas")
@CrossOrigin(originPatterns = "*localhost*")
public class MusicaController {

    private final MusicaRepository musicaRepository;

    public MusicaController(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    @GetMapping("/")
    @CrossOrigin(originPatterns = "*localhost*")
    public List<Musica> getMusicas() {
        return this.musicaRepository.findAll();
    }

}
