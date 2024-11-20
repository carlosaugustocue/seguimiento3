package service;

import model.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDeTareas {
    private List<Tarea> tareas;

    public GestorDeTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public List<Tarea> listarPendientes() {
        return tareas.stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    public void completarTarea(String titulo) {
        tareas.stream()
                .filter(t -> t.toString().contains(titulo))
                .findFirst()
                .ifPresent(Tarea::completar);
    }
}
