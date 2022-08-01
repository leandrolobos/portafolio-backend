package com.portafolio.app.Service;

import com.portafolio.app.Entity.Proyecto;
import com.portafolio.app.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {

    @Autowired
    IProyectoRepository iProyectoRepository;

    public List<Proyecto> list() {
        return iProyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(Long id) {
        return iProyectoRepository.findById(id);
    }

    public void save(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    public void delete(Long id) {
        iProyectoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iProyectoRepository.existsById(id);
    }

}
