
package config;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    //creo un objeto de la clase Connection
    Connection con;
    
    /**
     * es un metodo de tipo connection donde pongo mi driver MySql que antes ya lo tuve que haber 
     * puesto en mis librerias, y establezco mi direccion de la BDD.
     * @return 
     */
    public Connection getConnection(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //aca va la url de la BDD
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/cellphone","root","");
        }catch(Exception e){
            
        }
        //retorna la conexion
        return con;
    }
    
    
}
