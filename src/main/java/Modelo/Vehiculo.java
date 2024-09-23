/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *  Clase para crear obejetos de tipo Vehiculo
 * @author Henry
 */
public class Vehiculo {
    String clienteId;
    String modelo;
    String placa;
    String marchamo;
    String rtv;
    String notas;
    String servicio;

    public Vehiculo(String clienteId, String modelo, String placa, String marchamo, String rtv, String notas, String servicio) {
        this.clienteId = clienteId;
        this.modelo = modelo;
        this.placa = placa;
        this.marchamo = marchamo;
        this.rtv = rtv;
        this.notas = notas;
        this.servicio = servicio;
    }
    public Vehiculo() {
    }
 
  
    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getNotas() {
        return notas;
    }

    public String getServicio() {
        return servicio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getMarchamo() {
        return marchamo;
    }

    public void setMarchamo(String marchamo) {
        this.marchamo = marchamo;
    }

    public String getRtv() {
        return rtv;
    }

    public void setRtv(String rtv) {
        this.rtv = rtv;
    }
  
}
