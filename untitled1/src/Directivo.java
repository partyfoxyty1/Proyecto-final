
public class Directivo extends Persona{
    private String departamento;

    public Directivo(String nombre, int documento, String departamento){
        super(nombre,documento);
        this.departamento = departamento;
    }

    public String getDepartamento(){
        return this.departamento;
    }

    @Override
    public String getTipoUsuario(){ return "Directivo"; }

    @Override
    public int getlimiteLibros(){
        return 3;
    }

    @Override
    public int getDiasMaximosPrestamo(){
        return 30;
    }


}
