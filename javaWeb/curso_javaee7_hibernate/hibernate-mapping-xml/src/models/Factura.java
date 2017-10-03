package models;
import java.io.Serializable;
import java.util.*;
public class Factura implements Serializable {
    
    private int id;
    private String cliente;
    private Set<Linea> lineas;
    
    public Factura(){
    }
    
    public Factura(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(Set<Linea> lineas) {
        this.lineas = lineas;
    }
    
    
}