public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int cantidadDisponible;

    public Libro(String codigo, String titulo, String autor, int cantidadDisponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getCodigo() { return codigo; }

    public String getTitulo() { return titulo; }

    public String getAutor() { return autor; }

    public int getCantidadDisponible() { return cantidadDisponible; }

    public boolean estaDisponible() { return cantidadDisponible > 0; }

    public void marcarComoDisponible() { cantidadDisponible++; }

    public void marcarComoPrestado() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Disponibles: " + cantidadDisponible);
    }
}
