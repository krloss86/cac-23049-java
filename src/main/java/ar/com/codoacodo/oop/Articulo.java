package ar.com.codoacodo.oop;

import java.time.LocalDateTime;

//todas las clases son hijas de Object
//nombre
public class Articulo {

    //atributos: convertir a protected
    protected Long id;
    protected String titulo;
    protected double precio;
    protected String imagen; 
    protected String autor;
    protected boolean novedad;
    protected LocalDateTime fechaCreacion;//alt+shit+r
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
            extracted(titulo, imagen, autor, precio, novedad, codigo, fechaCreacion);
    }

    public Articulo(
        Long id,
        String titulo,
        String imagen,
        String autor,
        double precio,
        boolean novedad,
        String codigo,
        LocalDateTime fechaCreacion
    )
    {
            extracted(titulo, imagen, autor, precio, novedad, codigo, fechaCreacion);
            this.id = id;
    }

    private void extracted(String titulo, String imagen, String autor, double precio, boolean novedad, String codigo,
            LocalDateTime fechaCreacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.autor = autor;
        this.novedad = false;
        this.fechaCreacion = fechaCreacion;
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
                + ", novedad=" + novedad + ", fechaCreacion=" + fechaCreacion + "]";
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


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
