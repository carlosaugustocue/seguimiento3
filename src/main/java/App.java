import factory.TareaFactory;
import model.Tarea;
import observer.GestorNotificaciones;
import observer.Usuario;
import service.GestorDeTareas;

public class App {
    public static void main(String[] args) {
        // Inicializar Configuración
        config.Configuracion.getInstance();

        // Crear Gestor de Tareas y Notificaciones
        GestorDeTareas gestor = new GestorDeTareas();
        GestorNotificaciones notificador = new GestorNotificaciones();

        // Registrar Usuarios
        notificador.registrar(new Usuario("Carlos"));
        notificador.registrar(new Usuario("Juliana"));

        // Crear Tareas
        TareaFactory factory = new TareaFactory();
        Tarea tarea1 = factory.crearTarea("simple", "Comprar comida", "Ir al supermercado");
        Tarea tarea2 = factory.crearTarea("simple", "Estudiar Java", "Repasar patrones de diseño");

        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);

        // Listar Tareas Pendientes
        System.out.println("Tareas pendientes:");
        gestor.listarPendientes().forEach(System.out::println);

        // Completar una tarea y notificar
        gestor.completarTarea("Comprar comida");
        notificador.notificar("Tarea 'Comprar comida' completada.");

        // Listar nuevamente
        System.out.println("\nTareas pendientes:");
        gestor.listarPendientes().forEach(System.out::println);
    }
}
