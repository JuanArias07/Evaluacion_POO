package animal;

public class Gato extends Paciente{
    private int nivelEstres;

    public Gato(String nombre, double peso, int edad, int nivelEstres){
        super(nombre,peso,edad,"",6,0,null);
        this.nivelEstres=nivelEstres;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }
}
