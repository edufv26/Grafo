package Proyecto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/** @author Edu
 */
public class GrafoEstatico {

    public String x[];
    public int matriz[][];
    public int t;
    public ArrayList<String> Rutas;
    public int contador;

//CREACION DEL GRAFO    
    public void Grafo(int t) {
        this.t = t;
        x = new String[t];
        matriz = new int[t][t];
        Rutas = new ArrayList<>();
        contador = 0; // contador para la lista de rutas
        for (int i = 0; i < t; i++) {
            x[i] = JOptionPane.showInputDialog("Nombre del nodo");
        }
        for (int i = 0; i < t; i++) {
            int j = Integer.parseInt(JOptionPane.showInputDialog("Con cuantos nodos se une el nodo " + x[i]));
            for (int k = 0; k < j; k++) {
                String w = JOptionPane.showInputDialog("Nodo adyacente a " + x[i]);
                if (posicion(w) >= 0) {
                    matriz[i][posicion(w)] = 1;
                }
            }
        }

    }

    public int posicion(String y) {
        for (int i = 0; i < x.length; i++) {
            if (y.equals(x[i])) {
                return i;
            }
        }
        return -1;
    }

//RUTAS DE X A Y
    public String Rutas(String inicio, String destino) {
        Set<String> visitados = new HashSet<>();
        List<List<String>> Rutas = new ArrayList<>(); // Lista de todas las rutas

        // Método DFS para encontrar todas las rutas
        RutasDFS(inicio, destino, visitados, new ArrayList<>(), Rutas);

        if (Rutas.isEmpty()) {
            return "Ninguna ruta encontrada"; // No se encontraron rutas
        }
        // Ordenar rutas (de menor a mayor)
        Rutas.sort(Comparator.comparingInt(List::size));

        //mejor ruta (menor número de nodos visitados)
        List<String> mejorRuta = Rutas.get(0);
        int minNodos = mejorRuta.size();

        for (List<String> ruta : Rutas) {
            int numNodos = ruta.size();
            if (numNodos < minNodos) {
                mejorRuta = ruta;
                minNodos = numNodos;
            }
        }

        //String con todas las rutas
        StringBuilder resultado = new StringBuilder();
        for (List<String> ruta : Rutas) {
            resultado.append(String.join(", ", ruta)).append("\n");
        }

        return "Mejor ruta: " + String.join(", ", mejorRuta) + "\nTodas las rutas:\n" + resultado.toString();
    }

    public void RutasDFS(String actual, String destino, Set<String> visitados, List<String> rutaActual, List<List<String>> todasLasRutas) {
        visitados.add(actual);
        rutaActual.add(actual);

        if (actual.equals(destino)) {

            todasLasRutas.add(new ArrayList<>(rutaActual));
        } else {
            int posActual = posicion(actual);
            for (int v = 0; v < matriz[posActual].length; v++) {
                if (matriz[posActual][v] == 1 && !visitados.contains(x[v])) {
                    RutasDFS(x[v], destino, visitados, rutaActual, todasLasRutas);
                }
            }
        }

        visitados.remove(actual);
        rutaActual.remove(rutaActual.size() - 1); // Deshacer el último nodo agregado
    }

    public void ReiniciarRutas() {
        Rutas.clear();
        contador = 0;
    }

    /* public String Rutas(String y, String z){
    String rutas="";
    if(matriz[posicion(y)][posicion(z)]==1){
        //System.out.println("¡MEJOR RUTA!: ");
        return rutas+y+","+z+"\n";
       //System.out.println("conexion directa de "+y+" a "+z);
} else {
    int c=0; 
    Cola c1=new Cola(t);
    for (int m = 0; m < matriz[posicion(z)].length; m++) {
        if(matriz[posicion(z)][m]=  =1){
            c++; c1.agregar(x[m]);
        }
        int k=0; Cola c2= new Cola(t);
    while(k<c){
        c2.agregar(y);
        String tem=c1.sacar();
        c2.agregar(tem);
        while(x[posicion(tem)].equals(z)==false){
            if(matriz[posicion(tem)][posicion(z)]==1){
                c2.agregar(z);
                break;
            } else {
                for (int v = 0; v < matriz[posicion(tem)].length; v++) {
                    if(matriz [posicion(tem)][v]==1 && tem.equals(y)==false){
                        c2.agregar(x[v]);
                    }
                }
            }
        } //while
        c2.mostrar();
    }
    k++;
    }
}
    return "Ninguna ruta encontrada";
} */

//TODOS LOS NODOS DEL GRAFO - PROFUNDIDAD
    public String profundidad(String nodo) {

    int posNodo = posicion(nodo);
    if (posNodo == -1) {
        return "El nodo no existe en el grafo.";
    }
    boolean visitados[] = new boolean[t];
    Pila p1 = new Pila(t);
    Pila p2 = new Pila(t);
    String temp = "";

    //Marca al nodo inicial como visitado y lo agrega a la pila
    visitados[posNodo] = true;
    p1.agregar(nodo);

    while (!p1.vacia()) {
        nodo = p1.sacar();
        p2.agregar(nodo);

        // Obtiene la posición del nodo actual y explora sus adyacentes
        posNodo = posicion(nodo);
        if (posNodo != -1) {
            for (int i = 0; i < t; i++) {
                if (matriz[posNodo][i] == 1 && !visitados[i]) {
                    visitados[i] = true;
                    p1.agregar(x[i]);
                }
            }
        }
        temp = p2.mostrar();
    }
    return temp;
}


//TODAS LAS CONEXIONES DE UN NODO X - ANCHURA
    public String anchura(String nodo) {
        // Verifica si el "nodo" existe en el grafo
        int posNodo = posicion(nodo);
        if (posNodo == -1) {
            return "El nodo no existe en el grafo.";

        }
        boolean visitados[] = new boolean[t];
        Cola c1 = new Cola(t);
        Cola c2 = new Cola(t);
        String temp = "";

        // Marca a nodo inicial como visitado y lo agrega a la cola
        visitados[posNodo] = true;
        c1.agregar(nodo);

        while (!c1.vacia()) {
            nodo = c1.sacar();
            c2.agregar(nodo);

            // Obtiene la posición del nodo actual y explora sus adyacentes
            posNodo = posicion(nodo);
            if (posNodo != -1) {
                for (int i = 0; i < t; i++) {
                    if (matriz[posNodo][i] == 1 && !visitados[i]) {
                        visitados[i] = true;
                        c1.agregar(x[i]);
                    }
                }
            }
            temp = c2.mostrar();
        }
        return temp;
    }

//PARA EL TXTAREA
    public String imprimir() {
        String temp = "";
        for (int i = 0; i < x.length; i++) {
            if (x[i] != null) {
                temp = temp + x[i] + "\n";
            }
        }
        return temp;
    }

}
