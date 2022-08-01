package com.portafolio.app.Service;

import com.portafolio.app.Entity.Curso;
import com.portafolio.app.Repository.ICursoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CursoService {

    @Autowired
    ICursoRepository iCursoRepository;

    public List<Curso> list() {
        return iCursoRepository.findAll();
    }

    public Optional<Curso> getOne(Long id) {
        return iCursoRepository.findById(id);
    }

    public void save(Curso curso) {
        iCursoRepository.save(curso);
    }

    public void delete(Long id) {
        iCursoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iCursoRepository.existsById(id);
    }

}
