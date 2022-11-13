package mx.edu.utez.personal4b.model.alumno;

import mx.edu.utez.personal4b.model.Repository;
import mx.edu.utez.personal4b.model.calificaciones.DaoCalificaciones;
import mx.edu.utez.personal4b.model.calificaciones.calificaciones;
import mx.edu.utez.personal4b.model.docente.Docentes;
import mx.edu.utez.personal4b.utils.MySQLConnection;
import mx.edu.utez.personal4b.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoAlumno implements Repository <Alumno> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();
    @Override
    public List<Alumno> findAll() {
        List<Alumno> prendas = new ArrayList<>();
        calificaciones cali = null;
        Alumno alumno = null;

        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("select * from alumno  ;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                cali = new calificaciones();
                alumno = new Alumno();

                alumno.setId(rs.getInt("id"));
                alumno.setName(rs.getString("nameA"));
                alumno.setLastname(rs.getString("lastname"));
                alumno.setFecha(rs.getString("fecha"));
                alumno.setFecha(rs.getString("curp"));


                prendas.add(alumno);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        } finally {
            client.close(connection, pstm, rs);
        }
        return prendas;
    }

    @Override
    public List<Alumno> promedio() {
        return null;
    }


    @Override
    public List<calificaciones> get() {
        return null;
    }

    @Override
    public Alumno findById(int id) {
        Alumno alu = new Alumno();
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM alumno WHERE id = ?;");
            pstm.setLong(1,id);
            rs = pstm.executeQuery();
            while(rs.next()) {

                Alumno alumno = new Alumno();

                alumno = new Alumno();


                alumno.setId(rs.getInt("id"));
                alumno.setName(rs.getString("nameA"));
                alumno.setLastname(rs.getString("lastname"));
                alumno.setFecha(rs.getString("fecha"));
                alumno.setFecha(rs.getString("curp"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
        }finally{
            client.close(connection,pstm,rs);
        }
        return alu;
    }

    @Override
    public Docentes findByIdd(int id) {
        return null;
    }

    @Override
    public Response save(Alumno cali) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("INSERT INTO calificaciones (nameA,lastname,fecha,curp ) " +
                    "VALUES (?,?,?,?);");
            pstm.setString(1,cali.getName());
            pstm.setString(2,cali.getLastname());
            pstm.setString(3,cali.getFecha());
            pstm.setString(3,cali.getCurp());
           ;
            if(pstm.executeUpdate() == 1){
                return new Response<Alumno>(200,"Registro exitoso",cali,false);
            }else{
                return new Response<Alumno>(200,"Error de registro. Intente nuevamente",cali,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE,"Error -> findAll"+e.getMessage());
            return new Response<>(400,"Error con el servidor",null,true);

        }finally {
            client.close(connection,pstm,rs);
        }
    }

    @Override
    public Response update(Alumno cali) {
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE docente SET name = ?,apellido=?,nacimiento=?,curp=? where id = ?;");
            pstm.setString(1,cali.getName());
            pstm.setString(2,cali.getLastname());
            pstm.setString(3,cali.getFecha());
            pstm.setString(3,cali.getCurp());
            if (pstm.executeUpdate() == 1) {
                return new Response<Alumno>(200, "Actualizado exitoso", cali, false);
            } else {
                return new Response<Alumno>(200, "Error de actualizado. Intente nuevamente", cali, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
            return new Response<Alumno>(200,"Error con el servidor",cali,true);
        }
    }

    @Override
    public Response delete(Long id) {
        return null;
    }
}
