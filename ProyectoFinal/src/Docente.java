public class Docente extends Persona{
    private String area;

    public Docente(String nombre, int documento, String area){
        super(nombre,documento);
        this.area = area;
    }

    public String getArea(){
        return this.area;
    }

    @Override
    public int getlimiteLibros(){
        return 3;
    }

    @Override
    public int getDiasMaximosPrestamo(){
        return 30;
    }

}
