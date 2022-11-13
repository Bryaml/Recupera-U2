package mx.edu.utez.personal4b.model.docente;

import mx.edu.utez.personal4b.model.Repository;
import mx.edu.utez.personal4b.model.alumno.Alumno;
import mx.edu.utez.personal4b.model.calificaciones.DaoCalificaciones;
import mx.edu.utez.personal4b.model.calificaciones.calificaciones;
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

public class DaoDocentes  implements Repository<Docentes> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();
    @Override
    public List<Docentes> findAll() {
        List<Docentes> doc = new ArrayList<>();
        Docentes docentes = null;
        Alumno alumno = null;
        calificaciones cali = null;
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("select * from docente  ;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                docentes = new Docentes();
                alumno = new Alumno();
                cali = new calificaciones();
                docentes.setId(rs.getInt("id"));
                docentes.setName(rs.getString("name"));
                docentes.setApellido(rs.getString("apellido"));
                docentes.setNacimiento(rs.getString("nacimiento"));
                docentes.setCurp(rs.getString("curp"));


                doc.add(docentes);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
        } finally {
            client.close(connection, pstm, rs);
        }
        return doc;
    }

    @Override
    public List<Docentes> promedio() {
        return null;
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
        Docentes docente = new Docentes();
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM docente WHERE id = ?;");
            pstm.setLong(1,id);
            rs = pstm.executeQuery();
            while(rs.next()) {


                docente = new Docentes();


                docente.setId(rs.getInt("id"));
                docente.setName(rs.getString("name"));
                docente.setApellido(rs.getString("apellido"));
                docente.setNacimiento(rs.getString("nacimiento"));
                docente.setCurp(rs.getString("curp"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
        }finally{
            client.close(connection,pstm,rs);
        }
        return docente;
    }

    @Override
    public Response save(Docentes cali) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("INSERT INTO calificaciones (name,apellido,nacimiento,curp ) " +
                    "VALUES (?,?,?,?);");
            pstm.setString(1,cali.getName());
            pstm.setString(2,cali.getApellido());
            pstm.setString(3,cali.getNacimiento());
            pstm.setString(3,cali.getCurp());
            ;
            if(pstm.executeUpdate() == 1){
                return new Response<Docentes>(200,"Registro exitoso",cali,false);
            }else{
                return new Response<Docentes>(200,"Error de registro. Intente nuevamente",cali,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE,"Error -> findAll"+e.getMessage());
            return new Response<>(400,"Error con el servidor",null,true);

        }finally {
            client.close(connection,pstm,rs);
        }
    }

    public Response update(Docentes cali) {
        try {
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE docente SET name = ?,apellido=?,nacimiento=?,curp=? where id = ?;");
            pstm.setString(1,cali.getName());
            pstm.setString(2,cali.getApellido());
            pstm.setString(3,cali.getNacimiento());
            pstm.setString(3,cali.getCurp());
            if (pstm.executeUpdate() == 1) {
                return new Response<Docentes>(200, "Actualizado exitoso", cali, false);
            } else {
                return new Response<Docentes>(200, "Error de actualizado. Intente nuevamente", cali, true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCalificaciones.class.getName()).log(Level.SEVERE,"Error -> findAll"+ e.getMessage());
            return new Response<Docentes>(200,"Error con el servidor",cali,true);
        }
    }

    @Override
    public Response delete(Long id) {
        return null;
    }
}
