package mx.edu.utez.personal4b.model.calificaciones;

public class calificaciones {
    private int idCali;
    private int id;
    private String nameC;
    private String nameA;
    private int alumnoId;
    private int cali;

    public calificaciones() {
    }

    public calificaciones(int idCali, int id, String nameC, String nameA, int alumnoId, int cali) {
        this.idCali = idCali;
        this.id = id;
        this.nameC = nameC;
        this.nameA = nameA;
        this.alumnoId = alumnoId;
        this.cali = cali;
    }

    public int getIdCali() {
        return idCali;
    }

    public void setIdCali(int idCali) {
        this.idCali = idCali;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getCali() {
        return cali;
    }

    public void setCali(int cali) {
        this.cali = cali;
    }
}
