package com.webdev.spotify.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.webdev.spotify.entity.Musica} entity
 */
@Data
public class MusicaDto implements Serializable {
    private final Long id;
    private final String nomeMusica;
    private final String duracao;
    private final String nomeArtista;
    private final String src;
}