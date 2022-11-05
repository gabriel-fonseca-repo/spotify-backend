package com.webdev.spotify.controller;

import com.webdev.spotify.entity.Playlist;
import com.webdev.spotify.repository.MusicaRepository;
import com.webdev.spotify.repository.PlaylistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlist")
@CrossOrigin(originPatterns = "*localhost*")
public class PlaylistController {

    private final PlaylistRepository playlistRepository;

    private final MusicaRepository musicaRepository;

    public PlaylistController(PlaylistRepository playlistRepository, MusicaRepository musicaRepository) {
        this.playlistRepository = playlistRepository;
        this.musicaRepository = musicaRepository;
    }

    @GetMapping("/pegar/")
    @CrossOrigin(originPatterns = "*localhost*")
    public List<Playlist> getPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        for (Playlist playlist : this.playlistRepository.findAll()) {
            playlists.add(playlist);
        }
        return playlists;
    }

    @GetMapping("/usuario/{idusuario}/")
    @CrossOrigin(originPatterns = "*localhost*")
    public List<Playlist> getPlaylistsUsuario(@PathVariable("idusuario") Long idusuario) {
        return this.playlistRepository.findByUser_Id(idusuario);
    }

    @GetMapping("/consultar/{idplaylist}/")
    @CrossOrigin(originPatterns = "*localhost*")
    public Playlist getPlaylist(@PathVariable("idplaylist") Long idplaylist) {
        return this.playlistRepository.findById(idplaylist).get();
    }

    @PostMapping("/cadastrar/")
    @CrossOrigin(originPatterns = "*localhost*")
    public void cadastrarPlaylist(@RequestBody Playlist playlist) {
        this.playlistRepository.save(playlist);
    }

    @PatchMapping("/alterar/{idplaylist}/")
    @CrossOrigin(originPatterns = "*localhost*")
    public void alterarPlaylist(@RequestBody Playlist playlist, @PathVariable Long idplaylist) {
        this.playlistRepository.save(playlist);
    }

}
