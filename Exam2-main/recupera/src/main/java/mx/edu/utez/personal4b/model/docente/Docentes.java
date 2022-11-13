package mx.edu.utez.personal4b.model.docente;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Docentes {
    private   int id;
    private String name;
    private  String apellido;
    private String nacimiento;
    private String curp;
    private int num_empleado;

    public Docentes() {
    }

    public Docentes(int id, String name, String apellido, String nacimiento, String curp, int num_empleado) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.curp = curp;
        this.num_empleado = num_empleado;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }
}