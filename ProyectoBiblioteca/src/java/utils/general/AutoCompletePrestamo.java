package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import utils.lista.ListasPrestamos;
import modelo.entidades.PrestamoAlumno;

@ManagedBean (name = "autoCompletePrestamo")
@SessionScoped
public class AutoCompletePrestamo implements Serializable{

    @ManagedProperty("#{listasPrestamos}")
    ListasPrestamos prestamoData;
    PrestamoAlumno prestamo;
    
     public List<PrestamoAlumno> completeLibroDespacho(String query) {
        List<PrestamoAlumno> allPrestamo = getPrestamoData().getLstPrestamo();
        List<PrestamoAlumno> filtroPrestamo = new ArrayList<PrestamoAlumno>();
        for (PrestamoAlumno PrestamoSeleccionado : allPrestamo) {
            //para que es star witches
            if (PrestamoSeleccionado.getCodigoPrestamo().toLowerCase().startsWith(query) || PrestamoSeleccionado.getCarnetAlumno().getNombre().toLowerCase().startsWith(query)) {
                filtroPrestamo.add(PrestamoSeleccionado);
            }
        }
        return filtroPrestamo;
    }
    
   
    public AutoCompletePrestamo() {
    }

    public ListasPrestamos getPrestamoData() {
        return prestamoData;
    }

    public void setPrestamoData(ListasPrestamos prestamoData) {
        this.prestamoData = prestamoData;
    }

    public PrestamoAlumno getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(PrestamoAlumno prestamo) {
        this.prestamo = prestamo;
    }
    
    
    
    
}

