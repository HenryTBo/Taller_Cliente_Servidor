/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 * Clase para crear objetos de tipo Historico
 * @author Henry
 */
public class Historico {
    int idFactura;
    Date fecha;
    String nombreCliente;
    String placaVehiculo;
    String servicio;
    String precio;

    public Historico(int idFactura, Date fecha, String nombreCliente, String placaVehiculo, String servicio, String precio) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.placaVehiculo = placaVehiculo;
        this.servicio = servicio;
        this.precio = precio;
    }

    public Historico() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }  
}
