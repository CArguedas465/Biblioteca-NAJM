
package sistemabiblioteca;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistemabiblioteca.Estructuras.ArbolBinario.*;
import sistemabiblioteca.Estructuras.ArbolBinarioPrestamos.ArbolBinarioPrestamos;
import sistemabiblioteca.Estructuras.ArbolBinarioPrestamos.NodoArbolBinarioPrestamos;
import sistemabiblioteca.Estructuras.Listas.DoblementeEnlazada.ListaDobleEnlazada;
import sistemabiblioteca.Estructuras.Listas.DoblementeEnlazada.NodoDobleEnlazada;
import sistemabiblioteca.Estructuras.Listas.SimplementeEnlazada.ListaSimpleEnlazada;
import sistemabiblioteca.Estructuras.Listas.SimplementeEnlazada.NodoSimpleEnlazada;

public class Acciones {
    
    /*Se inicializan las variables necesarias para el funcionamiento de las acciones*/
    static ArbolBinario arbolBaseDatos = new ArbolBinario(0);
    
    static ArbolBinarioPrestamos arbolPrestamos = new ArbolBinarioPrestamos(); 
    
    static ListaDobleEnlazada listaAnulados = new ListaDobleEnlazada(); 
    static ListaSimpleEnlazada listaDevueltos = new ListaSimpleEnlazada(); 
    

    /*Se gestiona el adicionamiento de un préstamo al árbol binario de préstamos*/
    public static void prestar(Prestamo prestamo){
        arbolPrestamos.adicionarNodo(arbolPrestamos.getRaiz(), new NodoArbolBinarioPrestamos(prestamo));
        SistemaBiblioteca.prestamosObservableList.clear();
        arbolPrestamos.getPrestamosInOrden(arbolPrestamos.getRaiz(), SistemaBiblioteca.prestamosObservableList);
    }
    
    /*Se gestiona el comienzo de la anulación de un préstamo*/
    public static void anular(ObservableList<Prestamo> ol){
        Prestamo pres = new Prestamo(); 
        for (Prestamo p: ol){
            pres = p;
        }
        String mensaje, title, aceptarString, cancelarString; 
        
        if(SistemaBiblioteca.idiomaSet.equals("Español")){
            mensaje = "¿Confirmar anulación del préstamo de "+pres.getNombreCliente()+", #"+pres.getCodigoPrestamo()+"?";
            title = "Confirmar anulación";
            aceptarString = "Aceptar";
            cancelarString = "Cancelar";
        } else {
            mensaje = "Confirm voiding of "+pres.getNombreCliente()+"'s loan, #"+pres.getCodigoPrestamo()+"?";
            title = "Confirm loan voiding";
            aceptarString = "Accept";
            cancelarString = "Cancel";
        }
        
        Stage confirmation = new Stage();
        confirmation.setTitle(title);
        confirmation.initModality(Modality.APPLICATION_MODAL);
        
        VBox vbx = new VBox(); 
        vbx.setAlignment(Pos.CENTER);
        vbx.setPadding(new Insets(15));
        Label alert = new Label(mensaje); 
        
        FlowPane buttonPane = new FlowPane();
        buttonPane.setHgap(20);
        buttonPane.setPadding(new Insets(10));
        buttonPane.setAlignment(Pos.CENTER);
        
        final Prestamo forAction = pres;
        
        Button aceptar = new Button(aceptarString);
        aceptar.setOnAction(e -> {
            gestionarAnulacion(forAction);
            confirmation.close();
        });
        Button cancelar = new Button(cancelarString);
        cancelar.setOnAction(e -> {
            confirmation.close();
        });
        
        buttonPane.getChildren().addAll(aceptar, cancelar);

        vbx.getChildren().addAll(alert, buttonPane);
        
        confirmation.setScene(new Scene(vbx, 500,100));
        confirmation.show();

    }
    
    /*Se gestiona la parte programática de la anulación de los préstamos (gestión de la estructura arbolBinarioPrestamos y listaAnulaciones)*/
    public static void gestionarAnulacion(Prestamo pres){
        Libro[] librosAnulados = pres.getLibros();

        for (Libro l: librosAnulados){
            NodoArbolBinario nab = arbolBaseDatos.buscaEnArbol(l.getTitulo());
            nab.getDato().setCantidad(nab.getDato().getCantidad()+1);
        }

        pres.setEstado("Anulado");
        listaAnulados.agregarAtras(pres);
        SistemaBiblioteca.anulacionesObservableList.clear();
        listaAnulados.recorridoDobleEnlazada(SistemaBiblioteca.anulacionesObservableList);
        
        arbolPrestamos.borrarDelArbol(pres.getCodigoPrestamo());
        SistemaBiblioteca.prestamosObservableList.clear();
        arbolPrestamos.getPrestamosInOrden(arbolPrestamos.getRaiz(), SistemaBiblioteca.prestamosObservableList);
    }
    
    /*Se gestiona el comienzo de la devolución de un préstamo*/
    public static void devolver(ObservableList<Prestamo> ol){
        Prestamo pres = new Prestamo(); 
        for (Prestamo p: ol){
            pres = p;
        }
        
        String mensaje, title, aceptarString, cancelarString; 
        
        if(SistemaBiblioteca.idiomaSet.equals("Español")){
            mensaje = "¿Confirmar devolución del préstamo de "+pres.getNombreCliente()+", #"+pres.getCodigoPrestamo()+"?";
            title = "Confirmar devolución";
            aceptarString = "Aceptar";
            cancelarString = "Cancelar";
        } else {
            mensaje = "Confirm return of "+pres.getNombreCliente()+"'s loan, #"+pres.getCodigoPrestamo()+"?";
            title = "Confirm loan return";
            aceptarString = "Accept";
            cancelarString = "Cancel";
        }
        
        Stage confirmation = new Stage();
        confirmation.setTitle(title);
        confirmation.initModality(Modality.APPLICATION_MODAL);
        
        VBox vbx = new VBox(); 
        vbx.setAlignment(Pos.CENTER);
        vbx.setPadding(new Insets(15));
        Label alert = new Label(mensaje); 
        
        FlowPane buttonPane = new FlowPane();
        buttonPane.setHgap(20);
        buttonPane.setPadding(new Insets(10));
        buttonPane.setAlignment(Pos.CENTER);
        
        final Prestamo forAction = pres;
        
        Button aceptar = new Button(aceptarString);
        aceptar.setOnAction(e -> {
            gestionarDevolucion(forAction);
            confirmation.close();
        });
        Button cancelar = new Button(cancelarString);
        cancelar.setOnAction(e -> {
            confirmation.close();
        });
        
        buttonPane.getChildren().addAll(aceptar, cancelar);

        vbx.getChildren().addAll(alert, buttonPane);
        
        confirmation.setScene(new Scene(vbx, 500,100));
        confirmation.show();
    }
    
    /*Se gestiona la parte programática de la devolución de los préstamos (gestión de la estructura arbolBinarioPrestamos y listaDevolciones)*/
    public static void gestionarDevolucion(Prestamo pres){
        Libro[] librosDevueltos = pres.getLibros();
        
        for (Libro l: librosDevueltos){
            NodoArbolBinario nab = arbolBaseDatos.buscaEnArbol(l.getTitulo());
            nab.getDato().setCantidad(nab.getDato().getCantidad()+1);
        }
        
        pres.setEstado("Devuelto");
        listaDevueltos.insertarUltimo(pres);
        SistemaBiblioteca.devolucionesObservableList.clear();
        listaDevueltos.recorridoListaSimple(SistemaBiblioteca.devolucionesObservableList);
        
        arbolPrestamos.borrarDelArbol(pres.getCodigoPrestamo());
        SistemaBiblioteca.prestamosObservableList.clear();
        arbolPrestamos.getPrestamosInOrden(arbolPrestamos.getRaiz(), SistemaBiblioteca.prestamosObservableList); 
    }
    
    /*Realiza la consulta del árbol binario de base de datos*/
    public static ObservableList<Libro> consultarBaseDatos(int mode ,String consulta){
        ObservableList<Libro> librosEncontrados = FXCollections.observableArrayList();
        
        switch(mode){
            case 0:
                mode = 0;
                break; 
            case 1:
                mode = 1;
                break;
            case 2:
                mode = 2;
                break;
            case 3:
                mode = 3;
                break;
            case 4:
                mode = 4;
                break;
            case 5:
                mode = 5;
                break;
            case 6:
                mode = 6;
                break;
            case 7:
                mode = 7;
                break;
            case 8:
                mode = 8;
                break;
        }
        
        librosEncontrados = arbolBaseDatos.busquedaPorFiltro(mode, consulta);
        
        return librosEncontrados;
    }
    
    /*Realiza la consulta del árbol binario de préstamos.*/
    public static ObservableList<Prestamo> consultarPrestamos(String consulta){
        NodoArbolBinarioPrestamos nabp;
        ObservableList<Prestamo> prestamosEncontrados = FXCollections.observableArrayList();
        
        nabp = arbolPrestamos.buscarNodo(arbolPrestamos.getRaiz(), Integer.parseInt(consulta));
        
        if (nabp!=null){
            prestamosEncontrados.add(nabp.getPrestamo());
        }
        
        return prestamosEncontrados;
    }
    
    /*Realiza la consulta de la lista doble enlazada de anulaciones*/
    public static ObservableList<Prestamo> consultarAnulaciones(String consulta){
        NodoDobleEnlazada nde;
        ObservableList<Prestamo> anulacionesEncontradas = FXCollections.observableArrayList();
        
        nde = listaAnulados.buscarElemCodPres(Integer.parseInt(consulta));
        
        if (nde!=null){
            anulacionesEncontradas.add(nde.getPrestamo());
        }
        
        return anulacionesEncontradas;
    }
    
    /*Realiza la consulta de la lista simple enlazada de devoluciones*/
    public static ObservableList<Prestamo> consultarDevoluciones(String consulta){
        NodoSimpleEnlazada nse; 
        ObservableList<Prestamo> devolucionesEncontradas = FXCollections.observableArrayList();
        
        nse = listaDevueltos.buscarEnLista(Integer.parseInt(consulta));
        
        if (nse!=null){
            devolucionesEncontradas.add(nse.getPrestamo());
        }
        
        return devolucionesEncontradas;
    }
    
}
