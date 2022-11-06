package com.webdev.spotify.controller;

import com.webdev.spotify.entity.Playlist;
import com.webdev.spotify.repository.PlaylistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlist")
@CrossOrigin
public class PlaylistController {

    private final PlaylistRepository playlistRepository;

    public PlaylistController(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @GetMapping("/pegar/")
    public List<Playlist> getPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        for (Playlist playlist : this.playlistRepository.findAll()) {
            playlists.add(playlist);
        }
        return playlists;
    }

    @GetMapping("/usuario/{idusuario}/")
    public List<Playlist> getPlaylistsUsuario(@PathVariable("idusuario") Long idusuario) {
        return this.playlistRepository.findByUser_Id(idusuario);
    }

    @GetMapping("/consultar/{idplaylist}/")
    public Playlist getPlaylist(@PathVariable("idplaylist") Long idplaylist) {
        return this.playlistRepository.findById(idplaylist).get();
    }

    @PostMapping("/cadastrar/")
    public void cadastrarPlaylist(@RequestBody Playlist playlist) {
        this.playlistRepository.save(playlist);
    }

    @PatchMapping("/alterar/{idplaylist}/")
    public void alterarPlaylist(@RequestBody Playlist playlist, @PathVariable Long idplaylist) {
        this.playlistRepository.save(playlist);
    }

}
