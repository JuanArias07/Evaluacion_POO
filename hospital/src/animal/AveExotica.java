package animal;

public class AveExotica extends Paciente {
    private double envergadura = 0;

    public AveExotica(String nombre, double peso, int edad, double envergadura) {
        super(nombre, peso, edad, 3);
        setEnvergadura(envergadura);
        setEstado("INGRESADO");
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        if (envergadura > 0) {
            this.envergadura = envergadura;
        }
    }
}

}
