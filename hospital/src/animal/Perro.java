package animal;

public class Perro extends Paciente {
    private String raza = "";
    private boolean vacunado;

    public Perro(String nombre, double peso, int edad, String raza, boolean vacunado) {
        super(nombre, peso, edad, 10);
        setRaza(raza);
        this.vacunado = vacunado;
        setEstado(vacunado ? INGRESADO : CUARENTENA); // R3
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        if (raza != null && !raza.trim().isEmpty()) {
            this.raza = raza;
        }
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }
}

Claude ha terminado la respuesta
