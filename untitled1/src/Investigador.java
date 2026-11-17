public class Investigador extends Persona{
    private String lineaInvestigacion;

    public Investigador(String nombre, int documento, String lineaInvestigacion){
        super(nombre, documento);
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public String getLineaInvestigacion(){
        return this.lineaInvestigacion;
    }

    @Override
    public String getTipoUsuario(){ return "Investigador"; }

    @Override
    public int getlimiteLibros(){
        return 5;
    }

    @Override
    public int getDiasMaximosPrestamo(){
        return 30;
    }

}
