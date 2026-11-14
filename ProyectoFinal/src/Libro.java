public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    public Libro(String codigo,String titulo, String autor, int cantidadDisponible ){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public int getCantidadDisponible(){
        return this.cantidadDisponible;
    }

    public boolean estaDisponible(){
        if(cantidadDisponible > 0){
            return true;
        }
        return false;
    }

    public void marcarComoDisponible(){
        cantidadDisponible+=1;
    }

    public void marcarComoPrestado(){
        if (cantidadDisponible > 0){
            cantidadDisponible-=1;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + this.codigo);
        System.out.println("Nombre: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Disponibles: " + this.cantidadDisponible);
    }

}
