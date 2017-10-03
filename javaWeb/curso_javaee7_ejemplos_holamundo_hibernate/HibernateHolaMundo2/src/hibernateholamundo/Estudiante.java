/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateholamundo;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private int id;
    private String colegio;
    private String grado;
   
    protected Estudiante() {
    }
   
    public Estudiante(int id, String colegio) {
        this.id = id;
        this.colegio = colegio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    
}
