package model;

public class Tarea {
    private String titulo;
    private String descripcion;
    private boolean completada;

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public void completar() {
        this.completada = true;
    }

    public boolean isCompletada() {
        return completada;
    }

    @Override
    public String toString() {
        return titulo + (completada ? " (Completada)" : " (Pendiente)");
    }
}
