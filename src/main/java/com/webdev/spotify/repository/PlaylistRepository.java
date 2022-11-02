package com.webdev.spotify.repository;

import com.webdev.spotify.entity.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    List<Playlist> findByCategoria_Id(@NonNull Long id);

}