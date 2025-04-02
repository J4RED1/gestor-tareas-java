public class Tarea {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String descripcion;
    private String estado;
    private int prioridad;


    public Tarea(String nombre, String descripcion, int prioridad ){
        this.id = contadorId++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = "Pendiente";
    }

    @Override
    public String toString() {
        String prioridadTexto;
        switch (prioridad) {
            case 1 -> prioridadTexto = "Alta";
            case 2 -> prioridadTexto = "Media";
            case 3 -> prioridadTexto = "Baja";
            default -> prioridadTexto = "Desconocida";
        }

        return """
            ----------------------------
            🆔 ID: %d
            📌 Tarea: %s
            📄 Descripción: %s
            ⏳ Estado: %s
            🔥 Prioridad: %s
            ----------------------------
            """.formatted(id, nombre, descripcion, estado, prioridadTexto);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
