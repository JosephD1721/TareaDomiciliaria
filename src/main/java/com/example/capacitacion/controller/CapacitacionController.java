package com.example.capacitacion.controller;

import com.example.capacitacion.model.Capacitacion;
import com.example.capacitacion.service.CapacitacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/capacitacion")
@AllArgsConstructor
public class CapacitacionController {
    private final CapacitacionService capacitacionService;

    @GetMapping("/listarCapacitacion")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listarCapacitacion", capacitacionService.listarCapacitacion());
        return "capacitacion/capacitacion";
    }

    @GetMapping("/nuevoCapacitacion")
    public String nuevoCapacitacion(Model model) {
        model.addAttribute("capacitacion", new Capacitacion());
        return "capacitacion/nuevoCapacitacion";
    }

    @PostMapping("/guardarCapacitacion")
    public String guardarCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion) {
        capacitacionService.guardarCapacitacion(capacitacion);
        return "redirect:/capacitacion/listarCapacitacion";
    }

    @GetMapping("/actualizarCapacitacion/{id}")
    public String actualizarCapacitacion(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("capacitacion", capacitacionService.obtenerCapacitacionPorId(id));
        return "capacitacion/actualizarCapacitacion";
    }

    @GetMapping("/eliminarCapacitacion/{id}")
    public String eliminarCapacitacion(@PathVariable("id") Integer id) {
        capacitacionService.eliminarCapacitacion(id);
        return "redirect:/capacitacion/listarCapacitacion";
    }
}
