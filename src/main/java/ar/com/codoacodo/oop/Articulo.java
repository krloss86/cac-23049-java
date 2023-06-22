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
   
    //constuctor/es
    //si no escribo el constructor, JVM me da uno por defecto
    public Articulo(
        String titulo,
        String imagen,
        String autor,
        double precio,
        boolean novedad
    )
    {
            this.imagen = imagen;
            this.titulo = titulo;
            this.autor = autor;
            this.novedad = false;
            this.fechaCrecion = LocalDateTime.now();
            this.precio = precio;
            this.novedad = novedad;
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

}
