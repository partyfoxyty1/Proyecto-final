import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Persona usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private LocalDate fechaLimiteDevolucion;
    private  boolean activo = true;


    public Prestamo(Persona usuario, Libro libro, LocalDate fechaPrestamo) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        //aproxima la fecha de devolucion sumando los dias maximos del usuario a al fecha del prestamo
        this.fechaLimiteDevolucion = fechaPrestamo.plusDays(usuario.getDiasMaximosPrestamo());
        this.fechaEntrega = null;
        this.activo = true;
    }

    public Persona getUsuario() {
        return this.usuario;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public LocalDate getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    public LocalDate getFechaLimiteDevolucion() {
        return this.fechaLimiteDevolucion;
    }

    public LocalDate getFechaEntrega() {
        return this.fechaEntrega;
    }

    public boolean isActivo() {
        return this.activo;
    }

    //Calcula los días de retraso comparando la fecha de entrega contra la fecha límite
    public int calcularDiasMora(LocalDate fechaEntrega) {
        if (fechaEntrega.isAfter(this.fechaLimiteDevolucion)) {
            return (int) ChronoUnit.DAYS.between(this.fechaLimiteDevolucion, fechaEntrega);
        }
        return 0;
    }

    // Registra la fecha de entrega, cierra el préstamo y retorna los días de multa (mora * 2)
    public int cerrarDevolucion(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        int diasMora = calcularDiasMora(fechaEntrega);
        this.activo = false;
        return diasMora * 2;
    }


    public void mostrarDetallePrestamo() {
        System.out.println("Usuario: " + this.usuario.getNombre() + " (Doc: " + this.usuario.getDocumento() + ")");
        System.out.println("Libro: " + this.libro.getTitulo() + " (Cód: " + this.libro.getCodigo() + ")");
        System.out.println("Fecha préstamo: " + this.fechaPrestamo);
        System.out.println("Fecha límite: " + this.fechaLimiteDevolucion);
        if (this.activo) {
            System.out.println("Estado: Activo (Pendiente de entrega)");
        } else {
            System.out.println("Estado: Devuelto el " + this.fechaEntrega);
        }
    }


}
