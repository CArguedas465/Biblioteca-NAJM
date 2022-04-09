package sistemabiblioteca.Estructuras.ArbolBinario;
import sistemabiblioteca.Libro;

public class NodoArbolBinario {
    
    /*Se declaran los valores que contiene el objeto. En este caso, son libros. En el caso del otro arbol de préstamos, 
      son préstamos.*/
    private Libro libro;
    private NodoArbolBinario izq;
    private NodoArbolBinario der;

    public NodoArbolBinario(Libro libro)
    {
        this.libro = libro;
        izq = null;
        der = null;
    }

    public NodoArbolBinario getIzq()
    {
            return izq;
    }

    public void setIzq(NodoArbolBinario izq)
    {
            this.izq = izq;
    }

    public NodoArbolBinario getDer()
    {
            return der;
    }

    public void setDer(NodoArbolBinario der)
    {
            this.der = der;
    }

    public Libro getDato()
    {
        return libro;
    }

    public void setDato(Libro libro)
    {
            this.libro= libro;
    }
    
    
    
}
