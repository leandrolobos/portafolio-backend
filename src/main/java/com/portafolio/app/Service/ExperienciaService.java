package com.portafolio.app.Service;

import com.portafolio.app.Entity.Experiencia;
import com.portafolio.app.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    IExperienciaRepository iExperienciaRepository;

    public List<Experiencia> list() {
        return iExperienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(Long id) {
        return iExperienciaRepository.findById(id);
    }

    public void save(Experiencia exp) {
        iExperienciaRepository.save(exp);
    }

    public void delete(Long id) {
        iExperienciaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iExperienciaRepository.existsById(id);
    }

}
