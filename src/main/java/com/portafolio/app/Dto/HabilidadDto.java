package com.portafolio.app.Dto;

import javax.validation.constraints.NotBlank;

public class HabilidadDto {

    @NotBlank
    private String skill;
    @NotBlank
    private String description;
    @NotBlank
    private String url_img;

// Constructors
    public HabilidadDto() {
    }

    public HabilidadDto(String skill, String description, String url_img) {
        this.skill = skill;
        this.description = description;
        this.url_img = url_img;
    }

// Getters and setters
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

}
