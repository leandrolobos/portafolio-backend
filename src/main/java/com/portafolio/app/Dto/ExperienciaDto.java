package com.portafolio.app.Dto;

import javax.validation.constraints.NotBlank;

public class ExperienciaDto {

    @NotBlank
    private String position;
    @NotBlank
    private String company;
    @NotBlank
    private String lapse;
    @NotBlank
    private String url_img;

// Constructors
    public ExperienciaDto() {
    }

    public ExperienciaDto(String position, String company, String lapse, String url_img) {
        this.position = position;
        this.company = company;
        this.lapse = lapse;
        this.url_img = url_img;
    }

// Getters and setters
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
