
package sistemabiblioteca.Estructuras.Listas.SimplementeEnlazada;

import sistemabiblioteca.Prestamo;

public class NodoSimpleEnlazada {
    Prestamo prestamo;
    NodoSimpleEnlazada enlace;

    public NodoSimpleEnlazada(Prestamo prestamo)
    {
        this.prestamo = prestamo;
        enlace = null;
    }
    
    public Prestamo getPrestamo()
    {
        return prestamo;
    }
    
    public NodoSimpleEnlazada getEnlace()
    {
        return enlace;
    }
    
    public void setEnlace(NodoSimpleEnlazada enlace)
    {
        this.enlace = enlace;
    }   
}
