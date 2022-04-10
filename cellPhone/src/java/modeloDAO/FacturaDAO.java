
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.CarritoCliente;
import modelo.Cliente;
import modelo.Compra;


public class FacturaDAO {
    
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /**
     * metodo que me trae la lista de detalle de compra
     * @return 
     */
    public List listar (){
         ArrayList<Compra>list = new ArrayList<>();
         String sql = "select * from compra";
         
         try{
              con=cn.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               Compra compra = new Compra();
               compra.setId(rs.getInt("id"));
               compra.setIdPago(rs.getInt("idPago"));
               compra.setEstado(rs.getString("estado"));
               compra.setMonto(rs.getDouble("monto"));
               list.add(compra);
            }
         }catch(Exception e){
             
         }
        return list;
    }
    
}
