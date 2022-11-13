package mx.edu.utez.personal4b.model.calificaciones;

import mx.edu.utez.personal4b.model.Repository;

import mx.edu.utez.personal4b.model.alumno.Alumno;
import mx.edu.utez.personal4b.model.docente.Docentes;
import mx.edu.utez.personal4b.utils.MySQLConnection;
import mx.edu.utez.personal4b.utils.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DaoCalificaciones implements Repository<calificaciones> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();


    //consultar calificaciones de alumnos
    @Override
    public List<calificaciones> findAll() {
        List<calificaciones> prendas = new ArrayList<>();
        calificaciones cali = null;
        Alumno alumno = null;

        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("select * from calificaciones\n" +
                    "inner join alumno e on calificaciones.alumnoId = e.id  ;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                cali = new calificaciones();
                alumno = new Alumno();

                cali.setId(rs.getInt("idcali"));
                cali.setNameC(rs.getString("nameC"));
                cali.setCali(rs.getInt("int"));
                alumno.setName(rs.getString("nameA"));


                prendas.add(cali);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        } finally {
            client.close(connection, pstm, rs);
        }
        return prendas;
    }
//promedio
    @Override
    public List<calificaciones> promedio() {
        List<calificaciones> ca = new ArrayList<>();
        calificaciones cali = null;
        Alumno alumno = null;

        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("select avg(cali) as promedio from calificaciones;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                cali = new calificaciones();
                alumno = new Alumno();


                cali.setCali(rs.getInt("promedio"));



                ca.add(cali);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        } finally {
            client.close(connection, pstm, rs);
        }
        return ca;
    }





    @Override
    public List<calificaciones> get() {
        return null;
    }

    @Override
    public Alumno findById(int id) {
        return null;
    }

    @Override
    public Docentes findByIdd(int id) {
        return null;
    }

    @Override
    public Response save(calificaciones object) {
        return null;
    }

    @Override
    public Response update(calificaciones object) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }
  /*





    @Override
    public Response delete(Long id) {
        return null;
    }*/
}
