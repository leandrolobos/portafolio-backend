package com.portafolio.app.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carrer;
    private String university;
    private String lapse;
    private String url_img;

// Constructors
    public Educacion() {
    }

    public Educacion(String carrer, String university, String lapse, String url_img) {
        this.carrer = carrer;
        this.university = university;
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

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
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
