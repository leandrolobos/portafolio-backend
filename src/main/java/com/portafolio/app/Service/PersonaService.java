package com.portafolio.app.Service;

import com.portafolio.app.Entity.Persona;
import com.portafolio.app.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {

    @Autowired
    IPersonaRepository iPersonaRepository;

    public List<Persona> list() {
        return iPersonaRepository.findAll();
    }

    public Optional<Persona> getOne(Long id) {
        return iPersonaRepository.findById(id);
    }

    public void save(Persona persona) {
        iPersonaRepository.save(persona);
    }

    public void delete(Long id) {
        iPersonaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iPersonaRepository.existsById(id);
    }

}
