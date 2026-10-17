package infraestructura;
import animal.Paciente;
import animal.Perro;
import  animal.AveExotica;
import  animal.Gato;

public class Hospital {
    private Paciente[] pacientes = new Paciente[10];
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

        jaulas[0] = new Jaula(1, "S", "A", null);
        jaulas[1] = new Jaula(2, "M", "A",null);
        jaulas[2] = new Jaula(3, "M", "A",null);
        jaulas[3] = new Jaula(4, "L", "A",null);
        jaulas[4] = new Jaula(5, "S", "B",null);
        jaulas[5] = new Jaula(6, "M", "B",null);
    }

    private Paciente buscar(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (pacientes[i].getNombre().equalsIgnoreCase(nombre)) return pacientes[i];
        }
        return null;
    }
}
