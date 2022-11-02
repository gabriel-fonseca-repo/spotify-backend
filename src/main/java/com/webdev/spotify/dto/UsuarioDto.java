package com.webdev.spotify.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.webdev.spotify.entity.Usuario} entity
 */
@Data
public class UsuarioDto implements Serializable {
    private final Long id;
    private final String email;
    private final String emailConfirm;
    private final String password;
    private final String name;
    private final LocalDate birthdate;
    private final String gender;
    private final Boolean check1;
    private final Boolean check2;

    public UsuarioDto(Long id, String email, String emailConfirm, String password, String name, LocalDate birthdate, String gender, Boolean check1, Boolean check2) {
        this.id = id;
        this.email = email;
        this.emailConfirm = emailConfirm;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.check1 = check1;
        this.check2 = check2;
    }

    public UsuarioDto() {
        this.id = null;
        this.email = null;
        this.emailConfirm = null;
        this.password = null;
        this.name = null;
        this.birthdate = null;
        this.gender = null;
        this.check1 = null;
        this.check2 = null;
    }

}