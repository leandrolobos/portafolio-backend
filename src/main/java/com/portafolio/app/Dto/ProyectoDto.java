package com.portafolio.app.Dto;

import javax.validation.constraints.NotBlank;

public class ProyectoDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String lapse;
    @NotBlank
    private String url_img;
    @NotBlank
    private String link_proyecto;

// Constructors
    public ProyectoDto() {
    }

    public ProyectoDto(String title, String description, String lapse, String url_img, String link_proyecto) {
        this.title = title;
        this.description = description;
        this.lapse = lapse;
        this.url_img = url_img;
        this.link_proyecto = link_proyecto;
    }

// Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLink_proyecto() {
        return link_proyecto;
    }

    public void setLink_proyecto(String link_proyecto) {
        this.link_proyecto = link_proyecto;
    }

}
