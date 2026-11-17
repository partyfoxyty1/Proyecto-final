public class Estudiante extends Persona{
    private String programa;

    public Estudiante(String nombre, int documento, String programa){
        super(nombre,documento);
        this.programa = programa;
    }

    public String getPrograma(){
        return this.programa;
    }


    @Override
    public String getTipoUsuario(){ return "Estudiante"; }

    @Override
    public int getlimiteLibros(){
        return 1;
    }

    @Override
    public int getDiasMaximosPrestamo(){
        return 10;
    }
}
