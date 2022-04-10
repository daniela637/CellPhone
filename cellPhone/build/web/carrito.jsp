 

<%@page import="modelo.CarritoCliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@page import="modelo.Articulo"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>menu</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <title>carro de compras</title>
    </head>
    <body>
         <%HttpSession misession = request.getSession();
        
String usu = (String) request.getSession().getAttribute("user");
if(usu== null){
    response.sendRedirect("errorLogueo.jsp");
    
}else{
               
        %>
         <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="menu.jsp">Shop CellPhone</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="menu.jsp">Menu</a></li>
                       
                        <li class="nav-item ">
                            <a class="nav-link "  href="menu.jsp" role="button"  >Seguir Comprando</a>
                            
                        </li>
                        
                    </ul>
                   
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" >
                       <li class="nav-item"> <h5>Bienvenid@ ${user}</li>
                        <li></li>
                         <li class="nav-item">  <a href="index.jsp" class="btn btn-primary">Logout</a> </li>
                    </ul>
                   
                </div>
                
            </div>
        </nav>
       
        <!-- Section-->
        <br>
            <br>
                <br>
        <div class="container mt-4">
            <h3>Carrito</h3>
            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID Articulo</th>
                                <th>ITEM</th>
                                <th>NOMBRES</th>
                                <th>DESCRIPCIÓN</th>
                                <th>PRECIO</th>
                                <th>CANT</th>
                                
                            </tr>
                        </thead>
                        <%
                            //LineaCarrito linea = new LineaCarrito();
              // Carrito car = (Carrito) request.getSession().getAttribute("carrito");
               
              // for(LineaCarrito linea : car.getListaLinea()){
               Articulo arti = null;
              CarritoCliente car = new CarritoCliente();
               %>
               <c:forEach var="car" items="${carrito}">
                        <tbody>
                            
                                
                            <tr>
                               
                       

                                <td>${car.getIdArticulo()}</td>
                                <td>${car.getItem()}<%//= linea.getArti().getMarca()%></td>
                                <td>${car.getMarcas()}<%//= linea.getArti().getDescripcion() %></td>
                                <td>${car.getDescripcion()}<%//= linea.getArti().getPrecio() %></td>
                                <td>${car.getPrecioCompra()}<%//= linea.getCantidad() %> </td>
                                <td>${car.getCantidad()}</td>
                                
                            </tr>
                            </c:forEach>
                            <% //}%>
                        </tbody>
                    </table>
                       
                       
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h3>Generar Compra</h3>
                    </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" value="${totalPagar}" readonly="" class="form-control">
                              <label>Total a Pagar:</label>
                            <input type="text" value="${totalPagar}" readonly="" class="form-control">
                              
                        </div>
                         <div class="card-footer">
                              
                           
                             
                             <a href="CarritoController?accion=GenerarCompra" class="btn btn-danger btn-block">Generar Compra</a>
                             
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer-->
        <br>
            <br>
                <br>
                <br>
                <br>
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; CellPhone 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
          
        <%
            }
            %>
    </body>
</html>
