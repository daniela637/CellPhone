package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Articulo;
import modelo.CarritoCliente;
import modelo.Cliente;
import modelo.Compra;
import modelo.Pago;

import modeloDAO.ArticuloDAO;
import modeloDAO.CompraDAO;
import modeloDAO.ReducirStockDAO;

@WebServlet(name = "CarritoController", urlPatterns = {"/CarritoController"})
public class CarritoController extends HttpServlet {

    //instacio los objetos
    ArticuloDAO adao = new ArticuloDAO();
    Articulo arti = new Articulo();
    List<CarritoCliente> listaCarrito = new ArrayList<>();
    List<Articulo> listaArticulo = new ArrayList<>();

    //creo algunas variables
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    int idArti;

    CarritoCliente car;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //--------------------Proceso Carrito----------------------------
        String accion = request.getParameter("accion");
        //en una lista le guardo los articulos que traigo por el metodo listar.
        listaArticulo = adao.listar();

        //----uso un swtch con 3 opciones------
        switch (accion) {

            case "AgregarCarrito":
                int posicion = 0;
                cantidad = 1;
                //en una variable le guardo el id que traje por el request.getParemeter
                idArti = Integer.parseInt(request.getParameter("id"));
                //llamo a mi metodo list por medio de mi objeto adao de tipo ArticuloDAO y le paso como param el idArti
                //que me va devolver un objeto con todos los datos de acuardo al id que le pase y la guardo en en el objeto arti.
                arti = adao.list(idArti);

                //para que no se duplique en el carrito los articulos que escojo varias veces
                //me fijo en la posicion del id del articulo q escoji y se va sumando en la cantidad
                if (listaCarrito.size() > 0) {
                    //aca uso este for para ir sumando el numero de posiciones que escojo al comprar
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (idArti == listaCarrito.get(i).getIdArticulo()) {
                            posicion = i;
                        }
                    }
                    //este sumaria o multiplacaria cuando selecciono varias veces un prodcuto
                    if (idArti == listaCarrito.get(posicion).getIdArticulo()) {
                        cantidad = listaCarrito.get(posicion).getCantidad() + cantidad;
                        double subTotal = listaCarrito.get(posicion).getPrecioCompra() * cantidad;
                        //guardo en la posicion de donde este en la lista, le paso los param
                        listaCarrito.get(posicion).setCantidad(cantidad);
                        listaCarrito.get(posicion).setSubTodtal(subTotal);
                    } else {  //guardo en mi objeto car o seteo los valores de arti
                        item = item + 1;
                        car = new CarritoCliente();
                        car.setItem(item);
                        car.setIdArticulo(arti.getId());
                        car.setMarcas(arti.getMarca());
                        car.setDescripcion(arti.getDescripcion());
                        car.setPrecioCompra(arti.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTodtal(cantidad * arti.getPrecio());
                        //guardo el objeto en una listaCarrito
                        listaCarrito.add(car);
                    }
                } else {  //guardo en mi objeto car o seteo los valores de arti
                    item = item + 1;
                    car = new CarritoCliente();
                    car.setItem(item);
                    car.setIdArticulo(arti.getId());
                    car.setMarcas(arti.getMarca());
                    car.setDescripcion(arti.getDescripcion());
                    car.setPrecioCompra(arti.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTodtal(cantidad * arti.getPrecio());
                     //guardo el objeto en una listaCarrito
                    listaCarrito.add(car);
                }

                //seteo a mi setAttribute la catidad de articulos seleccidonados
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;

            case "Carrito":

                totalPagar = 0.0;
                //le seteo a mi setAttribute y le guardo  la listaCarrito
                request.setAttribute("carrito", listaCarrito);
                //este for va a ir por articulo agragado en la lista e ira sumando el total de todos los productos seleccionados
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubTodtal();
                }
                //le seteo a setAttribute y le guardo el total a pagar
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);

                break;
                
            case "GenerarCompra":
                Cliente cliente = new Cliente();

               
                CompraDAO cdao = new CompraDAO();
                 //cuando el cliente decida comprar va a guardar los datos en un objeto compra
                Compra compra = new Compra(item, cliente, 1, totalPagar, "Cancelado", listaCarrito);

                //llamo a mi metodo generarCompra por medio de cdao del tipo CompraDAO y le paso mi objeto compra
                //que me devolvera 1 de verdadero o 0 de false y la guardo en la variable
                int res = cdao.generarCompra(compra);

                //si res es diferente de 0 y tatalPagar es mayor esto quiere decir que se ejecuto la compra si errores
                if (res != 0 && totalPagar > 0) {

                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);

                } else { //si no me va a decir que hubo un error y no se efectuo la compra
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
            default:
                request.getRequestDispatcher("menu.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
