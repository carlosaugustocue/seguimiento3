import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testCompletarTarea() {
        // Crear gestor de tareas y una tarea
        service.GestorDeTareas gestor = new service.GestorDeTareas();
        model.Tarea tarea = new model.Tarea("Prueba", "Tarea de prueba");
        gestor.agregarTarea(tarea);

        // Completar tarea
        gestor.completarTarea("Prueba");
        assertTrue(tarea.isCompletada());
    }
}
