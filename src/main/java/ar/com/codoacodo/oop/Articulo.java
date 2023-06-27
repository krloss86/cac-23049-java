package ar.com.codoacodo.oop;

import java.time.LocalDateTime;

//todas las clases son hijas de Object
//nombre
public abstract class Articulo {

    //atributos: convertir a protected
    protected String titulo;
    protected double precio;
    protected String imagen; 
    protected String autor;
    protected boolean novedad;
    protected LocalDateTime fechaCrecion;
    protected String codigo;
   
    //constuctor/es
    //si no escribo el constructor, JVM me da uno por defecto
    public Articulo(
        String titulo,
        String imagen,
        String autor,
        double precio,
        boolean novedad,
        String codigo,
        LocalDateTime fechaCreacion
    )
    {
            this.imagen = imagen;
            this.titulo = titulo;
            this.autor = autor;
            this.novedad = false;
            this.fechaCrecion = fechaCreacion;
            this.precio = precio;
            this.novedad = novedad;
            this.codigo = codigo;
    }

    //metodos: va entre llaves
    public String mostrarImagen() {
        return this.imagen;
    }

    public void mas10Porciento() {
        //x + 10%
        //en java los numeros con decimales son
        //por defecto double
        this.precio = this.precio * 1.1;
    }

    @Override
    public String toString() {
        return "Articulo [titulo=" + titulo + ", precio=" + precio + ", imagen=" + imagen + ", autor=" + autor
                + ", novedad=" + novedad + ", fechaCrecion=" + fechaCrecion + "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public LocalDateTime getFechaCrecion() {
        return fechaCrecion;
    }

    public void setFechaCrecion(LocalDateTime fechaCrecion) {
        this.fechaCrecion = fechaCrecion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
}
