package modelo;
// Generated 08-22-2017 09:02:14 AM by Hibernate Tools 4.3.1



/**
 * Municipio generated by hbm2java
 */
public class Municipio  implements java.io.Serializable {


     private int idmunicipio;
     private Departamento departamento;
     private String nombremunicipio;

    public Municipio() {
    }

	
    public Municipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }
    public Municipio(int idmunicipio, Departamento departamento, String nombremunicipio) {
       this.idmunicipio = idmunicipio;
       this.departamento = departamento;
       this.nombremunicipio = nombremunicipio;
    }
   
    public int getIdmunicipio() {
        return this.idmunicipio;
    }
    
    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getNombremunicipio() {
        return this.nombremunicipio;
    }
    
    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }




}


