
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


@WebServlet(name = "EliminarArticulo", urlPatterns = {"/EliminarArticulo"})
public class EliminarArticulo extends HttpServlet {

      String listar = "administraccion.jsp";
        Articulo arti = new Articulo();
    ArticuloDAO adao = new ArticuloDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //------------------------Eliminar Articulo-------------------------------
        
         String acceso="";
        String action = request.getParameter("accion");
        //si action es igual a eliminar se ejecuta el if
        if(action.equalsIgnoreCase("eliminar")){
            
            //creo un variable id de tipo int, en la que le voy a guardar el parametro que traje por medio de request.getParameter
             int id = Integer.parseInt(request.getParameter("id"));
             //guardo en mi objeto arti o le seteo la id y se lo pongo en el parametro
             arti.setId(id);
             //llamo al metodo eliminar por medio de mi objeto adao de ArticuloDAO, y le paso el param id
             adao.eliminar(id);
             
             //le paso a mi variable, listar. donde uso el requestDispatcher para ir a otra pagina que se llama administraccion.jsp
             acceso =listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
