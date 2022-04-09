
package sistemabiblioteca;

public class Libro {
    /*Declaración de elementos pertenecientes al objeto Libro.*/
    int ISBN, edicion, cantidad; //ISBN DE MÁXIMO 10 CARACTERES
    String titulo, autor, editorial, pais, area, tipo;
    boolean disponibilidad, estado; 
    String fecha; 
    
    /*Constructor que solicita los datos para crear el objeto libro.*/
    public Libro(int ISBN, String titulo, String autor, String editorial, String pais, String area, String tipo, int edicion, String fecha, int cantidad){
        this.ISBN = ISBN;
        this.titulo = titulo; 
        this.autor = autor; 
        this.editorial = editorial; 
        this.pais = pais; 
        this.area = area; 
        this.tipo = tipo; 
        this.edicion = edicion; 
        this.fecha = fecha;
        this.cantidad = cantidad;
    }
    
    /*Retorna un resultado "Integer" a partir de la función .hashCode() aplicada a la String "Título". */
    public int getHash(){
        int hashCode = titulo.hashCode();
        return hashCode;
    }

    /*Cambia la cantidad disponible.*/
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }    
    
    /*Retorna el valor de ISBN*/
    public int getISBN() {
        return ISBN;
    }

    /*Cambia el valor del ISBN*/
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    /*Retorna el valor de la edición del libro*/
    public int getEdicion() {
        return edicion;
    }

    /*Cambia el valor de edición*/
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    /*Retorna el título del libro*/
    public String getTitulo() {
        return titulo;
    }

    /*Cambia el valor del título del libro*/
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /*Retorna el nombre del autor del libro*/
    public String getAutor() {
        return autor;
    }

    /*Cambia el nombre del autor del libro*/
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /*Retorna la editorial del libro*/
    public String getEditorial() {
        return editorial;
    }

    /*Cambia el nombre de Editorial del libro*/
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /*Retorna el país de publicación del libro*/
    public String getPais() {
        return pais;
    }

    /*Cambia el país de publicación del libro*/
    public void setPais(String pais) {
        this.pais = pais;
    }

    /*Retorna el área temática del libro*/
    public String getArea() {
        return area;
    }

    /*Se cambia el área temática del libro*/
    public void setArea(String area) {
        this.area = area;
    }

    /*Se retorna el tipo del libro*/
    public String getTipo() {
        return tipo;
    }

    /*Se cambia el tipo del libro*/
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /*Retorna si el libro se encuentra disponible*/
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /*Cambia si el libro se encuentra disponible*/
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /*Retorna el estado del libro*/
    public boolean isEstado() {
        return estado;
    }

    /*Cambia el estado del libro*/
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /*Retorna el año de publicación del libro*/
    public String getFecha() {
        return fecha;
    }

    /*Cambia la fecha del libro*/
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /*Retorna la cantidad de libros disponibles de este ejemplar.*/
    public int getCantidad(){
        return cantidad;
    }

    
    
}
