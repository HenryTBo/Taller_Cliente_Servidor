/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Historico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase la cual presenta los metodos para gestionar los objetos de tipo Historico.
 * @author Henry
 */
public class GestionHistorico {
    Conexion conexion = new Conexion();
    ResultSet resultado = null;
    
    /**
     * Metodo para insertar informacion de las facturas a la tabla historicos de la base de datos
     * recibe como parametros los datos necesarios para la tabla
     * @param Historico dato
     */
    public void insertarFactura(Historico dato){
        try{
            conexion.setConexion();
            conexion.setConsulta("Insert into historico(nombreCliente,placaVehiculo,servicio,precio) VALUES (?,?,?,?)");
            conexion.getConsulta().setString(1, dato.getNombreCliente());
            conexion.getConsulta().setString(2, dato.getPlacaVehiculo());
            conexion.getConsulta().setString(3, dato.getServicio());
            conexion.getConsulta().setString(4, dato.getPrecio());
            
            if(conexion.getConsulta().executeUpdate() > 0){
                System.out.print("Factura guardada");
            }else{
                JOptionPane.showMessageDialog(null,"Error en la operacion");
            }
            conexion.cerrarConexion();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * Metodo para crear objeto Historico segun la informacion de la tabla historicos filtrada por fecha
     * Retorna una objeto Historico
     * @return 
     */
    public List<Historico> obtenerTablaHistoricos() {
        List<Historico> historicos = new ArrayList<>();
        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT * FROM historico order by fecha desc");
            resultado = conexion.getResultado();
            
            while (resultado.next()) {
                int idFactura = resultado.getInt("idFactura");
                Date fecha = resultado.getDate("fecha");
                String nombreCliente = resultado.getString("nombreCliente");
                String placaVehiculo = resultado.getString("placaVehiculo");
                String servicio = resultado.getString("servicio");
                String precio = resultado.getString("precio");
                
                Historico historico = new Historico(idFactura, fecha, nombreCliente, placaVehiculo, servicio,precio);
                historicos.add(historico);
            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historicos;
    }
}
