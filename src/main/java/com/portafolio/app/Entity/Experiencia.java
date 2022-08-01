package com.portafolio.app.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String company;
    private String lapse;
    private String url_img;

// Constructors
    public Experiencia() {
    }

    public Experiencia(String position, String company, String lapse, String url_img) {
        this.position = position;
        this.company = company;
        this.lapse = lapse;
        this.url_img = url_img;
    }

// Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLapse() {
        return lapse;
    }

    public void setLapse(String lapse) {
        this.lapse = lapse;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

}
