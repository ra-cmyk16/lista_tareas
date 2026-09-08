package com.example.lista_tareas.service;

import com.example.lista_tareas.model.Tarea;
import com.example.lista_tareas.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }
    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}