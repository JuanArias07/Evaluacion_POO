package infraestructura;

Hospital · JAVA
import java.util.Locale;

public class Hospital {
    private static final int MAX_PACIENTES = 10;

    private Paciente[] pacientes = new Paciente[MAX_PACIENTES];
    private int contador = 0;
    private Jaula[] jaulas = new Jaula[6];

    public Hospital() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        pacientes[0] = new Perro("Rocky", 30.0, 4, "labrador", true);
        pacientes[1] = new Gato("Misifu", 4.0, 3, 0);
        pacientes[2] = new AveExotica("Kiwi", 0.8, 2, 70);
        contador = 3;

        jaulas[0] = new Jaula(1, "S", "A");
        jaulas[1] = new Jaula(2, "M", "A");
        jaulas[2] = new Jaula(3, "M", "A");
        jaulas[3] = new Jaula(4, "L", "A");
        jaulas[4] = new Jaula(5, "S", "B");
        jaulas[5] = new Jaula(6, "M", "B");
    }

    // ---------- Busqueda ----------

    private Paciente buscar(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (pacientes[i].getNombre().equalsIgnoreCase(nombre)) {
                return pacientes[i];
            }
        }
        return null;
    }

    private boolean datosValidos(String nombre, double peso, int edad, double pesoMaximo) {
        return nombre != null && !nombre.trim().isEmpty()
                && peso > 0 && peso <= pesoMaximo
                && edad >= 0 && edad <= 30;
    }

    // Orden R2: duplicado y luego lleno. Devuelve null si se puede ingresar.
    private String errorDeCupo(String nombre) {
        if (buscar(nombre) != null) {
            return "ERROR: nombre duplicado";
        }
        if (contador >= MAX_PACIENTES) {
            return "ERROR: hospital lleno";
        }
        return null;
    }

    private void agregar(Paciente p) {
        pacientes[contador] = p;
        contador++;
    }

    // ---------- Ingresos ----------

    public String ingresarPerro(String nombre, double peso, int edad, String raza, boolean vacunado) {
        if (!datosValidos(nombre, peso, edad, 80)) {
            return "ERROR: datos invalidos";
        }
        String error = errorDeCupo(nombre);
        if (error != null) {
            return error;
        }
        agregar(new Perro(nombre, peso, edad, raza, vacunado));
        if (vacunado) {
            return "OK: " + nombre + " ingresado";
        }
        return "OK: " + nombre + " ingresado en CUARENTENA";
    }

    public String ingresarGato(String nombre, double peso, int edad) {
        if (!datosValidos(nombre, peso, edad, 15)) {
            return "ERROR: datos invalidos";
        }
        String error = errorDeCupo(nombre);
        if (error != null) {
            return error;
        }
        agregar(new Gato(nombre, peso, edad, 0));
        return "OK: " + nombre + " ingresado";
    }

    public String ingresarAve(String nombre, double peso, int edad, double envergadura) {
        if (!datosValidos(nombre, peso, edad, 15) || envergadura <= 0) {
            return "ERROR: datos invalidos";
        }
        String error = errorDeCupo(nombre);
        if (error != null) {
            return error;
        }
        agregar(new AveExotica(nombre, peso, edad, envergadura));
        return "OK: " + nombre + " ingresado";
    }

    // ---------- Vacunar ----------

    public String vacunar(String nombre) {
        Paciente p = buscar(nombre);
        if (p == null) {
            return "ERROR: paciente no encontrado";
        }
        if (!(p instanceof Perro)) {
            return "ERROR: solo aplica a perros";
        }
        Perro perro = (Perro) p;
        if (perro.isVacunado()) {
            return "ERROR: ya vacunado";
        }
        perro.setVacunado(true);
        perro.setEstado(Paciente.INGRESADO);
        return "OK: " + perro.getNombre() + " vacunado (pasa a INGRESADO)";
    }

    // ---------- Asignar ----------

    // R4
    private String tamanoNecesario(Paciente p) {
        String tam;
        if (p.getPeso() < 5) {
            tam = "S";
        } else if (p.getPeso() <= 25) {
            tam = "M";
        } else {
            tam = "L";
        }
        if (p instanceof AveExotica && ((AveExotica) p).getEnvergadura() > 60 && tam.equals("S")) {
            tam = "M";
        }
        return tam;
    }

    // R5
    private String zonaNecesaria(Paciente p) {
        return (p instanceof AveExotica) ? "B" : "A";
    }

    public String asignar(String nombre) {
        Paciente p = buscar(nombre);
        if (p == null) {
            return "ERROR: paciente no encontrado";
        }
        if (p.getEstado().equals(Paciente.CUARENTENA)) {
            return "ERROR: paciente en cuarentena";
        }
        if (p.getJaula() != null) {
            return "ERROR: paciente ya tiene jaula";
        }
        String tam = tamanoNecesario(p);
        String zona = zonaNecesaria(p);
        for (int i = 0; i < jaulas.length; i++) {
            Jaula j = jaulas[i];
            if (j.estaLibre() && j.getTamano().equals(tam) && j.getZona().equals(zona)) {
                j.setOcupante(p);
                p.setJaula(j);
                return "OK: " + p.getNombre() + " asignado a jaula " + j.getNumero();
            }
        }
        return "ERROR: no hay jaula compatible";
    }

    // ---------- Medicar ----------

    public String medicar(String nombre, double mg) {
        Paciente p = buscar(nombre);
        if (p == null) {
            return "ERROR: paciente no encontrado";
        }
        if (mg <= 0) {
            return "ERROR: datos invalidos";
        }
        if (p.getEstado().equals(Paciente.CUARENTENA)) {
            return "ERROR: paciente en cuarentena";
        }
        if (p.getJaula() == null) {
            return "ERROR: paciente sin jaula";
        }
        if (p instanceof Gato && ((Gato) p).getNivelEstres() >= 8) {
            return "ERROR: gato con estres alto";
        }
        double maxima = p.getDosisMaxima();
        double eps = 1e-9;
        if (mg > maxima + eps) {
            return "ERROR: dosis excede el maximo";
        }
        if (p.getDosisAcumulada() + mg > 3 * maxima + eps) {
            return "ERROR: tope acumulado superado";
        }

        p.sumarDosis(mg);
        p.setEstado(Paciente.EN_TRATAMIENTO);
        if (p instanceof Gato) {
            ((Gato) p).subirEstres();
        }
        return "OK: " + p.getNombre() + " medicado con " + formatearMg(mg) + " mg";
    }

    // 50.0 se muestra como 50; 2.5 se queda como 2.5
    private String formatearMg(double mg) {
        if (mg == Math.floor(mg)) {
            return String.valueOf((long) mg);
        }
        return String.valueOf(mg);
    }

    // ---------- Alta ----------

    public String alta(String nombre) {
        Paciente p = buscar(nombre);
        if (p == null) {
            return "ERROR: paciente no encontrado";
        }
        if (!p.getEstado().equals(Paciente.EN_TRATAMIENTO)) {
            return "ERROR: paciente no apto para alta";
        }

        // Liberar la jaula (ambos lados del enlace)
        if (p.getJaula() != null) {
            p.getJaula().setOcupante(null);
            p.setJaula(null);
        }

        // Compactar el vector
        int pos = 0;
        while (pacientes[pos] != p) {
            pos++;
        }
        for (int i = pos; i < contador - 1; i++) {
            pacientes[i] = pacientes[i + 1];
        }
        pacientes[contador - 1] = null;
        contador--;

        return "OK: " + p.getNombre() + " dado de alta";
    }

    // ---------- Reporte ----------

    public String reporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- REPORTE ---\n");
        sb.append("Pacientes: ").append(contador).append("/").append(MAX_PACIENTES).append("\n");
        for (int i = 0; i < contador; i++) {
            Paciente p = pacientes[i];
            String jaula = (p.getJaula() == null) ? "-" : String.valueOf(p.getJaula().getNumero());
            sb.append(String.format(Locale.US, "%s | %s | %.1f kg | %s | jaula: %s\n",
                    p.getNombre(), p.getTipo(), p.getPeso(), p.getEstado(), jaula));
        }
        int libres = 0;
        for (int i = 0; i < jaulas.length; i++) {
            if (jaulas[i].estaLibre()) {
                libres++;
            }
        }
        sb.append("Jaulas libres: ").append(libres).append("\n");
        return sb.toString();
    }
}


