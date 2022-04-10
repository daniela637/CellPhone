package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modeloDAO.ClienteDAO;
import modelo.Empleado;
import modeloDAO.EmpleadoDAO;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    ClienteDAO cdao = new ClienteDAO();
    Cliente cli = new Cliente();
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado emple = new Empleado();
    int resul;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        //si accion es igual a Ingresar se ejecuta lo siguiente
        if (accion.equals("Ingresar")) {
            //guardo en variables los datos ingresados por el usuario, los traigo por medio de request.getParamteter
            String user = request.getParameter("usuario");
            String pass = request.getParameter("clave");

            //le paso a mi objeto los datos guardados en mis variables
            cli.setUser(user);
            cli.setPassword(pass);

            //el metodo ValidarCli es de tipo int y la guardo en una variable, si da verdadero(1) me deja ingresar al menu
            //si el objeto cli que le mando como parametro en 1 o verdadero lo guarda en resul
            resul = cdao.ValidarCli(cli);

            //--------------------dejo entrar al cliente--------------------
            if (resul == 1) {
                //traigo la session actual y le seteo el atributo user y le pongo el user que ingreo
                request.getSession().setAttribute("user", user);
                //me lleva a la pagina menu.
                request.getRequestDispatcher("menu.jsp").forward(request, response);

                //----------------------- dejo entrar al administrador------------------------
            } else if (accion.equals("Ingresar")) {

                //le paso a mi objeto los datos guardados en mis variables
                emple.setUser(user);
                emple.setPassword(pass);
                //el metodo ValidarCli es de tipo int y la guardo en una variable, si da verdadero(1) me deja ingresar al menu
                resul = edao.ValidarEmple(emple);
                //dejo entrar al empleado
                if (resul == 1) {
                    request.getSession().setAttribute("user", user);
                    request.getRequestDispatcher("administraccion.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
