package factory;

import model.Tarea;

public class TareaFactory {
    public Tarea crearTarea(String tipo, String titulo, String descripcion) {
        if ("simple".equalsIgnoreCase(tipo)) {
            return new Tarea(titulo, descripcion);
        }
        throw new IllegalArgumentException("Tipo de tarea no soportado.");
    }
}
