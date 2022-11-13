package mx.edu.utez.personal4b.controller.personal;

import mx.edu.utez.personal4b.model.alumno.Alumno;
import mx.edu.utez.personal4b.model.alumno.DaoAlumno;
import mx.edu.utez.personal4b.model.calificaciones.calificaciones;
import mx.edu.utez.personal4b.model.calificaciones.DaoCalificaciones;
import mx.edu.utez.personal4b.model.docente.DaoDocentes;
import mx.edu.utez.personal4b.model.docente.Docentes;
import mx.edu.utez.personal4b.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/escuela")
public class escuela {
    Map<String,Object> response = new HashMap<>();

    @GET @Path("/alumno")
    @Produces(value = {"application/json"})
    public List<Alumno> getAll(){
        return new DaoAlumno().findAll();
    }

    @GET @Path("/docente")
    @Produces(value = {"application/json"})
    public List<Docentes> getAlll(){
        return new DaoDocentes().findAll();
    }

    @GET @Path("/calificaciones")
    @Produces(value = {"application/json"})
    public List<calificaciones> getAl(){
        return new DaoCalificaciones().findAll();
    }

    @GET @Path("/calificaciones-promedio")
    @Produces(value = {"application/json"})
    public List<calificaciones> getA(){
        return new DaoCalificaciones().promedio();
    }

    @POST @Path("/alumno")
    @Consumes(value = {"application/json"}) @Produces(value = {"application/json"})
    public Map<String, Object> save(Alumno alu){
        Response<Alumno> result = new DaoAlumno().save(alu);
        response.put("result",result);
        return response;
    }
    @POST @Path("/docente")
    @Consumes(value = {"application/json"}) @Produces(value = {"application/json"})
    public Map<String, Object> save(Docentes doc){
        Response<Docentes> result = new DaoDocentes().save(doc);
        response.put("result",result);
        return response;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno getById(@PathParam("id") int id){
        Alumno personal = new Alumno();
        System.out.println(id);
        return new DaoAlumno().findById(id);
    }
    @GET
    @Path("/l{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Docentes getByIdd(@PathParam("id") int id){
        Docentes personal = new Docentes();
        System.out.println(id);
        return new DaoDocentes().findByIdd(id);
    }
    @PUT
    @Path("/alumno")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> update(Alumno alu){
        Response<Alumno> result = new DaoAlumno().update(alu);
        response.put("result",result);
        return response;
    }
    @PUT
    @Path("/docente")
    @Consumes(value = {"application/json"})
    @Produces(value = {"application/json"})
    public Map<String, Object> update(Docentes doc){
        Response<Docentes> result = new DaoDocentes().update(doc);
        response.put("result",result);
        return response;
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        System.out.println(id);
        return new DaoCalificaciones().delete(id);
    }
}