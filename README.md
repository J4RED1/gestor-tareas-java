
# 📋 Gestor de Tareas en Java

Un gestor de tareas simple desarrollado en **Java** para gestionar actividades pendientes, ordenarlas por prioridad, marcarlas como completadas y realizar búsquedas o eliminaciones. Este proyecto es ideal para practicar estructuras de datos como `List`, `Map` y `Set`, así como el uso de `Scanner` para entradas interactivas por consola.

---

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Java 17+
- **Entorno:** Consola
- **Estructuras de datos:** `ArrayList`, `HashMap`, `TreeSet`, `LinkedHashSet`
- **Paradigma:** Programación orientada a objetos (POO)

---

## 🚀 Funcionalidades

### 1. Agregar tarea

Permite registrar una nueva tarea con:

- Nombre único
- Descripción (opcional)
- Prioridad: Alta (1), Media (2) o Baja (3)

### 2. Listar tareas

Muestra todas las tareas ordenadas por prioridad (de Alta a Baja) con el siguiente formato:

```
----------------------------
🆔 ID: 1  
📌 Tarea: Estudiar Java  
📄 Descripción: Repasar colecciones  
⏳ Estado: Pendiente  
🔥 Prioridad: Alta  
----------------------------
```

### 3. Cambiar estado

Permite alternar entre los estados:

- `Pendiente → Completada`
- `Completada → Pendiente`

Con confirmación del usuario para evitar cambios accidentales.

### 4. Eliminar tarea

Permite eliminar una tarea seleccionada por su ID, previa confirmación del usuario.

### 5. Buscar por nombre

Busca tareas por coincidencia parcial o total del nombre. No distingue entre mayúsculas y minúsculas.

### 6. Salir

Cierra la aplicación de forma segura.

---

## 🧠 Estructuras de datos usadas

| Estructura             | Uso                                                       |
|------------------------|-----------------------------------------------------------|
| `ArrayList<Tarea>`     | Almacena la lista principal de tareas                     |
| `HashMap<Integer, Tarea>` | Acceso rápido a tareas por ID                         |
| `LinkedHashSet<String>`   | Evita nombres de tareas duplicados y mantiene el orden |
| `TreeSet<Tarea>` + `Comparator` | Ordena las tareas por prioridad para visualización  |

---

## 🧹 Organización del proyecto

```
📁 src/
├── Tarea.java           # Clase que representa una tarea individual
├── GestorTareas.java    # Lógica del programa y gestión de tareas
└── Main.java            # Clase principal con menú interactivo
```

---

## 📦 Cómo ejecutar el proyecto

1. Clona este repositorio:

```bash
git clone https://github.com/tu_usuario/gestor-tareas-java.git
cd gestor-tareas-java
```

2. Compila los archivos:

```bash
javac Main.java GestorTareas.java Tarea.java
```

3. Ejecuta la aplicación:

```bash
java Main
```

---

## ✅ Buenas prácticas aplicadas

- Validación de entradas del usuario
- Encapsulamiento y uso de getters/setters
- Separación de responsabilidades por clase
- Uso de `switch` moderno con `->` (Java 14+)
- Mensajes amigables y claros en consola

---

## 📚 Aprendizajes clave

Este proyecto permite reforzar:

- El manejo de colecciones (`List`, `Map`, `Set`)
- Ordenamiento con `Comparator`
- Validación de entradas por consola
- Estructuración de código Java para proyectos interactivos

---

## ✨ Mejoras futuras

- Persistencia en archivos (lectura/escritura)
- Interfaz gráfica con JavaFX o Swing
- Filtrado por estado
- Exportar tareas completadas

---

## 🧑‍💻 Autor

Proyecto desarrollado por **[Tu Nombre o Usuario de GitHub]**.  
Este repositorio forma parte de un portafolio personal de estudios.

---

## 📄 Licencia

Este proyecto está licenciado bajo la **MIT License**. Consulta el archivo [LICENSE](LICENSE) para más detalles.
