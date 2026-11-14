public class Persona {
    private String nombre;
    private int documento;
    private int prestamosActivos;
    private int diasSuspension;

    public Persona(String nombre, int documento) {
        this.nombre = nombre;
        this.documento = documento;
        this.prestamosActivos = 0;
        this.diasSuspension = 0;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getDocumento(){
        return this.documento;
    }

    public int getPrestamosActivos() {
        return this.prestamosActivos;
    }

    public int getDiasSuspension() {
        return this.diasSuspension;
    }

    public int getlimiteLibros() {
        return 0;
    }

    public int getDiasMaximosPrestamo() {
        return 0;
    }

    public boolean puedePrestar(){
        if(this.diasSuspension==0 && this.prestamosActivos<getlimiteLibros()){
            return true;
        }
        return false;
    }

    public boolean tienePrestamosPendientes(){
        if(this.prestamosActivos > 0){
            return true;
        }
        return false;
    }

    public void incrementarPrestamos() {
        this.prestamosActivos++;
    }

    public void decrementarPrestamos() {
        if (this.prestamosActivos > 0) {
            this.prestamosActivos--;
        }
    }

    public void aplicarMulta(int dias) {
        if (dias > 0) {
            this.diasSuspension += dias;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Documento: " + this.documento);
        System.out.println("Préstamos activos: " + this.prestamosActivos);
        System.out.println("Días de suspensión: " + this.diasSuspension);
    }

}
