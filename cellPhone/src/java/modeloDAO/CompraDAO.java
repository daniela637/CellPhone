
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.CarritoCliente;
import modelo.Cliente;

import modelo.Compra;


public class CompraDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
  
    /**
     * metodo que recibe como parametro un objeto de tipo compra, y va a guardarla en la tabla si todo esta bien
     * @param compra
     * @return 
     */
    public int generarCompra(Compra compra){
        
        int idCompras;
        //sentencia para insertar los datos a la tabla
        String sql = "insert into compra (idCliente,monto,estado,idPago) values (?,?,?,?)";
        
        try{
            
            
            
            con=cn.getConnection();
            ps = con.prepareStatement(sql);
         //seteo los datos que traigo de mi objeto compra
            ps.setInt(1, compra.getCliente().getId());
            ps.setDouble(2, compra.getMonto());
            ps.setString(3, compra.getEstado());
            ps.setInt(4, compra.getIdPago());
            //mi preparedStatement ejecuta la query y me devulve v o falso segun como salio la accio y la guardo en la variable r
             r = ps.executeUpdate();
            
           
             //
            sql = "select @@IDENTITY AS id";
            rs = ps.executeQuery(sql);
            rs.next();
            idCompras = rs.getInt("id");
            rs.close();
            //aca inseratia en una tabla nueva el detalle de la compra en detalleCompra que esta relacionada
            for(CarritoCliente detalle : compra.getDetalleCompra()){
              sql="insert into detalleCompra(idArticulo,idCompra,cantidad,precioCompra)values(?,?,?,?)"; 
               ps = con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdArticulo());
                ps.setInt(2, idCompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioCompra());
                r=ps.executeUpdate();
            } 
            
        }catch(Exception e){
            
        }
        return r;
    }

  

  
    
    
    
    
    
    
}
