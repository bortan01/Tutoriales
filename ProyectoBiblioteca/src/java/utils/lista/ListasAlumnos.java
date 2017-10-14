package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Alumno;
import session.beans.AlumnoFacade;

@ManagedBean(name = "listasAlumnos")
@SessionScoped
public class ListasAlumnos implements Serializable {

    @Inject
    AlumnoFacade alumnoFacade;
    public List<Alumno> lstAlumno;

    @PostConstruct
    public void init() {
        lstAlumno = llenarLista();
    }

    public List<Alumno> llenarLista() {
        return alumnoFacade.findAll();
    }
    
  
    public AlumnoFacade getAlumnoFacade() {
        return alumnoFacade;
    }

    public void setAlumnoFacade(AlumnoFacade alumnoFacade) {
        this.alumnoFacade = alumnoFacade;
    }

    public List<Alumno> getLstAlumno() {
        return lstAlumno;
    }

    public void setLstAlumno(List<Alumno> lstAlumno) {
        this.lstAlumno = lstAlumno;
    }
}
