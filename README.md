# Grafo y sus Recorridos (DFS, BFS y Rutas Óptimas)

> Aplicación de escritorio desarrollada en **Java Swing** para la creación dinámica, representación gráfica y análisis de grafos estáticos. Implementa estructuras de datos desde cero para realizar recorridos en profundidad, recorridos en anchura y cálculo de todas las rutas posibles junto con la ruta óptima entre dos nodos.

---

##  Demostración Visual

<p align="center">
  <img src="images/demo-grafo.png" alt="Interfaz principal mostrando el grafo dibujado y sus recorridos" width="800px">
</p>

---

##  Características Principales

* **Generación Dinámica de Grafos:** Configuración interactiva de la cantidad de nodos y asignación de nombres personalizados.
* **Renderizado Gráfico (`Graphics`):** Dibujo automático de vértices y aristas sobre un `JPanel` utilizando coordenadas calculadas con `Math.random()` y matriz de adyacencia.
* **Recorrido en Profundidad (DFS):** Exploración completa del grafo implementando **Pilas Estáticas (LIFO)**.
* **Recorrido en Anchura (BFS):** Exploración por niveles implementando **Colas Estáticas (FIFO)**.
* **Búsqueda de Rutas y Ruta Óptima:** Algoritmo recursivo apoyado con `HashSet` y `ArrayList` para encontrar todos los caminos posibles entre un nodo origen ($X$) y un nodo destino ($Y$), destacando la mejor ruta.

---

##  Tecnologías y Estructuras Utilizadas

* **Lenguaje:** Java (JDK)
* **Interfaz Gráfica:** Java Swing (`JFrame`, `JPanel`, `JTextArea`, `JTextField`, `JButton`)
* **Estructuras de Datos (Implementación Propia):**
  * **Matriz de Adyacencia y Arreglos:** Almacenamiento de conexiones y nombres de nodos.
  * **Pila Estática (`Pila.java`):** Control de nodos visitados en DFS.
  * **Cola Estática (`Cola.java`):** Control de nodos visitados en BFS.
* **Colecciones de Java:** `ArrayList` y `HashSet` para gestión de rutas y prevención de ciclos infinitos.

---

## Arquitectura del Proyecto

El código fuente dentro del paquete `Proyecto` se estructura en las siguientes clases:

* `VentanaGrafo.java`: Interfaz gráfica principal (`JFrame`) y manejo de eventos de usuario.
* `GrafoEstatico.java`: Lógica central del grafo, matriz de adyacencia, algoritmos de recorrido (`profundidad`, `anchura`) y cálculo de rutas (`Rutas`, `RutasDFS`).
* `Pila.java`: Estructura de datos estática tipo LIFO.
* `Cola.java`: Estructura de datos estática tipo FIFO.

---

## ⚙️ Cómo Ejecutarlo Localmente

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/edufv26/Grafo.git
	```
2. ** Abrir NetBeans:**

Abre Apache NetBeans IDE, ve al menú superior y selecciona File > Open Project (o usa el acceso directo), busca la carpeta Grafo que acabas de clonar y ábrela.

3. **Ejecutar el proyecto:**

Selecciona el proyecto en el panel izquierdo de NetBeans y presiona la tecla F6 (o dale clic al botón verde de Run arriba en la barra de herramientas) para compilar y lanzar tu ventana de grafos.
