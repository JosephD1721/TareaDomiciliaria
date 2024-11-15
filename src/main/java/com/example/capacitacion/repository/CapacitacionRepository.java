package com.example.capacitacion.repository;

import com.example.capacitacion.model.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer> {
}
