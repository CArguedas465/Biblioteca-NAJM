
package sistemabiblioteca.Estructuras.Listas.DoblementeEnlazada;

import sistemabiblioteca.Libro;
import sistemabiblioteca.Prestamo;

public class NodoDobleEnlazada {
    
        /*Declara los elementos que contiene el nodo de la lista doble enlazada*/
        private Prestamo prestamo;
	private NodoDobleEnlazada nextElement;
	private NodoDobleEnlazada previousElement;

        /*Constructor vacío, para tener la capacidad de inicializar objetos sin parámetros*/
        public NodoDobleEnlazada(){}
        
        /*Crea un nodo con un objeto préstamo*/
	public NodoDobleEnlazada(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

        /*Retorna el objeto préstamo del nodo*/
	public Prestamo getPrestamo() {
		return prestamo;
	}

        /*Cambia el objeto préstamo con el del parámetro*/
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

        /*Retorna el elemento siguiente al nodo actual*/
	public NodoDobleEnlazada getNextElement() {
		return nextElement;
	}
        /*Cambia el elemento siguiente al nodo actual*/
	public void setNextElement(NodoDobleEnlazada nextElement) {
		this.nextElement = nextElement;
	}

        /*Retorna el elemento anterior al nodo actual*/
	public NodoDobleEnlazada getPreviousElement() {
		return previousElement;
	}

        /*Cambia el elemento anterior del nodo actual*/
	public void setPreviousElement(NodoDobleEnlazada previousElement) {
		this.previousElement = previousElement;
	}
        
    }