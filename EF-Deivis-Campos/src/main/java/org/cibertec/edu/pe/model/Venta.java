package org.cibertec.edu.pe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int id;

    @Column(name = "nombre_comprador", nullable = false, length = 100)
    public String nombreComprador;

    @Column(name = "fecha_venta", nullable = false)
    @Temporal(TemporalType.DATE) // Formato de fecha: día, mes y año
    public Date fechaVenta;

    @Column(name = "monto_total", nullable = false)
    public Double montoTotal;

    @OneToMany(mappedBy = "venta")
    public List<DetalleVenta> detallesVenta;

	public Venta() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public List<DetalleVenta> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}

	public void setDetalleVenta(List<DetalleVenta> detallesVenta) {
		this.detallesVenta = detallesVenta;
		
	}
   
    
}
