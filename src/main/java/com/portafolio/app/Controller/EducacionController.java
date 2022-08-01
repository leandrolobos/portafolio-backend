package com.portafolio.app.Controller;

import com.portafolio.app.Dto.EducacionDto;
import com.portafolio.app.Entity.Educacion;
import com.portafolio.app.Service.EducacionService;
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
@RequestMapping("educacion")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto) {
        if (StringUtils.isBlank(educacionDto.getCarrer())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(educacionDto.getCarrer(), educacionDto.getUniversity(), educacionDto.getLapse(), educacionDto.getUrl_img());
        educacionService.save(educacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EducacionDto educacionDto) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(educacionDto.getCarrer())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();
        educacion.setCarrer(educacionDto.getCarrer());
        educacion.setUniversity(educacionDto.getUniversity());
        educacion.setLapse(educacionDto.getLapse());
        educacion.setUrl_img(educacionDto.getUrl_img());
        educacionService.save(educacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        educacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
