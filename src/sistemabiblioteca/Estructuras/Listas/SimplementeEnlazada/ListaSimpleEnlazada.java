
package sistemabiblioteca.Estructuras.Listas.SimplementeEnlazada;

import javafx.collections.ObservableList;
import sistemabiblioteca.Prestamo;


public class ListaSimpleEnlazada {
    /*Declaración de los elementos de la lista*/
     protected NodoSimpleEnlazada primero;
    
     /*Constructor que se lleva cuando se crea la lista simple enlazada. Pone el enlace "primero" apuntando a nulo*/
    public ListaSimpleEnlazada()
    {
        primero = null;
    }
        /*Busca en la lista por medio de código de préstamo del objeto "Préstamo" dentor del nodo. Si se encuentra el valor
          se retorna el nodo.*/
        public NodoSimpleEnlazada buscarEnLista(int codigoPrestamo){
            NodoSimpleEnlazada nse;
            nse = primero; 
            
            while (nse!=null){
                if (nse.getPrestamo().getCodigoPrestamo()==codigoPrestamo){
                    return nse;
                } else {
                    nse = nse.getEnlace();
                }
            }
            return null;
        }
        
        /*Se inserta un nodo al final*/
    public void insertarUltimo(Prestamo prestamo) {
    if (primero==null) {
            primero = new NodoSimpleEnlazada(prestamo);
    } else {
            NodoSimpleEnlazada t = primero;
            NodoSimpleEnlazada current_last = t;
            while (t!=null){
                    current_last = t;
                    t = t.getEnlace();//  getNext();
            }
            NodoSimpleEnlazada nuevo = new NodoSimpleEnlazada(prestamo);
            current_last.setEnlace(nuevo);
    }
}
        
        /*Se recorre la lista, y se adicionan todos los objetos "Préstamo" de cada nodo a la observable list del parámetro*/
    public void recorridoListaSimple(ObservableList<Prestamo> ol)
    {
        NodoSimpleEnlazada n;
        n = primero;
        while (n != null) {
            ol.add(n.getPrestamo());
            n = n.enlace;
        }
    }
           
}
