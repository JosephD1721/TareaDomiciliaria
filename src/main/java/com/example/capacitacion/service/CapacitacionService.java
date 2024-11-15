package com.example.capacitacion.service;

import com.example.capacitacion.model.Capacitacion;

import java.util.List;

public interface CapacitacionService {
    List<Capacitacion> listarCapacitacion();
    void guardarCapacitacion(Capacitacion capacitacion);
    Capacitacion obtenerCapacitacionPorId(Integer id);
    void eliminarCapacitacion(Integer id);
}
