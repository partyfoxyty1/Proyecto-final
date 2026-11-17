import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
    private String nombre;
    private int documento;
    private int prestamosActivos;
    private int diasSuspension;
    private LocalDate fechaInicioSuspension;

    public Persona(String nombre, int documento) {
        this.nombre = nombre;
        this.documento = documento;
        this.prestamosActivos = 0;
        this.diasSuspension = 0;
        this.fechaInicioSuspension = null;
    }

    public String getNombre() { return nombre; }

    public int getDocumento() { return documento; }

    public int getPrestamosActivos() { return prestamosActivos; }

    public int getDiasSuspension() {
        if (diasSuspension == 0 || fechaInicioSuspension == null) return 0;
        int diasTranscurridos = (int) ChronoUnit.DAYS.between(fechaInicioSuspension, LocalDate.now());
        return Math.max(0, diasSuspension - diasTranscurridos);
    }

    public int getlimiteLibros() { return 0; }

    public int getDiasMaximosPrestamo() { return 0; }

    public String getTipoUsuario() { return "Persona"; }

    public boolean puedePrestar() {
        return getDiasSuspension() == 0 && prestamosActivos < getlimiteLibros();
    }

    public boolean tienePrestamosPendientes() { return prestamosActivos > 0; }

    public void incrementarPrestamos() { prestamosActivos++; }

    public void decrementarPrestamos() {
        if (prestamosActivos > 0) prestamosActivos--;
    }

    public void aplicarMulta(int dias) {
        if (dias > 0) {
            diasSuspension = getDiasSuspension() + dias;
            fechaInicioSuspension = LocalDate.now();
        }
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Préstamos activos: " + prestamosActivos);
        System.out.println("Días de suspensión pendientes: " + getDiasSuspension());
    }
}
