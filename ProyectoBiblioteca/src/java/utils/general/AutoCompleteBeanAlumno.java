package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Alumno;
import utils.lista.ListasAlumnos;

@ManagedBean(name = "autoCompleteBeanAlumno")
@SessionScoped
public class AutoCompleteBeanAlumno implements Serializable {

    @ManagedProperty("#{listasAlumnos}")
    ListasAlumnos alumnoData;
    Alumno alumno;

    public List<Alumno> completeAlumnoDespacho(String query) {
        List<Alumno> allAlumno = getAlumnoData().getLstAlumno();
        List<Alumno> filterAlumno = new ArrayList<Alumno>();
        for (Alumno alumnoSelected : allAlumno) {
            if (alumnoSelected.getCarnet().toLowerCase().startsWith(query) || alumnoSelected.getNombre().toLowerCase().startsWith(query)  || alumnoSelected.getApellido().toLowerCase().startsWith(query)) {
                filterAlumno.add(alumnoSelected);
            }
        }
        return filterAlumno;
    }
    
    
    public ListasAlumnos getAlumnoData() {
        return alumnoData;
    }

    public void setAlumnoData(ListasAlumnos alumnoData) {
        this.alumnoData = alumnoData;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
