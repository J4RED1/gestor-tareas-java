import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorTareas gt = new GestorTareas();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("==== GESTION DE TAREAS ====");
            System.out.println("1. Agregar nuevas tareas");
            System.out.println("2. Ver todas las tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Buscar tarea");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción:");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    gt.agregarTarea();
                    break;
                case 2:
                    gt.listarTareasOrdenadas();

                    break;
                case 3:
                    gt.listarTareasOrdenadas();
                    gt.cambiarEstadoTarea();
                    break;
                case 4:
                    gt.listarTareasOrdenadas();
                    gt.eliminarTarea();
                    break;
                case 5:
                    gt.buscarTareaPorNombre();
                    break;

                case 6:
                    System.out.println("👋 Saliendo del gestor de tareas...");
                    sc.close();
                    return;
                default:
                    System.out.println("⚠️ Opción no válida, intente nuevamente.");


            }

        }

    }
}