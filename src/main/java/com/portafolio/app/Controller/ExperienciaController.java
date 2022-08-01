package com.portafolio.app.Controller;

import com.portafolio.app.Dto.ExperienciaDto;
import com.portafolio.app.Entity.Experiencia;
import com.portafolio.app.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencias")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto) {
        if (StringUtils.isBlank(experienciaDto.getPosition())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(experienciaDto.getPosition(), experienciaDto.getCompany(), experienciaDto.getLapse(), experienciaDto.getUrl_img());
        experienciaService.save(experiencia);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienciaDto experienciaDto) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(experienciaDto.getPosition())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setPosition(experienciaDto.getPosition());
        experiencia.setCompany(experienciaDto.getCompany());
        experiencia.setLapse(experienciaDto.getLapse());
        experiencia.setUrl_img(experienciaDto.getUrl_img());
        experienciaService.save(experiencia);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        experienciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
