package animal;

public class Gato extends Paciente {
    private int nivelEstres = 0;

    public Gato(String nombre, double peso, int edad, int nivelEstres) {
        super(nombre, peso, edad, 6);
        setNivelEstres(nivelEstres);
        setEstado("INGRESADO");
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        if (nivelEstres >= 0 && nivelEstres <= 10) {
            this.nivelEstres = nivelEstres;
        }
    }

    // R9: sube 2 con tope 10
    public void subirEstres() {
        setNivelEstres(Math.min(10, nivelEstres + 2));
    }
}
