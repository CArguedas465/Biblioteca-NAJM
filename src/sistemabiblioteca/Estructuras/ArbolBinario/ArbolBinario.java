package sistemabiblioteca.Estructuras.ArbolBinario;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sistemabiblioteca.Libro;

public class ArbolBinario {
    /*NOTA: Las notas de este árbol binario son muy similares a aquellas que están en ÁrbolBinarioPrestamos. Por esto, solo se comentará esta clase, y su respectivo nodo. 
            La diferencia con la otra estructura es que este acumula Libros, y el otro Préstamos.*/
    
    private NodoArbolBinario raiz;

    /*Constructor crea el valor apuntando a nulo cuando es instanciado*/
    public ArbolBinario(int mode)
    {
        if (mode==0){
            raiz = null;  
            cargar();
        } else {
            raiz = null;
        }
        
    }
 
    /*Carga todos los libros que estarán disponibles desde el principio*/
    public void cargar() // METODO CARGAR ARBOL
    {   
        adicionarNodo(raiz, new NodoArbolBinario (new Libro(1475413685, "Los sonidos del Aurora", "Carlos Morales", "Editorial UCR", "Costa Rica", "Política", "Musical", 1, "1991", 5)));
        adicionarNodo(raiz, new NodoArbolBinario (new Libro(1854965215, "Harry Potter y la Piedra Filosofal", "J.K. Rowling", "Bloomsbury Publishing", "Reino Unido", "Magia", "Novela", 1, "1997", 1)));
        adicionarNodo(raiz, new NodoArbolBinario (new Libro(1248796325, "La vida de Pi", "Yann Martel", "Random House of Canada", "Canadá", "Ficción", "Novela", 1, "2001", 4)));
        
    }
 
    /*Revisa si el árbol binario está vacío*/
    public static boolean vacioArbol(NodoArbolBinario a)//Metodo para saber si el arbol esta completamente vacio
    {
        return (a == null);          
    }

    /*Retorna la raíz del árbol binario*/
    public NodoArbolBinario getRaiz() //procedimiento para obtener la raiz
    {
        return raiz;
    }

    /*Retorna el valor de nodo izquierdo del árbol binario*/
    public static NodoArbolBinario getIzqArbol(NodoArbolBinario a)
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

    /*Retorna el valor de nodo derecho del árbol binario*/
    public static   NodoArbolBinario getDerArbol(NodoArbolBinario a)
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

    /*Adiciona nodos a la estructura de árbol binario*/
    public String adicionarNodo(NodoArbolBinario root, NodoArbolBinario toInsert) 
    {
        if(vacioArbol(root))
        {
            raiz = toInsert;
            return "Elemento insertado correctamente.";
        }
        else
        {
            if(root.getDato().getHash() != toInsert.getDato().getHash())
            {
                if(root.getDato().getHash() < toInsert.getDato().getHash())
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
                else if(root.getDato().getHash() > toInsert.getDato().getHash())
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
    
    int counter = 0;
    
    /*Gestiona el comienzo de la búsqueda por filtro*/
    public ObservableList<Libro> busquedaPorFiltro(int mode, String search){
        ArrayList<NodoArbolBinario> nab = new ArrayList<>();
        ObservableList<Libro> nabOL = FXCollections.observableArrayList();
        
        switch(mode){ /*Descripción de modos: 1 - Por título, 2 - Por autor, 3 - Por Editorial, 4 - Por país
                        5 - Por Área Temática, 6 - Por Tipo, 7 - Por Edición, 8 - Por Año*/
            case 0:
                nabOL = busquedaISBNInOrden(raiz, search, nab);
                break; 
            case 1:
                nabOL = busquedaTituloInOrden(raiz, search, nab);
                break;
            case 2:
                nabOL = busquedaAutorInOrden(raiz, search, nab);
                break;
            case 3:
                nabOL = busquedaEditorialInOrden(raiz, search, nab);
                break;
            case 4:
                nabOL = busquedaPaisInOrden(raiz, search, nab);
                break;
            case 5:
                nabOL = busquedaTematicaInOrden(raiz, search, nab);
                break;
            case 6:
                nabOL = busquedaTipoInOrden(raiz, search, nab);
                break;
            case 7:
                nabOL = busquedaEdicionInOrden(raiz, search, nab);
                break;
            case 8:
                nabOL = busquedaYearInOrden(raiz, search, nab);
                break;
        }

        return nabOL; 
    }
    
    /*De aquí en adelante, todos los métodos que leen "búsquedaXOrden" se refiere a la programación de los diferentes filtros*/
    public ObservableList<Libro> busquedaISBNInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaISBNInOrden(raiz.getIzq(), search, nab);
            if (search.equals(String.valueOf(raiz.getDato().getISBN()))){
                nab.add(raiz);
            }
            busquedaISBNInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaTituloInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaTituloInOrden(raiz.getIzq(), search, nab);
            if (search.equals(raiz.getDato().getTitulo())){
                nab.add(raiz);
            }
            busquedaTituloInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaAutorInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaAutorInOrden(raiz.getIzq(), search, nab);
            if (search.equals(raiz.getDato().getAutor())){
                nab.add(raiz);
            }
            busquedaAutorInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaEditorialInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaEditorialInOrden(raiz.getIzq(), search, nab);
            if (search.equals(raiz.getDato().getEditorial())){
                nab.add(raiz);
            }
            busquedaEditorialInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaPaisInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaPaisInOrden(raiz.getIzq(), search, nab);
            if (search.equals(raiz.getDato().getPais())){
                nab.add(raiz);
            }
            busquedaPaisInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaTematicaInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaTematicaInOrden(raiz.getIzq(), search, nab);
            if (search.equals(raiz.getDato().getArea())){
                nab.add(raiz);
            }
            busquedaTematicaInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaTipoInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaTipoInOrden(raiz.getIzq(), search, nab);
            if (search.equals(raiz.getDato().getTipo())){
                nab.add(raiz);
            }
            busquedaTipoInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaEdicionInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaEdicionInOrden(raiz.getIzq(), search, nab);
            if (search.equals(String.valueOf(raiz.getDato().getEdicion()))){
                nab.add(raiz);
            }
            busquedaEdicionInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }
    
    public ObservableList<Libro> busquedaYearInOrden(NodoArbolBinario raiz, String search, ArrayList<NodoArbolBinario> nab){
        ObservableList<Libro> busqueda = FXCollections.observableArrayList();
        
        if (!vacioArbol(raiz)){
            busquedaYearInOrden(raiz.getIzq(), search, nab);
            if (search.equals(String.valueOf(raiz.getDato().getFecha()))){
                nab.add(raiz);
            }
            busquedaYearInOrden(raiz.getDer(), search, nab);
        }
        if (!nab.isEmpty()){
            for (NodoArbolBinario nab1 : nab) {
                busqueda.add(nab1.getDato());
            }
        }
        return busqueda;
    }    
    
    /*Busca el árbol binario y adiciona todos los elementos "Libro" a la observable list que sea pasada como segundo parámetro*/
    public static void getLibrosInOrden(NodoArbolBinario a, ObservableList<Libro> ol) 
    {
        
        if(!vacioArbol(a))
        {
            getLibrosInOrden(getIzqArbol(a), ol);
            ol.add(a.getDato());
            getLibrosInOrden(getDerArbol(a), ol);
        }       
        
        
    }
    

    /*Comienza la búsqueda en árbol, por título*/
    public NodoArbolBinario buscaEnArbol(String title){
        int titleHash = title.hashCode();
        NodoArbolBinario node;
        node=buscarNodo(raiz, titleHash);
        if (node==null){ 
            return node;
        }
        return node;
    }

    /*Representa la segunda parte de la busqueda del nodo. Utiliza elementos de búsqueda recursiva, y se retorna el nodo donde se encuentra el valor. 
    Si no se encuentra, se retorna null*/
    public NodoArbolBinario buscarNodo(NodoArbolBinario a, int dato)
    {
        
        if(a != null)
        {
           if(a.getDato().getHash() == dato)
           {
                return a;
           }

           else
           {
                if(dato > a.getDato().getHash())
                {
                    return buscarNodo(a.getDer(), dato);
                }
                else
                {
                    return buscarNodo(a.getIzq(), dato);
                }
            }
        }
        else
        {
            return null;
        }
    }


    /*Revisa si el nodo en el que se está en un momento determinado es una hoja*/
    public boolean soloRaiz(NodoArbolBinario nodo){ 
        if(nodo.getDer()==null && nodo.getIzq()==null ){
            nodo=null;
            return true;
        }
        return false;
    }
}
