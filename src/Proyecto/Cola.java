
package Proyecto;


/** @author Edu */
public class Cola {
    public String ar[];
    public int tamanio,inicio=0,fin=0;
    
    public Cola(int t){
        tamanio=t;
    ar=new String[tamanio];
    }
    
    public boolean vacia(){
        return inicio==fin;
    }
    
    public boolean llena(){
        return fin == tamanio;
    }
    public String agregar(String x) {
        if(llena() == true){
            return ("No se puede agregar, la cola esta llena");
        } else {
            ar[fin++]=x;
            //System.out.println(inicio);
        return "Dato almacenado";
        }
    }
    
    public String sacar(){
        if(vacia()==true){
            return "No se puede sacar, la cola esta vacia";
        } else {
            String d=ar[inicio];
            for (int i =inicio; i < fin-1 ; i++) {
                ar[i]=ar[i+1];
            }
            ar[fin-1]= null;
            fin--;
            return (d);
        }
    }
    
    public String mostrar(){
        String tempo="";
        for (int i = inicio; i < fin; i++) {
            tempo+=(ar[i]+",");
        }
        return tempo;
    }
    public int size(){
        return(fin-inicio);
    }
  
}
