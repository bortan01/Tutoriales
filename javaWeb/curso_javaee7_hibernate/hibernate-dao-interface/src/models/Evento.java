/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Andrés Guzmán
 */
public class Evento implements Serializable{
    private Integer id;
    private int duracion;
    private String nombre;
    private Date fechaInicio;

    public Evento() {

    }

    public Evento(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
