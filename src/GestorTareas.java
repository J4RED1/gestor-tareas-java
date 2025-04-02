import java.util.*;

public class GestorTareas {
    private List<Tarea> tareas = new ArrayList<>();
    private Map<Integer, Tarea> tareasPorId = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Set<String> nombresTareas = new LinkedHashSet<>();

    public void agregarTarea() {
        System.out.println("==== AGREGANDO TAREA ====\n");

        String nombre;
        do {
            System.out.print("Ingrese nombre de la tarea: ");
            nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("⚠️ El nombre no puede estar vacío.");
            } else if (nombresTareas.contains(nombre)) {
                System.out.println("⚠️ Ya existe una tarea con ese nombre.");
                nombre = "";
            }
        } while (nombre.isEmpty());

        System.out.print("Ingrese descripción de la tarea (opcional): ");
        String descripcion = sc.nextLine().trim();
        if (descripcion.isEmpty()) {
            descripcion = "(sin descripción)";
        }

        int prioridad;
        while (true) {
            System.out.print("Prioridad (1 = Alta, 2 = Media, 3 = Baja): ");
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("⚠️ Debe ingresar una prioridad.");
                continue;
            }

            try {
                prioridad = Integer.parseInt(entrada);

                if (prioridad >= 1 && prioridad <= 3) {
                    break;
                } else {
                    System.out.println("⚠️ Prioridad fuera de rango. Ingrese 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número entre 1 y 3.");
            }
        }


        Tarea tarea = new Tarea(nombre, descripcion, prioridad);
        tareas.add(tarea);
        tareasPorId.put(tarea.getId(), tarea);
        nombresTareas.add(nombre);

        System.out.println("✅ Tarea agregada con ID: " + tarea.getId() + "\n");
    }

    public void cambiarEstadoTarea() {
        while (true){
            System.out.print("Ingrese el ID de la tarea: ");
            String entrada = sc.nextLine().trim();

            int id;
            try {
                id = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Debe ingresar un número.");
                return;
            }

            Tarea tarea = tareasPorId.get(id);
            if (tarea == null) {
                System.out.println("⚠️ No se encontró una tarea con ese ID.");
                return;
            }

            String estadoActual = tarea.getEstado();

            if (estadoActual.equalsIgnoreCase("Completada")) {
                System.out.println("⚠️ La tarea ya está COMPLETADA.");
                System.out.print("¿Deseas cambiar su estado a PENDIENTE? (s/n): ");
            } else if (estadoActual.equalsIgnoreCase("Pendiente")) {
                System.out.println("ℹ️ La tarea está actualmente PENDIENTE.");
                System.out.print("¿Deseas marcarla como COMPLETADA? (s/n): ");
            } else {
                System.out.println("⚠️ Estado desconocido. No se puede cambiar.");
                return;
            }

            String respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                String nuevoEstado = estadoActual.equalsIgnoreCase("Completada") ? "Pendiente" : "Completada";
                tarea.setEstado(nuevoEstado);
                System.out.println("✅ Estado actualizado correctamente a: " + nuevoEstado);
            } else {
                System.out.println("ℹ️ No se realizaron cambios.");
            }
        }

    }


    public void listarTareasOrdenadas() {
        if (tareas.isEmpty()) {
            System.out.println("⚠️ No hay tareas registradas.");
            return;
        }

        TreeSet<Tarea> tareasOrdenadas = new TreeSet<>(Comparator.comparingInt(Tarea::getPrioridad));
        tareasOrdenadas.addAll(tareas);

        System.out.println("==== LISTADO DE TAREAS ORDENADAS ====");
        tareasOrdenadas.forEach(System.out::println);
    }
    public void eliminarTarea() {
        if (tareas.isEmpty()) {
            System.out.println("⚠️ No hay tareas para eliminar.\n");
            return;
        }

        int id = pedirIdTarea("Ingrese el ID de la tarea a eliminar: ");
        if (id == -1) return;

        Tarea tarea = tareasPorId.get(id);

        if (tarea == null) {
            System.out.println("⚠️ No se encontró una tarea con ese ID.\n");
            return;
        }

        System.out.println("Tarea a eliminar:");
        System.out.println(tarea);

        System.out.print("¿Estás seguro de que deseas eliminar esta tarea? (s/n): ");
        String confirm = sc.nextLine().trim().toLowerCase();

        if (!confirm.equals("s")) {
            System.out.println("ℹ️ Operación cancelada.\n");
            return;
        }


        boolean eliminada = tareas.removeIf(t -> t.getId() == id);
        tareasPorId.remove(id);
        nombresTareas.remove(tarea.getNombre());

        if (eliminada) {
            System.out.println("✅ Tarea eliminada correctamente.\n");
        } else {
            System.out.println("⚠️ Ocurrió un error al eliminar la tarea.\n");
        }
    }


    private int pedirIdTarea(String mensaje) {
        int id;
        int intentos = 3;
        while (intentos > 0) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                return id;
            } else {
                sc.nextLine();
                System.out.println("⚠️ Entrada inválida. Ingrese un número de ID válido.");
            }
            intentos--;
        }
        System.out.println("⛔ Demasiados intentos fallidos.");
        return -1;
    }
    public void buscarTareaPorNombre() {
        if (tareas.isEmpty()) {
            System.out.println("⚠️ No hay tareas registradas.");
            return;
        }

        System.out.print("Ingrese el nombre o parte del nombre de la tarea a buscar: ");
        String nombreBuscado = sc.nextLine().trim().toLowerCase();

        List<Tarea> resultados = tareas.stream()
                .filter(t -> t.getNombre().toLowerCase().contains(nombreBuscado))
                .toList();

        if (resultados.isEmpty()) {
            System.out.println("⚠️ No se encontraron tareas con ese nombre.");
        } else {
            System.out.println("==== RESULTADOS DE BÚSQUEDA ====");
            resultados.forEach(System.out::println);
        }
    }


}
