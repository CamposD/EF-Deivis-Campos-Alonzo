package org.cibertec.edu.pe.model;


import javax.persistence.*;

@Entity
@Table(name = "tb_ciudad")
public class Ciudad {

    @Id
    @Column(name = "codigo_postal", nullable = false, length = 50)
    public String codigoPostal;

    @Column(name = "nombre", nullable = false, length = 100)
    public String nombre;
    
    
    

	public Ciudad() {
		super();
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    

   
    
    
}
