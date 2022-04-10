
package modeloDAO;

import config.Conexion;
import Interfaces.ValidarCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Compra;


public class ClienteDAO implements ValidarCliente{
    
    
    
  
    Connection con;
    Conexion cn = new Conexion ();
    PreparedStatement ps;
    ResultSet rs;
    int resultado =0;
    
    /**
     *Metodo que recibe como param un objeto de tipo cliente, y en la query me trae los datos solo si 
     * el user y y el password que le pase por mi servlet estan en la BDD;
     * valida si los datos ingresados en el login son correctos para dejar o no ingresar al menu
     * @param cli
     * @return 
     */
    
    @Override
    public int ValidarCli(Cliente cli) {
         int resultado =0;
    
       String sql = "Select * from cliente where user=? and password=?";
       
       try{
           con = cn.getConnection();
           ps= con.prepareStatement(sql);
           ps.setString(1, cli.getUser());
           ps.setString(2, cli.getPassword());
           rs = ps.executeQuery();
           
           while(rs.next()){
               resultado = resultado +1;
               cli.setUser(rs.getString("user"));
               cli.setPassword(rs.getString("password"));
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
/**
 * Metodo de tipo boolean que recibe como param un objeto de tipo Cliente y en la query inserta los valores
 * que me dio el servlet y se hace un executeUpdate.
 * @param cli
 * @return 
 */
    @Override
    public boolean add(Cliente cli) {
        
         String sql = "insert into cliente(nombre,apellido,user,password)values('"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getUser()+"','"+cli.getPassword()+"')";
        try{ 
       con=cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }
    
      

    
    
}
