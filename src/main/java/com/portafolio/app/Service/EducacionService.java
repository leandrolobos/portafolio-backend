package com.portafolio.app.Service;

import com.portafolio.app.Entity.Educacion;
import com.portafolio.app.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRepository iEducacionRepository;

    public List<Educacion> list() {
        return iEducacionRepository.findAll();
    }

    public Optional<Educacion> getOne(Long id) {
        return iEducacionRepository.findById(id);
    }

    public void save(Educacion edu) {
        iEducacionRepository.save(edu);
    }

    public void delete(Long id) {
        iEducacionRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iEducacionRepository.existsById(id);
    }

}
