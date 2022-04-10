
package modeloDAO;

import config.Conexion;
import Interfaces.ValidarEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Empleado;


public class EmpleadoDAO implements ValidarEmpleado{

     Connection con;
    Conexion cn = new Conexion ();
    PreparedStatement ps;
    ResultSet rs;
    
    
    /**
     * metodo que recibe como param un objeto de tipo Empleado, y me traera los datos del empleado cuando el user y password
     * coincidan con el objeto que recibio.
     * @param emple
     * @return 
     */
    @Override
    public int ValidarEmple(Empleado emple) {
        
         int resultado =0;
    
       String sql = "Select * from empleado where user=? and password=?";
       
       try{
           con = cn.getConnection();
           ps= con.prepareStatement(sql);
           ps.setString(1, emple.getUser());
           ps.setString(2, emple.getPassword());
           rs = ps.executeQuery();
           
           while(rs.next()){
               resultado = resultado +1;
               emple.setUser(rs.getString("user"));
               emple.setPassword(rs.getString("password"));
           }
           if(resultado ==1){
               return 1;
           }else{
               return 0;
           }
       }catch(Exception e){
           return 0;
       }
    }
    
}
