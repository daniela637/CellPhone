package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Articulo;
import modeloDAO.ArticuloDAO;

@WebServlet(name = "ControlArticulo", urlPatterns = {"/ControlArticulo"})
public class ControlArticulo extends HttpServlet {

    //declaro variables y les asigno las paginas a las que quiero ir.
    String listar = "administraccion.jsp";
    String add = "altaArticulo.jsp";
    String edit = "editarArticulos.jsp";
    //instancio los objetos
    Articulo arti = new Articulo();
    ArticuloDAO adao = new ArticuloDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //------------------------agregar articulo---------------------------
        
        String acceso = "";
        String action = request.getParameter("accion");
        
        //si action es igual a Agregar se ejecta lo siguiente
        if (action.equalsIgnoreCase("Agregar")) {
            
            //creo las variables y le guardo en estas los datos que traje por medio de request.getParamter
            String marca = request.getParameter("marca");
            String descripcion = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            
            //guardo o seteo en mi objeto arti los datos y se los pongo en los parametros
            arti.setMarca(marca);
            arti.setDescripcion(descripcion);
            arti.setCantidad(cantidad);
            arti.setPrecio(precio);
            
            //llamo a mi metodo add(agregar) por medio de mi objeto adao de ArticuloDAO y le paso por parametro el objeto arti
            //donde se comunicara este metodo con la BDD  y agregar los datos.
            adao.add(arti);

            //le guardo en mi valiable. listar. que por medio de requestDispatcher me llevara a administraccio.jsp
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
