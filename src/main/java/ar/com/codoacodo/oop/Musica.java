package ar.com.codoacodo.oop;

public class Musica extends Articulo{
    
    private String sello;

    public Musica(String titulo, String imagen, String autor, double precio, boolean novedad, String sello) {
        super(titulo, imagen, autor, precio, novedad,null,null);
        this.sello = sello;
    }

    //setter / getter
    

    //polimorfismo
    public String toString() {
        return super.toString() +  ", Musica [sello=" + sello + "]";
    }

    public String getSello() {
        return sello;
    }
    /*
    public void setSello(String sello) {
        this.sello = sello;
    }
    */
}
