package infraestructura;

import animal.Paciente;


public class Jaula {
    private int numero;
    private String tamano;
    private String zona;
    private String ocupante;

    public Jaula(int numero, String tamano, String zona, String ocupante) {
        this.numero = numero;
        this.tamano = tamano;
        this.zona = zona;
        this.ocupante = ocupante;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getOcupante() {
        return ocupante;
    }

    public void setOcupante(String ocupante) {
        this.ocupante = ocupante;
    }
}
