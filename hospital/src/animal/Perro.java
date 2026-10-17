package animal;

public class Perro extends Paciente{
    private String raza;
    private boolean vacunado;

    public Perro(String nombre, double peso, int edad,
                 String raza, boolean vacunado){
        super(nombre,peso,edad,"",10,0,null);
        this.raza=raza;
        this.vacunado=vacunado;

    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean getVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }
}
