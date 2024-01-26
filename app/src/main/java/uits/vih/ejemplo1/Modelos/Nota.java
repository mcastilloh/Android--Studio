package uits.vih.ejemplo1.Modelos;

public class Nota {

    private String id;
    private String idAlumno;
    private String ciclo;
    private int nota;

    public Nota() {
    }

    public Nota(String id, String idAlumno, String ciclo, int nota) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.ciclo = ciclo;
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
