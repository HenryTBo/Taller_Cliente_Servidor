/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Clase la cual presenta los metodos necesarios para la gestion de datos tipo Cliente. 
 * @author Henry
 */
public class GestionCliente {
    Conexion conexion = new Conexion();
    ResultSet resultado = null;
    Cliente cliente = new Cliente();
    
    /**
     * Metodo para establecer conexion con la base de datos y consultar la informacion de la tabla
     * clientes.
     */
    public void consultarCliente(){
        try{
            conexion.setConexion();
            conexion.setConsulta("select idCliente,nombre,numero,correo from clientes");
            resultado = conexion.getResultado();
            
            List<String> clientes = new ArrayList<>();
            while(resultado.next()){
            String idCliente = resultado.getString("idCliente");
            String nombre = resultado.getString("nombre");
            String numero = resultado.getString("numero");
            String correo = resultado.getString("correo");

                String clienteInfo = "idCliente: " + idCliente + " - Nombre: " + nombre + " - Número: " + numero + " - Correo: " + correo;
                clientes.add(clienteInfo);
            }
            conexion.cerrarConexion();
               
            JComboBox<String> comboBox = new JComboBox<>(clientes.toArray(new String[0]));
            JOptionPane.showMessageDialog(null, comboBox, "Información del Cliente", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException error){
            error.printStackTrace();
        }
    }
    
    /**
     * Metodo para establecer conexion con la base de datos y consultar la informacion de la tabla
     * clientes relacionada a un cliente en especifico
     * Recibe como parametro idConsulta, la cual es el id del cliente a buscar.
     * @param idConsulta 
     */
    public void consultarClientePorID(int idConsulta){
        try{
            conexion.setConexion();
            conexion.setConsulta("select nombre,numero,correo from clientes where idCliente = " + idConsulta);
            resultado = conexion.getResultado();

            while(resultado.next()){
            String nombre = resultado.getString("nombre");
            String numero = resultado.getString("numero");
            String correo = resultado.getString("correo");

                JOptionPane.showMessageDialog(null,"Nombre: " + nombre + "-" + " Numero: " + numero + "-" + " Correo: " + correo);
            }
               conexion.cerrarConexion();

        }catch(SQLException error){
            error.printStackTrace();
        }
    }
    
    /**
     * Metodo para insertar los datos de un cliente a la tabla clientes de la base de datos
     * Se recibe como parametros los datos necesarios para completar las columnas de la tabla.
     * @param Cliente dato.
     */
    public void insertarCliente(Cliente dato){
        try{
            conexion.setConexion();
            conexion.setConsulta("Insert into clientes(nombre,numero,correo) VALUES (?,?,?)");
            conexion.getConsulta().setString(1, dato.getNombre());
            conexion.getConsulta().setString(2, dato.getNumero());
            conexion.getConsulta().setString(3, dato.getCorreo());

            if(conexion.getConsulta().executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Cliente guardado");
            }else{
               JOptionPane.showMessageDialog(null,"Error en la operacion");
            }
            conexion.cerrarConexion();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo para modificar un cliente de la tabla clientes de la base de datos por medio de id
     * Recibe como parametros el nombre de la columna y id del cliente que se desea modificar y el dato
     * que se desea sobreescribir
     * @param columna
     * @param dato
     * @param id 
     */
    public void modificarCliente(String columna, String dato, String id){
        try{
            conexion.setConexion();
            System.out.println("Update clientes set " + columna + "= '"+dato+"' where idCliente =" + id);
            conexion.setConsulta("Update clientes set " + columna + "= '"+dato+"' where idCliente =" + id);
            if(conexion.getConsulta().executeUpdate() >0){
                System.out.println("Cliente Modificado");
            }else{
                System.out.println("Error en la operacion");
            }
            conexion.cerrarConexion();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo para eliminar un cliente de la tabla clientes de la base de datos por medio de 
     * un parametro de busqueda id
     * @param id 
     */
    public void eliminarCliente(int id){
        try{
            conexion.setConexion();
            conexion.setConsulta("delete from clientes where idCliente="+ id);
            if(conexion.getConsulta().executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Cliente eliminado");
            }else{
                JOptionPane.showMessageDialog(null,"Error en la operacion");
            }
            conexion.cerrarConexion();
        }catch(SQLException e){
            e.printStackTrace();
            }
    }
    
    /**
     * Metodo para crear un objeto cliente segun la informacion de la tabla clientes ligada 
     * al parametro de busqueda idCliente
     *  retorna un objeto de tipo Cliente
     * @param idCliente
     * @return 
     */
    public Cliente optenerDatosClientePorID(int idCliente){
        try{
            conexion.setConexion();
            conexion.setConsulta("select nombre,numero,correo from clientes where idCliente = " + idCliente);
            resultado = conexion.getResultado();

            while(resultado.next()){                        
            String nombre = resultado.getString("nombre");
            String numero = resultado.getString("numero");
            String correo = resultado.getString("correo");

            
            cliente = new Cliente(nombre,numero,correo);
            
            }
               conexion.cerrarConexion();

        }catch(SQLException error){
            error.printStackTrace();
        }
        
        return cliente;
    }
}
