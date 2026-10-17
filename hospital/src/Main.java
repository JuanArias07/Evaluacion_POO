

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();

            if (linea.equals("salir")) {
                break;
            }

            String[] t = linea.split("\\s+");

            try {
                switch (t[0]) {
                    case "ingresar":
                        procesarIngreso(hospital, t);
                        break;
                    case "vacunar":
                        System.out.println(hospital.vacunar(t[1]));
                        break;
                    case "asignar":
                        System.out.println(hospital.asignar(t[1]));
                        break;
                    case "medicar":
                        System.out.println(hospital.medicar(t[1], Double.parseDouble(t[2])));
                        break;
                    case "alta":
                        System.out.println(hospital.alta(t[1]));
                        break;
                    case "reporte":
                        System.out.print(hospital.reporte());
                        break;
                    default:
                        System.out.println("ERROR: comando desconocido");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Texto donde va un numero, o faltan argumentos
                System.out.println("ERROR: datos invalidos");
            }
        }

        sc.close();
    }

    // ingresar perro <nombre> <peso> <edad> <raza> <si/no>
    // ingresar gato  <nombre> <peso> <edad>
    // ingresar ave   <nombre> <peso> <edad> <envergadura>
    private static void procesarIngreso(Hospital hospital, String[] t) {
        switch (t[1]) {
            case "perro":
                System.out.println(hospital.ingresarPerro(
                        t[2],
                        Double.parseDouble(t[3]),
                        Integer.parseInt(t[4]),
                        t[5],
                        t[6].equals("si")));
                break;
            case "gato":
                System.out.println(hospital.ingresarGato(
                        t[2],
                        Double.parseDouble(t[3]),
                        Integer.parseInt(t[4])));
                break;
            case "ave":
                System.out.println(hospital.ingresarAve(
                        t[2],
                        Double.parseDouble(t[3]),
                        Integer.parseInt(t[4]),
                        Double.parseDouble(t[5])));
                break;
            default:
                System.out.println("ERROR: comando desconocido");
        }
    }
}

