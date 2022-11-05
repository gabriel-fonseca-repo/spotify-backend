package com.webdev.spotify.repository;

import com.webdev.spotify.entity.Musica;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusicaRepository extends CrudRepository<Musica, Long> {
    @Override
    List<Musica> findAll();
}