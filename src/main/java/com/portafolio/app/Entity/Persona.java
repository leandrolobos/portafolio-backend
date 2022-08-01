package com.portafolio.app.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private String ubication;
    private String age;
    private String about;
    private String url_perfil;
    private String url_cover;

// Constructors
    public Persona() {
    }

    public Persona(String name, String position, String ubication, String age, String about, String url_perfil, String url_cover) {
        this.name = name;
        this.position = position;
        this.ubication = ubication;
        this.age = age;
        this.about = about;
        this.url_perfil = url_perfil;
        this.url_cover = url_cover;
    }

// Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUrl_perfil() {
        return url_perfil;
    }

    public void setUrl_perfil(String url_perfil) {
        this.url_perfil = url_perfil;
    }

    public String getUrl_cover() {
        return url_cover;
    }

    public void setUrl_cover(String url_cover) {
        this.url_cover = url_cover;
    }
}
