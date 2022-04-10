
package Interfaces;

import java.util.List;
import modelo.Articulo;


public interface CRUD {
    
    public List listar();
    public Articulo list(int id);
    public boolean add(Articulo arti);
    public boolean edit(Articulo arti);
    public boolean eliminar(int id);
}
