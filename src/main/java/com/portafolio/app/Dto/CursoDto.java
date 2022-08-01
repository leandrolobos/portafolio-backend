package com.portafolio.app.Dto;

import javax.validation.constraints.NotBlank;

public class CursoDto {

    @NotBlank
    private String course;
    @NotBlank
    private String institution;
    @NotBlank
    private String lapse;
    @NotBlank
    private String url_img;

// Constructors
    public CursoDto() {
    }

    public CursoDto(String course, String institution, String lapse, String url_img) {
        this.course = course;
        this.institution = institution;
        this.lapse = lapse;
        this.url_img = url_img;
    }

// Getters and setters
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
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
