package mx.edu.utez.personal4b.model;

import mx.edu.utez.personal4b.model.alumno.Alumno;
import mx.edu.utez.personal4b.model.calificaciones.calificaciones;
import mx.edu.utez.personal4b.model.docente.Docentes;
import mx.edu.utez.personal4b.utils.Response;

import java.util.List;

public interface Repository <T>{
    List<T> findAll();

    List<T> promedio();
    List<calificaciones> get();

    Alumno findById(int id);

    Docentes findByIdd(int id);


    Response save(T object);
    Response update(T object);

    Response delete(Long id);

}
