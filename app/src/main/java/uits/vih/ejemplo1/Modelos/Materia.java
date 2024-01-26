package uits.vih.ejemplo1.Modelos;

public class Materia {

    private String id;
    private String nombre;
    private String uval;

    public Materia() {
    }

    public Materia(String id, String nombre, String uval) {
        this.id = id;
        this.nombre = nombre;
        this.uval = uval;
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

    public String getUval() {
        return uval;
    }

    public void setUval(String uval) {
        this.uval = uval;
    }
}
