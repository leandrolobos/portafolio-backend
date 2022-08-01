package com.portafolio.app.Controller;

import com.portafolio.app.Dto.ProyectoDto;
import com.portafolio.app.Entity.Proyecto;
import com.portafolio.app.Service.ProyectoService;
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
@RequestMapping("proyectos")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto) {
        if (StringUtils.isBlank(proyectoDto.getTitle())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(proyectoDto.getTitle(), proyectoDto.getDescription(), proyectoDto.getLapse(), proyectoDto.getUrl_img(), proyectoDto.getLink_proyecto());
        proyectoService.save(proyecto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProyectoDto proyectoDto) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(proyectoDto.getTitle())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setTitle(proyectoDto.getTitle());
        proyecto.setDescription(proyectoDto.getDescription());
        proyecto.setLapse(proyectoDto.getLapse());
        proyecto.setUrl_img(proyectoDto.getUrl_img());
        proyecto.setLink_proyecto(proyectoDto.getLink_proyecto());
        proyectoService.save(proyecto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        proyectoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
