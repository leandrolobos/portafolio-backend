package com.portafolio.app.Controller;

import com.portafolio.app.Dto.HabilidadDto;
import com.portafolio.app.Entity.Habilidad;
import com.portafolio.app.Service.HabilidadService;
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
@RequestMapping("habilidades")
public class HabilidadController {

    @Autowired
    HabilidadService habilidadService;

    @GetMapping("/listar")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = habilidadService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") Long id) {
        if (!habilidadService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Habilidad habilidad = habilidadService.getOne(id).get();
        return new ResponseEntity<>(habilidad, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody HabilidadDto habilidadDto) {
        if (StringUtils.isBlank(habilidadDto.getSkill())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = new Habilidad(habilidadDto.getSkill(), habilidadDto.getDescription(), habilidadDto.getUrl_img());
        habilidadService.save(habilidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody HabilidadDto habilidadDto) {
        if (!habilidadService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(habilidadDto.getSkill())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Habilidad habilidad = habilidadService.getOne(id).get();
        habilidad.setSkill(habilidadDto.getSkill());
        habilidad.setDescription(habilidadDto.getDescription());
        habilidad.setUrl_img(habilidadDto.getUrl_img());
        habilidadService.save(habilidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!habilidadService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        habilidadService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
