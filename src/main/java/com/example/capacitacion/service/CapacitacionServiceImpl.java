package com.example.capacitacion.service;

import com.example.capacitacion.model.Capacitacion;
import com.example.capacitacion.repository.CapacitacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CapacitacionServiceImpl implements CapacitacionService {
    private final CapacitacionRepository capacitacionRepository;

    @Override
    public List<Capacitacion> listarCapacitacion() {
        return capacitacionRepository.findAll();
    }

    @Override
    public void guardarCapacitacion(Capacitacion capacitacion) {
        capacitacionRepository.save(capacitacion);
    }

    @Override
    public Capacitacion obtenerCapacitacionPorId(Integer id) {
        return capacitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Capacitacion no encontrada para el id: " + id));
    }

    @Override
    public void eliminarCapacitacion(Integer id) {
        if (capacitacionRepository.existsById(id)) {
            capacitacionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Capacitacion no encontrada para el id: " + id);
        }
    }
}
