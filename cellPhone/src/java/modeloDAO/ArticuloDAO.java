
package modeloDAO;

import Interfaces.CRUD;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Articulo;


public class ArticuloDAO implements CRUD{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Articulo arti = new Articulo();
    
    

    /**
     * este metodo de tipo List, contine una query de traer todos los datos de articulos de la BDD,
     * se comunica con esta y setea el objeto arti y pone con el resulset los valores (re.get);
     * y despúes me devuelve una lista con todos los datos.
     * @return 
     */
    @Override
    public List listar() {
       
        ArrayList<Articulo>list = new ArrayList<>();
        //escribo mi sentencia sql, que me va a traer todos los datos que estan en articulo
        String sql= "select * from articulo";
        try{
            //inicio la conexion
            con=cn.getConnection();
            //guardo en mi objeto de PS, la consulta a la BDD
            ps = con.prepareStatement(sql);
            //guardo en mi objeto resulSet, la consulta y ejecuta la query
            rs=ps.executeQuery();
            //con el while lo que hace es que va pasando de columna en columna y va guardando los datos que trae de la BDD
            //en el onjeto Articulo
            while(rs.next()){
                Articulo arti = new Articulo();
                arti.setId(rs.getInt("id"));
                arti.setMarca(rs.getString("marca"));
                arti.setDescripcion(rs.getString("descripcion"));
                arti.setCantidad(rs.getInt("cantidad"));
                arti.setPrecio(rs.getDouble("precio"));
                list.add(arti);
            }
        }catch(Exception e){
            
        }
        //me devuleve la lista
        return list;
    }

    /**
     * Este metodo de tipo Articulo, me trae todos los datos de cierta fila solo cuando le paso por
     * parametro cierta id por medio de mi servlet, y me devuelve un objeto con los datos.
     * @param id
     * @return 
     */
    @Override
    public Articulo list(int id) {
       String sql= "select * from articulo where id="+id;
        try{
            con=cn.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               
                arti.setId(rs.getInt("id"));
                arti.setMarca(rs.getString("marca"));
                arti.setDescripcion(rs.getString("descripcion"));
                arti.setCantidad(rs.getInt("cantidad"));
                arti.setPrecio(rs.getDouble("precio"));
               
            }
        }catch(Exception e){
            
        }
        return arti;
    }

    /**
     * Este metodo me inserta valores a mi BDD;va recibir como parm un objeto de tipo Articulo, en la query los valores 
     * que le pongo en cada celda son los datos que me paso mi servlet; y preparedStatement hace un executeUpdate.
     * @param arti
     * @return 
     */
    @Override
    public boolean add(Articulo arti) {
      
       String sql = "insert into articulo(marca,descripcion,cantidad,precio)values('"+arti.getMarca()+"','"+arti.getDescripcion()+"','"+arti.getCantidad()+"','"+arti.getPrecio()+"')";
        try{ 
       con=cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
    }

    /**
     * Este metodo edita un articulo de mi BDD, dependiendo del ID que le pase; recibe como param un objeto de tipo
     * Articulo, la query es de update osea editar, le pongo en la query los valores de los datos que me paso el servlet
     * y me hace un executeUpdate.
     * @param arti
     * @return 
     */
    @Override
    public boolean edit(Articulo arti) {
        String sql = "update articulo set marca='"+arti.getMarca()+"',descripcion='"+arti.getDescripcion()+"',cantidad='"+arti.getCantidad()+"',precio='"+arti.getPrecio()+"' where id="+arti.getId();
       try{
           con=cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
       }catch(Exception e){
           
       }
       return false;
    }
    
/**
 * Este metodo de tipo boolean, recibe como param un id de tipo int, y en la query me va a eliminar
 * cierta fila de la tabla articulo segun el id que le paso desde mi servlet; y me va a hacer un executeUpdate.
 * @param id
 * @return 
 */
    @Override
    public boolean eliminar(int id) {
        
        String sql = "delete from articulo where id="+id;
        
        try{
            con=cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return false;
        
    }
    
    
    
}
