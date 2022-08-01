package com.portafolio.app.Service;

import com.portafolio.app.Entity.Habilidad;
import com.portafolio.app.Repository.IHabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadService {

    @Autowired
    IHabilidadRepository iHabilidadRepository;

    public List<Habilidad> list() {
        return iHabilidadRepository.findAll();
    }

    public Optional<Habilidad> getOne(Long id) {
        return iHabilidadRepository.findById(id);
    }

    public void save(Habilidad skill) {
        iHabilidadRepository.save(skill);
    }

    public void delete(Long id) {
        iHabilidadRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iHabilidadRepository.existsById(id);
    }

}
