package com.webdev.spotify.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;

    private String emailConfirm;

    private String password;

    private String name;

    private LocalDate birthdate;

    private String gender;

    private Boolean check1;

    private Boolean check2;

}