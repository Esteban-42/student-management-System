package service;
import model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteService {

    private List<Estudiante> estudiantes =  new ArrayList<>();

    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }

    public void mostrarEstudiantes(){
        if (estudiantes.isEmpty()){
            System.out.println("No hay estudiantes registrados");
            return;
        }
        for (Estudiante e : estudiantes){
            System.out.println(e);
        }
    }

    public boolean eliminarEstudiante(int id){
        for (Estudiante e : estudiantes){
            if (e.getId() == id){
                estudiantes.remove(e);
                return true;
            }
        }
        return false;
    }
}
