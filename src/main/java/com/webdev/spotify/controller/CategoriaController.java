package com.webdev.spotify.controller;

import com.webdev.spotify.dto.CategoriaDto;
import com.webdev.spotify.dto.PlaylistDto;
import com.webdev.spotify.entity.Categoria;
import com.webdev.spotify.entity.Playlist;
import com.webdev.spotify.repository.CategoriaRepository;
import com.webdev.spotify.repository.PlaylistRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    private final PlaylistRepository playlistRepository;

    public CategoriaController(CategoriaRepository categoriaRepository, PlaylistRepository playlistRepository) {
        this.categoriaRepository = categoriaRepository;
        this.playlistRepository = playlistRepository;
    }

    @GetMapping("/categorias")
    @CrossOrigin(originPatterns = "*localhost*")
    public List<CategoriaDto> getCategorias() {
        List<CategoriaDto> categoriasResponse = new ArrayList<>();
        List<Categoria> categorias = this.categoriaRepository.findAll();
        for (Categoria categoria : categorias) {
            List<Playlist> playlists = this.playlistRepository.findByCategoria_Id(categoria.getId());
            List<PlaylistDto> playlistDtoList = new ArrayList<>();
            for (Playlist playlist : playlists) {
                PlaylistDto playlistDto = new PlaylistDto(
                        playlist.getId(),
                        playlist.getSrc(),
                        playlist.getAlt(),
                        playlist.getTitle(),
                        playlist.getDetail()
                );
                playlistDtoList.add(playlistDto);
            }
            CategoriaDto categoriaDto = new CategoriaDto(categoria.getId(), categoria.getNome(), playlistDtoList);
            categoriasResponse.add(categoriaDto);
        }
        return categoriasResponse;
    }

}
