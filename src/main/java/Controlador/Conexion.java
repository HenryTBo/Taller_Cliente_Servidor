 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que realiza la conexion con la base de datos.
 * @author Henry
 */
public class Conexion {  
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    //Your mySQL info
    String url = "";
    String username = "";
    String password = "";
    
    public void setConexion(){
        try{
          this.conexion = DriverManager.getConnection(url,username,password);
        }catch(SQLException error){
            error.printStackTrace();
        }
    }
    
    public void setConsulta(String consulta){
        try{
            this.consulta = conexion.prepareStatement(consulta);
        }catch(SQLException error){
            error.printStackTrace();
        }
    }
    
    public ResultSet getResultado(){
        try{
            return consulta.executeQuery();
        }catch(SQLException error){
            error.printStackTrace();
            return null;
        }
    }
    
    public PreparedStatement getConsulta(){
        return consulta;
    }
    
    public void cerrarConexion(){        
        if(resultado != null){
            try{
            resultado.close(); 
            }catch(SQLException error){
                error.printStackTrace();
            }
            
            if(consulta != null){
                try{
                    consulta.close();
                }catch(SQLException error){
                    error.printStackTrace();
                }
            }
           
            if(conexion != null){
                try{
                    conexion.close();
                }catch(SQLException error){
                    error.printStackTrace();
                }
            }
            
        }
    }
}
