package config;

public class Configuracion {
    private static Configuracion instancia;

    private Configuracion() {
        System.out.println("Configuración inicializada.");
    }

    public static Configuracion getInstance() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }
}
