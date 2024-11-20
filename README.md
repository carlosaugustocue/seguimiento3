
# Gestor de Tareas

Este proyecto es una aplicación básica en Java para gestionar tareas. Implementa conceptos de programación moderna como principios SOLID, programación funcional con Streams, y patrones de diseño.

## **Características del Proyecto**
- Gestión de tareas con creación, listado y marcación como completadas.
- Notificaciones a usuarios sobre cambios en el estado de las tareas.
- Uso de principios de código limpio para facilitar mantenimiento y escalabilidad.
- Implementación de patrones de diseño (Singleton, Factory y Observer).
- Procesamiento funcional de colecciones utilizando Streams.

---

## **Estructura del Proyecto**

El proyecto sigue una estructura modular organizada en paquetes para garantizar claridad y separación de responsabilidades.

```
GestorDeTareas/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── config/              // Configuración global (Singleton)
│   │   │   ├── factory/             // Creación de tareas (Factory)
│   │   │   ├── model/               // Modelo de datos (Clase Tarea)
│   │   │   ├── observer/            // Sistema de notificaciones (Observer)
│   │   │   ├── service/             // Lógica de negocio (Gestor de Tareas)
│   │   │   └── App.java             // Punto de entrada de la aplicación
│   └── test/
│       └── java/                    // Pruebas unitarias
└── pom.xml                          // Configuración Maven
```

---

## **Elementos de Programación Utilizados**

### **1. Principios SOLID**
- **Responsabilidad Única (SRP):** Cada clase tiene una única responsabilidad.
    - `GestorDeTareas` gestiona la lógica de las tareas.
    - `GestorNotificaciones` se encarga de las notificaciones.
- **Abierto/Cerrado (OCP):** Se pueden extender funcionalidades (por ejemplo, nuevos tipos de tareas) sin modificar el código existente.
- **Inversión de Dependencias (DIP):** Se utilizan interfaces y abstracciones, como en el sistema de notificaciones.

### **2. Programación Funcional**
- Uso de **Streams** para filtrar, mapear y procesar colecciones de tareas.
- Ejemplos:
    - Filtrar tareas pendientes.
    - Buscar una tarea específica por su título.

### **3. Patrones de Diseño**
- **Singleton:** Para una configuración global (`Configuracion`).
- **Factory:** Para crear instancias de tareas (`TareaFactory`).
- **Observer:** Para notificar a los usuarios cuando cambia el estado de una tarea (`GestorNotificaciones` y `Usuario`).

---

## **Funcionamiento de la Aplicación**

### **Flujo de la Aplicación**
1. **Inicialización:**
    - Se configura una instancia única de configuración (`Configuracion`).
2. **Gestión de Tareas:**
    - Crear tareas con la fábrica (`TareaFactory`).
    - Agregar tareas al gestor (`GestorDeTareas`).
    - Listar las tareas pendientes utilizando Streams.
    - Completar una tarea específica por su título.
3. **Notificaciones:**
    - Registrar usuarios para recibir notificaciones.
    - Enviar notificaciones a todos los usuarios cuando una tarea cambia de estado.
4. **Mostrar Resultados:**
    - Visualizar las tareas pendientes antes y después de completarlas.

---

## **Ejemplo de Ejecución**

```java
public class App {
    public static void main(String[] args) {
        // Inicializar configuración
        Configuracion.getInstance();

        // Crear Gestor de Tareas y Notificaciones
        GestorDeTareas gestor = new GestorDeTareas();
        GestorNotificaciones notificador = new GestorNotificaciones();

        // Registrar usuarios
        notificador.registrar(new Usuario("Carlos"));
        notificador.registrar(new Usuario("Julina"));

        // Crear tareas
        TareaFactory factory = new TareaFactory();
        Tarea tarea1 = factory.crearTarea("simple", "Comprar comida", "Ir al supermercado");
        Tarea tarea2 = factory.crearTarea("simple", "Estudiar Java", "Repasar patrones de diseño");

        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);

        // Mostrar tareas pendientes
        System.out.println("Tareas pendientes:");
        gestor.listarPendientes().forEach(System.out::println);

        // Completar una tarea
        gestor.completarTarea("Comprar comida");
        notificador.notificar("Tarea 'Comprar comida' completada.");

        // Mostrar tareas pendientes nuevamente
        System.out.println("\nTareas pendientes:");
        gestor.listarPendientes().forEach(System.out::println);
    }
}
```

### **Salida Esperada**
```
Configuración inicializada.
Tareas pendientes:
Comprar comida (Pendiente)
Estudiar Java (Pendiente)
Carlos recibió: Tarea 'Comprar comida' completada.
Sofía recibió: Tarea 'Comprar comida' completada.

Tareas pendientes:
Estudiar Java (Pendiente)
```

---

## **Requisitos Previos**

- **Java 8 o superior:** La aplicación utiliza Streams y Lambdas.
- **IntelliJ IDEA:** Para importar y ejecutar el proyecto.
- **Maven:** Para gestionar las dependencias y el proyecto.

---

## **Pasos para Ejecutar el Proyecto**

1. **Clonar el Repositorio:**
    - Si está en un repositorio, usa:
      ```bash
      git clone <URL del repositorio>
      ```
    - Si no, copia los archivos localmente.

2. **Abrir en IntelliJ IDEA:**
    - Selecciona "Open" y elige la carpeta raíz del proyecto.

3. **Ejecutar el Proyecto:**
    - Abre `App.java` y selecciona la opción de "Run".

4. **Pruebas Unitarias:**
    - Ve a la carpeta `src/test/java` y ejecuta `AppTest`.

---

## **Extensiones Futuras**

- Persistencia de tareas en un archivo o base de datos.
- Interfaz gráfica con JavaFX.
- Soporte para nuevos tipos de tareas utilizando el patrón Factory.

---

## **Autores**

**Carlos Aranzazu**  
**Susana Eguis**  
**Jeronimo Rodriguez**  
Proyecto educativo con implementación de principios modernos en Java.
