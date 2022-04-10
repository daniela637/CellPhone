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

@WebServlet(name = "EditArticulo", urlPatterns = {"/EditArticulo"})
public class EditArticulo extends HttpServlet {

    //creo dos variables, que les asigno las paginas a las que quiero ir
    String listar = "administraccion.jsp";
    String edit = "editarArticulos.jsp";
    //instancio mis objetos
    Articulo arti = new Articulo();
    ArticuloDAO adao = new ArticuloDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //---------------------------Editar Articulo---------------------------------
        
        String acceso = "";
        String action = request.getParameter("accion");

        //si action es igual a editar se me ejuta lo siguiente
        if (action.equalsIgnoreCase("editar")) {

            //seteo el atributo y le asigno el id que traje por medio del request.getParameter del form
            //y me va a llevar a la pagina editarArticulos.jsp donde me va a pedir el atribute de idArti, para de esta forma
            //mostrarme el articulo
            request.setAttribute("idArti", request.getParameter("id"));
            acceso = edit;

           //estando en la pagina de editar si la action es igual a actualizar se ejecuta lo siguiente
        } else if (action.equalsIgnoreCase("Actualizar")) {

            //creo variables y por medio de request.getParameter traigo los datos y se los guardo en estas.
            int id = Integer.parseInt(request.getParameter("idArticulo"));
            String marca = request.getParameter("marca");
            String descripcion = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            //seteo los datos de de mi objeto arti y se los pongo en el parametro
            arti.setId(id);
            arti.setMarca(marca);
            arti.setDescripcion(descripcion);
            arti.setCantidad(cantidad);
            arti.setPrecio(precio);
            //llamao a mi metodo edit por medio de mi objeto adao de tipo ArticuloDAO y le paso en el parametro el objeto arti.
            //que va a recurrir a este metodo que se comunica con la BDD y efectua la actualizacion.
            adao.edit(arti);
            
            //le asigno a mi variable, listar , que usando el requestDispatcher me va a llevar a administraccion.jsp
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
