package mx.edu.utez.personal4b.model.alumno;

public class Alumno {
    private   int id;
    private String name;
    private  String lastname;
    private String fecha;
    private String curp;
    private String matricula;

    public Alumno() {
    }

    public Alumno(int id, String name, String lastname, String fecha, String curp, String matricula) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.fecha = fecha;
        this.curp = curp;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
