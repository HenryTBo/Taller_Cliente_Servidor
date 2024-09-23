/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Vehiculo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Clase la cual presenta los metodos necesarios para gestionar los objetos de tipo Vehiculo. 
 * @author Henry
 */
public class GestionVehiculos {
    Conexion conexion = new Conexion();
    ResultSet resultado = null;
    Vehiculo vehiculo = new Vehiculo();
    
    /**
     * Metodo para consultar la informacion de la tabla vehiculos de la base de datos
     */
    public void consultarVehiculo(){
        try{
            conexion.setConexion();
            conexion.setConsulta("select idVehiculo,clienteid,Modelo,Placa,Notas,Servicios from vehiculos");
            resultado = conexion.getResultado();
            List<String> vehiculos = new ArrayList<>();
            
            while(resultado.next()){
            String idCliente = resultado.getString("clienteid");
            String idVehiculo = resultado.getString("idVehiculo");
            String modelo = resultado.getString("Modelo");
            String placa = resultado.getString("Placa");
            String notas = resultado.getString("Notas");
            String servicios = resultado.getString("Servicios");

                String vehiculosInfo = "idCliente:" + idCliente + "-" + "idVehiculo: " + idVehiculo + "-" + " Modelo: " + modelo + "-" + " Placa: " + placa + "-" + " Notas: " + notas + "-" + " Servicio: " + servicios;
                vehiculos.add(vehiculosInfo);
            }
               conexion.cerrarConexion();
               
               JComboBox<String> comboBox = new JComboBox<>(vehiculos.toArray(new String[0]));
                JOptionPane.showMessageDialog(null, comboBox, "Información del Vehiculo", JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException error){
            error.printStackTrace();
        }
    }
    /**
     * Metodo para insertar un vehiculo a la tabla vehiculos de la base de datos
     * se recibe como parametros los datos necesarios por la tabla.
     * @param Vehiculo dato.
     */
    public void insertarVehiculo(Vehiculo dato){
        try{
            conexion.setConexion();
            conexion.setConsulta("Insert into vehiculos (clienteid,Modelo,Placa,Marchamo,Rtv,Notas,Servicios) VALUES (?,?,?,?,?,?,?)");
            conexion.getConsulta().setInt(1, Integer.valueOf(dato.getClienteId()));
            conexion.getConsulta().setString(2, dato.getModelo());
            conexion.getConsulta().setString(3, dato.getPlaca());
            conexion.getConsulta().setString(4, dato.getMarchamo());
            conexion.getConsulta().setString(5, dato.getRtv());
            conexion.getConsulta().setString(6, dato.getNotas());
            conexion.getConsulta().setString(7, dato.getServicio());
            
            
            if(conexion.getConsulta().executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Vehiculo guardado");
            }else{
                JOptionPane.showMessageDialog(null,"Error en la operacion");
            }
            conexion.cerrarConexion();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * Metodo para eliminar vehiculo de la tabla vehiculos de la base de datos
     * recibe como parametro id del vehiculo para realizar la busqueda
     * @param idVehiculo 
     */
    public void eliminarVehiculo(int idVehiculo){
        try{
            conexion.setConexion();
            conexion.setConsulta("delete from vehiculos where idVehiculo="+ idVehiculo);
            if(conexion.getConsulta().executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Vehiculo eliminado");
            }else{
                JOptionPane.showMessageDialog(null,"Error en la operacion");
            }
            conexion.cerrarConexion();
        }catch(SQLException e){
            e.printStackTrace();
            }
    }
    /**
     * Metodo el cual crea un objeto vehiculo segun la informacion de la tabla vehiculos ligada
     * al parametro de busqueda idVehiculo.
     * retorna un objeto de tipo Vehiculo
     * @param idVehiculo
     * @return 
     */
    public Vehiculo optenerDatosVehiculoPorID(int idVehiculo){
        try{
            conexion.setConexion();
            conexion.setConsulta("select clienteid,modelo,placa,marchamo,rtv,notas,servicios from vehiculos where idVehiculo = " + idVehiculo);
            resultado = conexion.getResultado();

            while(resultado.next()){                        
            String clienteId = resultado.getString("clienteid");
            String modelo = resultado.getString("modelo");
            String placa = resultado.getString("placa");
            String marchamo = resultado.getString("marchamo");
            String rtv = resultado.getString("rtv");
            String notas = resultado.getString("notas");
            String servicio = resultado.getString("servicios");
            
            vehiculo = new Vehiculo(clienteId,modelo,placa,marchamo,rtv,notas,servicio);
            
            }
               conexion.cerrarConexion();

        }catch(SQLException error){
            error.printStackTrace();
        }
        
        return vehiculo;
    }
}
