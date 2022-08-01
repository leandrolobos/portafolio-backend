package com.portafolio.app.Controller;

import com.portafolio.app.Dto.PersonaDto;
import com.portafolio.app.Entity.Persona;
import com.portafolio.app.Service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PersonaDto personaDto) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(personaDto.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        persona.setName(personaDto.getName());
        persona.setPosition(personaDto.getPosition());
        persona.setUbication(personaDto.getUbication());
        persona.setAge(personaDto.getAge());
        persona.setAbout(personaDto.getAbout());
        persona.setUrl_perfil(personaDto.getUrl_perfil());
        persona.setUrl_cover(personaDto.getUrl_cover());
        personaService.save(persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
