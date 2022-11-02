package com.webdev.spotify.dto;

import com.webdev.spotify.entity.Musica;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.webdev.spotify.entity.Playlist} entity
 */
@Data
public class PlaylistDto implements Serializable {
    private final Long id;
    private final String src;
    private final String alt;
    private final String title;
    private final String detail;
    private final List<MusicaDto> musicas;

    public PlaylistDto(Long id, String src, String alt, String title, String detail, List<MusicaDto> musicas) {
        this.id = id;
        this.src = src;
        this.alt = alt;
        this.title = title;
        this.detail = detail;
        this.musicas = musicas;
    }

    public PlaylistDto(Long id, String src, String alt, String title, String detail) {
        this.id = id;
        this.src = src;
        this.alt = alt;
        this.title = title;
        this.detail = detail;
        this.musicas = null;
    }
}