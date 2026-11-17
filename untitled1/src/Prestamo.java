import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Persona usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private LocalDate fechaLimiteDevolucion;
    private boolean activo;

    public Prestamo(Persona usuario, Libro libro, LocalDate fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimiteDevolucion = fechaPrestamo.plusDays(usuario.getDiasMaximosPrestamo());
        this.fechaEntrega = null;
        this.activo = true;
    }

    public Persona getUsuario() { return usuario; }

    public Libro getLibro() { return libro; }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }

    public LocalDate getFechaLimiteDevolucion() { return fechaLimiteDevolucion; }

    public LocalDate getFechaEntrega() { return fechaEntrega; }

    public boolean isActivo() { return activo; }

    public int calcularDiasMora(LocalDate fechaEntrega) {
        if (fechaEntrega.isAfter(this.fechaLimiteDevolucion)) {
            return (int) ChronoUnit.DAYS.between(this.fechaLimiteDevolucion, fechaEntrega);
        }
        return 0;
    }

    public int cerrarDevolucion(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        int diasMora = calcularDiasMora(fechaEntrega);
        this.activo = false;
        return diasMora * 2;
    }

    public void mostrarDetallePrestamo() {
        System.out.println("Usuario: " + usuario.getNombre() + " (Doc: " + usuario.getDocumento() + ")");
        System.out.println("Libro: " + libro.getTitulo() + " (Cód: " + libro.getCodigo() + ")");
        System.out.println("Fecha préstamo: " + fechaPrestamo);
        System.out.println("Fecha límite: " + fechaLimiteDevolucion);
        if (activo) System.out.println("Estado: Activo (Pendiente de entrega)");
        else System.out.println("Estado: Devuelto el " + fechaEntrega);
    }
}
