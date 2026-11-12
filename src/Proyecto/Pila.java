
package Proyecto;

//import javax.swing.JOptionPane;

/**
 *
 * @author Edu
 */
public class Pila {
    public int tamanio;
    public int tope = -1;
    public String[] ar;

    public Pila(int t) {
        this.tamanio = t;
        ar = new String[tamanio];
    }

    public boolean vacia() {
        return tope == -1;
    }

    
    public boolean llena() {
        return tope == tamanio - 1;
    }

    
    public String agregar(String dato) {
        if (llena()) {
            return "PILA LLENA, IMPOSIBLE AGREGAR";
        } else {
            ar[++tope] = dato;
            return "DATO AGREGADO";
        }
    }

    public String sacar() {
        if (vacia()) {
            return "No se puede sacar, pila vacia";
        } else {
            return ar[tope--];
        }
    }

    public String mostrar() {
        if (vacia()) {
            return "La pila está vacía.";
        } else {
        String tempo="";
        for (int i = 0; i <= tope; i++) {
            tempo+=(ar[i]+",");
        }
        return tempo;
        }
    }
}

  
