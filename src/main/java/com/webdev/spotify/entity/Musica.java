package com.webdev.spotify.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "musica")
@Setter
@Getter
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nomeMusica;

    private String duracao;

    private String nomeArtista;

    private String src;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;


}