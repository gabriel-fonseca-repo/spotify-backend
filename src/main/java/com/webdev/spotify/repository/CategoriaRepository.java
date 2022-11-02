package com.webdev.spotify.repository;

import com.webdev.spotify.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    @Override
    List<Categoria> findAll();
}