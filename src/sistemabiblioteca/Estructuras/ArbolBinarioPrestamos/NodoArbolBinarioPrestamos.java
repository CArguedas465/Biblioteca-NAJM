package sistemabiblioteca.Estructuras.ArbolBinarioPrestamos;
import sistemabiblioteca.Estructuras.ArbolBinario.*;
import sistemabiblioteca.Libro;
import sistemabiblioteca.Prestamo;

/*Comentarios en nodo de árbol binario de base de datos (Libros).*/
public class NodoArbolBinarioPrestamos {
    
    private Prestamo prestamo;
    private NodoArbolBinarioPrestamos izq;
    private NodoArbolBinarioPrestamos der;

    public NodoArbolBinarioPrestamos(){}
    
    public NodoArbolBinarioPrestamos(Prestamo prestamo)
    {
        this.prestamo = prestamo;
        izq = null;
        der = null;
    }

    public NodoArbolBinarioPrestamos getIzq()
    {
            return izq;
    }

    public void setIzq(NodoArbolBinarioPrestamos izq)
    {
            this.izq = izq;
    }

    public NodoArbolBinarioPrestamos getDer()
    {
            return der;
    }

    public void setDer(NodoArbolBinarioPrestamos der)
    {
            this.der = der;
    }

    public Prestamo getPrestamo()
    {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo)
    {
            this.prestamo= prestamo;
    }
    
    
    
}
