package com.portafolio.app.Dto;

import javax.validation.constraints.NotBlank;

public class EducacionDto {

    @NotBlank
    private String carrer;
    @NotBlank
    private String university;
    @NotBlank
    private String lapse;
    @NotBlank
    private String url_img;

// Constructors
    public EducacionDto() {
    }

    public EducacionDto(String carrer, String university, String lapse, String url_img) {
        this.carrer = carrer;
        this.university = university;
        this.lapse = lapse;
        this.url_img = url_img;
    }

// Getters and setters
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
