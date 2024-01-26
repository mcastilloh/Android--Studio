package uits.vih.ejemplo1.Modelos;

public class Alumno {

    private String id;
    private String nombre;
    private String apellido;
    private int matGanadas;

    public Alumno() {
    }

    public Alumno(String id, String nombre, String apellido, int matGanadas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matGanadas = matGanadas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMatGanadas() {
        return matGanadas;
    }

    public void setMatGanadas(int matGanadas) {
        this.matGanadas = matGanadas;
    }
}
