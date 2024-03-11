package org.cibertec.edu.pe.model;

import java.util.Date;

public class VentaBoleto {

    private String ciudadOrigen;
    private String ciudadDestino;
    private String fechaSalida;
    private String fechaRetorno;
    private String nombreComprador;
    private int cantidad;
    private double subTotal;

    // Constructor
    public VentaBoleto(String ciudadOrigen, String ciudadDestino, String fechaSalida, String fechaRetorno, String nombreComprador, int cantidad, double subTotal) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.nombreComprador = nombreComprador;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public VentaBoleto() {
	}

	// Getters y Setters
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

	public Date getFechaViaje() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getFechaViaje() {
		// TODO Auto-generated method stub
		return null;
	}
}
