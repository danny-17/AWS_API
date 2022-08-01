package com.example.springboots3.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="users")
@Data
@NoArgsConstructor


public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String password;
    private String email;
    @Transient
    private  String imagenUrl;
    @Transient
    private  String cedulaUrl;
}
