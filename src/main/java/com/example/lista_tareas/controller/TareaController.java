package com.example.lista_tareas.controller;

import com.example.lista_tareas.model.Tarea;
import com.example.lista_tareas.service.TareaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/tareas")
    public String mostrarTareas(Model model) {

        List<Tarea> tareas = tareaService.listarTareas();

        model.addAttribute("tareas", tareas);
        model.addAttribute("tarea", new Tarea());

        return "tareas";
    }
 @PostMapping("/tareas/guardar")
public String guardarTarea(
        @Valid Tarea tarea,
        BindingResult resultado,
        Model model) {

    if (resultado.hasErrors()) {

        model.addAttribute("tareas", tareaService.listarTareas());

        return "tareas";
    }

    tareaService.guardarTarea(tarea);

    return "redirect:/tareas";
}
    @GetMapping("/tareas/eliminar/{id}")
public String eliminarTarea(@PathVariable Long id) {

    tareaService.eliminarTarea(id);

    return "redirect:/tareas";
}
    @GetMapping("/tareas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
 
     Tarea tarea = tareaService.obtenerTareaPorId(id);
 
     model.addAttribute("tarea", tarea);

     return "editar-tarea";
    }
}