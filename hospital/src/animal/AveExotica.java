package animal;

public class AveExotica extends Paciente{
    private double envergadura;

    public AveExotica(String nombre, double peso, int edad,
                      double envergadura){
        super(nombre, peso,edad, "",3, 0, null);
        this.envergadura=envergadura;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }
}
