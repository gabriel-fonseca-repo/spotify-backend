package com.webdev.spotify.controller;

import com.webdev.spotify.dto.MusicaDto;
import com.webdev.spotify.dto.PlaylistDto;
import com.webdev.spotify.entity.Musica;
import com.webdev.spotify.entity.Playlist;
import com.webdev.spotify.repository.MusicaRepository;
import com.webdev.spotify.repository.PlaylistRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaylistController {

    private final PlaylistRepository playlistRepository;

    private final MusicaRepository musicaRepository;

    public PlaylistController(PlaylistRepository playlistRepository, MusicaRepository musicaRepository) {
        this.playlistRepository = playlistRepository;
        this.musicaRepository = musicaRepository;
    }

    @GetMapping("/playlists")
    public List<Playlist> getPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        for (Playlist playlist : this.playlistRepository.findAll()) {
            playlists.add(playlist);
        }
        return playlists;
    }

    @GetMapping("/playlist/{idplaylist}")
    @CrossOrigin(originPatterns = "*localhost*")
    public PlaylistDto getPlaylist(@PathVariable("idplaylist") Long idplaylist) {
        List<Musica> musicas = this.musicaRepository.findByPlaylist_Id(idplaylist);
        Playlist playlist = this.playlistRepository.findById(idplaylist).get();

        List<MusicaDto> musicasDto = new ArrayList<>();
        musicas.forEach(e -> {
            musicasDto.add(new MusicaDto(e.getId(), e.getNomeMusica(), e.getDuracao(), e.getNomeArtista(), e.getSrc()));
        });
        return new PlaylistDto(playlist.getId(), playlist.getSrc(), playlist.getAlt(), playlist.getTitle(), playlist.getDetail(), musicasDto);
    }

}
