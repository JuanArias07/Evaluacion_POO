package animal;

public class Paciente {
    protected String nombre;
    private double peso;
    private int edad;
    public String estado;
    private double factorDosis;
    private double dosisAcumulada;
    private String jaula;

    public Paciente(String nombre, double peso, int edad,String estado, double factorDosis,
                    double dosisAcumulada, String jaula){
        this.nombre=nombre;
        this.peso=peso;
        this.edad=edad;
        this.estado=estado;
        this.factorDosis=factorDosis;
        this.dosisAcumulada=dosisAcumulada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getFactorDosis() {
        return factorDosis;
    }

    public void setFactorDosis(double factorDosis) {
        this.factorDosis = factorDosis;
    }

    public double getDosisAcumulada() {
        return dosisAcumulada;
    }

    public void setDosisAcumulada(double dosisAcumulada) {
        this.dosisAcumulada = dosisAcumulada;
    }

    public String getJaula() {
        return jaula;
    }

    public void setJaula(String jaula) {
        this.jaula = jaula;
    }
}
