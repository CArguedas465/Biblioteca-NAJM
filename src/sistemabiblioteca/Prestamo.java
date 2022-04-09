
package sistemabiblioteca;

import java.util.Random;

public class Prestamo {
    /*Declaración de elementos pertenecientes al objeto Préstamo.*/
     Libro[] libros; 
     String nombreCliente, fechaSolicitud, fechaDevolucion, estado = "Activo";
     String click = "Haga click para más detalles.";
     int cedula, codigoPrestamo;
     public boolean nodoComienzo = false;

     /*Constructor vacío*/
    public Prestamo(){}
    
    /*Constructor que pide datos del préstamo*/
    public Prestamo(String nombreCliente, int cedula, String fechaSolicitud, String fechaDevolucion) {
        Random r = new Random();
        int random; 
        random = r.nextInt();
        
        while (random<0){
            random = r.nextInt();
        }

        this.nombreCliente = nombreCliente;
        this.cedula = cedula;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaDevolucion = fechaDevolucion;
        this.codigoPrestamo = random;
    }
    
    /*Constructor para primer nodo del árbol binario de préstamos*/
    public Prestamo(boolean initial){
        nodoComienzo = initial;
    }
    
    /*Retorna el valor de la variable "nodoComienzo" para ver si el nodo es la raíz del árbol*/
    public boolean nodoComienzo(){
        return nodoComienzo;
    }
    
    /*Retorna el vector de libros*/
    public Libro[] getLibros() {
        return libros;
    }

    /*Retorna el nombre del cliente*/
    public String getNombreCliente() {
        return nombreCliente;
    }

    /*Retorna el texto de click de la tabla*/
    public String getClick() {
        return click;
    }

    /*Retorna la fecha de solicitud del préstamo*/
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /*Retorna la fecha de devolución del préstamo*/
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    /*Retorna el estado del préstamo*/
    public String getEstado() {
        return estado;
    }

    /*Retorna el código de préstamo*/
    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    /*Retorna la cédula asociada al préstamo*/
    public int getCedula() {
        return cedula;
    }
    
    /*Aplica el vector de libros*/
    public void setLibros(Libro[] libros){
        this.libros = libros;
    }
    
    /*Cambia el estado del préstamo*/
    public void setEstado(String estado){
        this.estado = estado;
    }
     
}
