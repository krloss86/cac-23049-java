package ar.com.codoacodo.oop;

//libro es hijo (extends) de Articulo
public class Libro extends Articulo{
    
    //atributo
    private String isbn;

    //constructor/es
    public Libro(
        String titulo,
        String imagen,
        String autor,
        double precio,
        boolean novedad,
        String isbn
        ) {
            //1 - nace el padre
            super(titulo, imagen, autor, precio, novedad);

            //2 - nace el hijo
            this.isbn = isbn;
    }
    
    //metodos
    public String obtenerIsbn() {
        return this.isbn;
    }

    @Override
    public String toString() {
        //el toString del padre + el del hijo
        return super.toString() + ", Libro [isbn=" + isbn + "]";
    }
    
}
