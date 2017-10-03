package hibernateholamundo;

import java.io.Serializable;

public class Persona implements Serializable {

    private int id;
    private String nombre;

    protected Persona() {
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
