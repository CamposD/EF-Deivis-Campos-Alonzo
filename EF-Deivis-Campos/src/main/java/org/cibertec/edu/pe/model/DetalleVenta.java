package org.cibertec.edu.pe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_detalle_venta")
public class DetalleVenta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	public int id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_postal_destino", referencedColumnName = "codigo_postal")
    public Ciudad ciudadDestino;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_postal_origen", referencedColumnName = "codigo_postal")
    public Ciudad ciudadOrigen;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    public Venta venta;

    @Column(name = "cantidad", nullable = false)
    public Integer cantidad;

    @Column(name = "fecha_viaje", nullable = false)
    public Date fechaViaje;

    @Column(name = "fecha_retorno", nullable = false)
    public Date fechaRetorno;

    @Column(name = "sub_total", nullable = false, scale = 2)
    public Double subTotal;

    
    
    
    

	public DetalleVenta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaViajeStr() {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    return formatter.format(this.fechaViaje);
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

	public String getFechaRetornoStr() {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    return formatter.format(this.fechaRetorno);
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public void setFechaRetorno(String fechaRetorno2) {
		// TODO Auto-generated method stub
		
	}

	public void setCiudadOrigen(String ciudadOrigen2) {
		// TODO Auto-generated method stub
		
	}

	public void setCiudadDestino(String ciudadDestino2) {
		// TODO Auto-generated method stub
		
	}


    
    
}
