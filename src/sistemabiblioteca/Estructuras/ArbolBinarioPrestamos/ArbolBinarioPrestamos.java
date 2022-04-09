package sistemabiblioteca.Estructuras.ArbolBinarioPrestamos;
import javafx.collections.ObservableList;
import sistemabiblioteca.Prestamo;

/*Comentarios en árbol binario de base de datos (Libros).*/
public class ArbolBinarioPrestamos {

    private NodoArbolBinarioPrestamos raiz;

    public ArbolBinarioPrestamos()
    {
        Prestamo pres = new Prestamo(true);
        raiz = new NodoArbolBinarioPrestamos(pres); 
    }

    public void cargarElemento(Prestamo prestamo) 
    {
        adicionarNodo(raiz, new NodoArbolBinarioPrestamos(prestamo));        
    }
 
 
    public static boolean vacioArbol(NodoArbolBinarioPrestamos a)
    {
        return (a == null);          
    }

    public NodoArbolBinarioPrestamos getRaiz() 
    {
        return raiz;
    }

    public void setRaiz(NodoArbolBinarioPrestamos raiz) 
    {
        this.raiz = raiz;
    } 

    public static NodoArbolBinarioPrestamos getIzqArbol(NodoArbolBinarioPrestamos a)
    {
        if(a.getIzq() == null)
        {
            return null;
        }
        else
        {
            return a.getIzq();
        }
    }

    public static   NodoArbolBinarioPrestamos getDerArbol(NodoArbolBinarioPrestamos a)
    {
        if(a.getDer() == null)
        {
            return null;
        }
        else
        {
            return a.getDer();
        }
    } 

    public String adicionarNodo(NodoArbolBinarioPrestamos root, NodoArbolBinarioPrestamos toInsert) 
    {
        if(vacioArbol(root))
        {
            raiz = toInsert;
            return "Elemento insertado correctamente.";
        }
        else
        {
            if(root.getPrestamo().getCodigoPrestamo() != toInsert.getPrestamo().getCodigoPrestamo())
            {
                if(root.getPrestamo().getCodigoPrestamo() < toInsert.getPrestamo().getCodigoPrestamo())
                {                                  
                    if (getDerArbol(root) == null)
                    {
                        root.setDer(toInsert);
                        return "Elemento insertado correctamente.";
                    }
                    else
                    {
                        return adicionarNodo(getDerArbol(root), toInsert);
                    }
                }
                else if(root.getPrestamo().getCodigoPrestamo() > toInsert.getPrestamo().getCodigoPrestamo())
                {           
                    if (getIzqArbol(root) == null)
                    {
                        root.setIzq(toInsert);
                        return "Elemento insertado correctamente.";
                    }
                    else
                    {
                        return adicionarNodo(getIzqArbol(root), toInsert);
                    }
                }
            }   
            else
            {
                return "No se puede agregar el Elemento.";              
            }          
        }
        return "";
    } 
    
    public void getPrestamosInOrden(NodoArbolBinarioPrestamos a, ObservableList<Prestamo> ol) 
    {
        
        if(!vacioArbol(a))
        {
            getPrestamosInOrden(getIzqArbol(a), ol);
            if (a.getPrestamo().nodoComienzo!=true){
                ol.add(a.getPrestamo());
            }
            getPrestamosInOrden(getDerArbol(a), ol);
        }       
        
        
    }
    

    public NodoArbolBinarioPrestamos buscaEnArbol(String title){
        int titleHash = title.hashCode();
        NodoArbolBinarioPrestamos node;
        node=buscarNodo(raiz, titleHash);
        if (node==null){ 
            System.out.println(titleHash +" No encontrado");
            return node;
        }
        return node;
    }

    
    public NodoArbolBinarioPrestamos buscarNodo(NodoArbolBinarioPrestamos a, int codigoPrestamo)
    {
        
        if(a != null)
        {
           if(a.getPrestamo().getCodigoPrestamo() == codigoPrestamo)
           {
                return a;
           }

           else
           {
                if(codigoPrestamo > a.getPrestamo().getCodigoPrestamo())
                {
                    return buscarNodo(a.getDer(), codigoPrestamo);
                }
                else
                {
                    return buscarNodo(a.getIzq(), codigoPrestamo);
                }
            }
        }
        else
        {
            return null;
        }
    }


    public boolean soloRaiz(NodoArbolBinarioPrestamos nodo){ 
        if(nodo.getDer()==null && nodo.getIzq()==null ){
            nodo=null;
            return true;
        }
        return false;
    }
    
    
    public void borrarDelArbol(int id){
        NodoArbolBinarioPrestamos node;
        node=EliminarNodo(raiz, id);
    }

    
    public NodoArbolBinarioPrestamos EliminarNodo(NodoArbolBinarioPrestamos nodo, int codigoPrestamo)
    {
        if(soloRaiz(nodo))
        {
            return null;
        }
     
        if (nodo == null){
            System.out.println("No se encuentra el nodo.");
        }
        else if (codigoPrestamo < nodo.getPrestamo().getCodigoPrestamo()){
            NodoArbolBinarioPrestamos izq;
            izq = EliminarNodo(nodo.getIzq(), codigoPrestamo);
            nodo.setIzq(izq);
        }
        else if (codigoPrestamo > nodo.getPrestamo().getCodigoPrestamo()){
            NodoArbolBinarioPrestamos der;
            der = EliminarNodo(nodo.getDer(), codigoPrestamo);
            nodo.setDer(der);
        }      
        else{
            NodoArbolBinarioPrestamos eliminar;
            eliminar = nodo;
         
            if(eliminar.getIzq() == null)
            {
                nodo = eliminar.getDer();              
            }
            else if (eliminar.getDer() == null)
            {
                nodo = eliminar.getIzq();
            }
            else
            {
                eliminar = reemplazar(eliminar);
            }
            eliminar = null;
        }
        return nodo;
    }

    public NodoArbolBinarioPrestamos reemplazar(NodoArbolBinarioPrestamos nodo)
    {
        NodoArbolBinarioPrestamos N1;
        NodoArbolBinarioPrestamos N2;
        N2 = nodo;
        N1 = nodo.getIzq();
     
        while(N1.getDer() != null)
        {
            N2 = N1;
            N1 = N1.getDer();
        }
     
        nodo.setPrestamo(N1.getPrestamo());
     
        if(N2 == nodo)
        {
            N2.setIzq(N1.getIzq());
        }
        else
        {
            N2.setDer(N1.getIzq());
        }
     
        return N1;
    }
}
