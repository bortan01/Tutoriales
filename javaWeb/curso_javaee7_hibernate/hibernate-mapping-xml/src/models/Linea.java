package models;

import java.io.Serializable;

public class Linea implements Serializable{
    private int id;
    private String descripcion;
    
    public Linea(){
    }
    
    public Linea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}