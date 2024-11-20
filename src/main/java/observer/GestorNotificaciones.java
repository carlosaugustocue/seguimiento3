package observer;

import java.util.ArrayList;
import java.util.List;

public class GestorNotificaciones {
    private List<Observador> observadores = new ArrayList<>();

    public void registrar(Observador obs) {
        observadores.add(obs);
    }

    public void notificar(String mensaje) {
        observadores.forEach(obs -> obs.actualizar(mensaje));
    }
}
