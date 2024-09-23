/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *  Clase para crear objetos de tipo Cliente
 * @author Henry
 */
public class Cliente {
    String nombre;
    String numero;
    String correo;


    public Cliente(String nombre, String numero, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
    }

    public Cliente() {
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getCorreo() {
        return correo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 
}
