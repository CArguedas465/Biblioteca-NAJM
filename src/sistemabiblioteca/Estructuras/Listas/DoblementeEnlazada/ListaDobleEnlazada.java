package sistemabiblioteca.Estructuras.Listas.DoblementeEnlazada;

import javafx.collections.ObservableList;
import sistemabiblioteca.Prestamo;

public class ListaDobleEnlazada {
    
    /*Declara las referencias que estarán al principio y al final de la lista doble enlazada*/
    private NodoDobleEnlazada tail;
	private NodoDobleEnlazada head;

        /*Agrega nodos al final de la lista*/
	public void agregarAtras(Prestamo prestamo) {
		NodoDobleEnlazada node = new NodoDobleEnlazada(prestamo);
		if (tail == null && head == null) {
			tail = node;
			head = node;
		} else {
			tail.setNextElement(node);
			node.setPreviousElement(tail);
			tail = node;
		}
	}

        /*Busca elementos dentro del nodo a partir del código de préstamo del objeto "Préstamo"*/
        public NodoDobleEnlazada buscarElemCodPres(int codigoPrestamo) {
        NodoDobleEnlazada aux = head;
        while (aux != null) {
            if (aux.getPrestamo().getCodigoPrestamo() == codigoPrestamo)
                return aux;
            aux = aux.getNextElement() ;
        }
        return null;
    }
        
        /*Elimina elementos dentro del nodo a partir del código de préstamo del objeto "Préstamo"*/
    public void eliminaValorCodPres(int codigoPrestamo) {
        if (head != null) {
            NodoDobleEnlazada aux = head;
            NodoDobleEnlazada ant = null;
            while (aux != null) {
                if (aux.getPrestamo().getCodigoPrestamo() == codigoPrestamo) {
                    if (ant == null) {
                        head = head.getNextElement();
                        aux.setNextElement(null);
                        aux = head;
                    } else {
                        ant.setNextElement(aux.getNextElement());
                        ant=ant.getNextElement();                               
                        ant.setPreviousElement(aux.getPreviousElement());       
                        aux.setNextElement(null);
                        aux = ant.getPreviousElement().getPreviousElement();
                    }
                } else {
                    ant = aux;
                    aux = aux.getNextElement();
                }
            }
        }
    }
    
    /*Recorre la lista doble enlazada, y adiciona todos los elementos "Préstamo" de los nodos a la ObservableList que se pasa como parámetro*/
    public void recorridoDobleEnlazada(ObservableList<Prestamo> ol){
        for (NodoDobleEnlazada i = head; i != null; i = i.getNextElement()) {
            ol.add(i.getPrestamo());
	}
    }
}
