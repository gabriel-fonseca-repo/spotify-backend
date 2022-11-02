package com.webdev.spotify.dto;

import com.webdev.spotify.entity.Playlist;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.webdev.spotify.entity.Categoria} entity
 */
@Data
public class CategoriaDto implements Serializable {
    private final Long id;
    private final String nome;
    private final List<PlaylistDto> playlists;
}