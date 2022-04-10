
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modeloDAO.ClienteDAO;


@WebServlet(name = "AltaCliente", urlPatterns = {"/AltaCliente"})
public class AltaCliente extends HttpServlet {
    
    //------------------Alta Cliente--------------------------------

    //le asigno a una variable ir a la pagina de index.jsp
    String inde = "index.jsp";
    //instancio objetos de Cliente y ClienteDAO
    Cliente cli = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    
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
        //creo una variable y  luego le asignare a que pagina ir
        String acceso="";
        
        //le asigno a mi variable action el tipo de accion que va a ejecutar el usuario
        String action = request.getParameter("accion");
        //si la action corresponde O es igual a Agregar se ejecuta lo siguiente
         if(action.equalsIgnoreCase("Agregar")){
             //creo las variables y guardo en estas los datos que el cliente pone en el form y los traigo conn request.getParameter
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        
        //guardo en el objeto o seteo los datos que les pongo en el parametro
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setUser(usuario);
        cli.setPassword(clave);
        //aca guardo en un objeto de ClienteDAO, llamando al metodo add y le paso al objeto cliente; para que me lo guarde en la BDD
        cdao.add(cli);
      //le asigo a la variable acceso que quiero ir a la pagina index.jsp y hago un requestDispatcher y le paso la variable.
      acceso=inde;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
