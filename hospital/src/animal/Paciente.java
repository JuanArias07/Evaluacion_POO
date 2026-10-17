package animal;

public class Paciente {
    protected String nombre;
    private double peso;
    private int edad;
    public String estado;
    Paciente · JAVA
    public class Paciente {
        public static final String INGRESADO = "INGRESADO";
        public static final String CUARENTENA = "CUARENTENA";
        public static final String EN_TRATAMIENTO = "EN_TRATAMIENTO";

        private String nombre = "";
        private double peso = 0;
        private int edad = 0;
        private String estado = INGRESADO;
        private double factorDosis = 0;
        private double dosisAcumulada = 0;
        private Jaula jaula = null;

        // Los datos ya llegan validados desde Hospital; los setters validan de nuevo.
        public Paciente(String nombre, double peso, int edad, double factorDosis) {
            setNombre(nombre);
            setPeso(peso);
            setEdad(edad);
            setFactorDosis(factorDosis);
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            if (nombre != null && !nombre.trim().isEmpty()) {
                this.nombre = nombre;
            }
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            if (peso > 0) {
                this.peso = peso;
            }
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            if (edad >= 0 && edad <= 30) {
                this.edad = edad;
            }
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            if (INGRESADO.equals(estado) || CUARENTENA.equals(estado) || EN_TRATAMIENTO.equals(estado)) {
                this.estado = estado;
            }
        }

        public double getFactorDosis() {
            return factorDosis;
        }

        public void setFactorDosis(double factorDosis) {
            if (factorDosis > 0) {
                this.factorDosis = factorDosis;
            }
        }

        public double getDosisAcumulada() {
            return dosisAcumulada;
        }

        public void setDosisAcumulada(double dosisAcumulada) {
            if (dosisAcumulada >= 0) {
                this.dosisAcumulada = dosisAcumulada;
            }
        }

        public Jaula getJaula() {
            return jaula;
        }

        public void setJaula(Jaula jaula) {
            this.jaula = jaula; // null es valido: significa sin jaula
        }

        // Dosis maxima por aplicacion (R7)
        public double getDosisMaxima() {
            return peso * factorDosis;
        }

        public void sumarDosis(double mg) {
            if (mg > 0) {
                dosisAcumulada += mg;
            }
        }

        public String getTipo() {
            return getClass().getSimpleName();
        }
    }

    Claude ha terminado la respuesta

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
