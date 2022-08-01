package com.portafolio.app.Controller;

import com.portafolio.app.Dto.CursoDto;
import com.portafolio.app.Entity.Curso;
import com.portafolio.app.Service.CursoService;
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
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> list() {
        List<Curso> list = cursoService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") Long id) {
        if (!cursoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Curso curso = cursoService.getOne(id).get();
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody CursoDto cursoDto) {
        if (StringUtils.isBlank(cursoDto.getCourse())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Curso curso = new Curso(cursoDto.getCourse(), cursoDto.getInstitution(), cursoDto.getLapse(), cursoDto.getUrl_img());
        cursoService.save(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CursoDto cursoDto) {
        if (!cursoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(cursoDto.getCourse())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Curso curso = cursoService.getOne(id).get();
        curso.setCourse(cursoDto.getCourse());
        curso.setInstitution(cursoDto.getInstitution());
        curso.setLapse(cursoDto.getLapse());
        curso.setUrl_img(cursoDto.getUrl_img());
        cursoService.save(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!cursoService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
