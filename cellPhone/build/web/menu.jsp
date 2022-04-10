

<%@page import="modeloDAO.ArticuloDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.Articulo"%>
<%@page import="modelo.Articulo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </head>
    <body>
        <%Articulo arti = null;
            HttpSession misession = request.getSession();

            String usu = (String) request.getSession().getAttribute("user");
            if (usu == null) {
                response.sendRedirect("errorLogueo.jsp");

            } else {

        %>



        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="menu.jsp">Shop CellPhone</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="menu.jsp">Menu</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="perfil.jsp">Mi Perfil</a></li>

                        <li class="nav-item">
                            <a class="nav-link" href="CarritoController?accion=Carrito"><i class="bi-cart-fill me-1">(<label style="color:orange">${contador}</label>)</i>Carrito</a>
                        </li>  
                    </ul>

                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" >
                        <li class="nav-item"> <h5>Bienvenido ${user}</h5></li>
                       
                        <li class="nav-item">
                            
                                <div class="col-4" style="margin-right:100px">

                                    <a href="index.jsp" class="btn btn-primary">Logout</a>

                                </div>

                            
                        </li>
                    </ul>

                </div>

            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Shop CellPhone</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Bienvenid@ a nuestra tienda</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <br>

        <div class="container">
            <h2 class="text-center">LISTA DE PRODUCTOS</h2>
            <!--aca empieza la tabla hecha en clase -->    
            <br><br>
            <div class="row">
                <div class="table-responsive table">
                    <table class="table">
                        <thead class="table-dark">                
                            <tr>
                                <th></th>

                                <th>Marca</th>
                                <th>Descripcion</th>

                                <th>Precio</th>


                                <th></th>

                                <th>Acción</th>
                            </tr>
                        </thead>

                        <%                    ArticuloDAO adao = new ArticuloDAO();
                            List<Articulo> list = adao.listar();
                            Iterator<Articulo> iter = list.iterator();
                          //Articulo arti = null;
                            while (iter.hasNext()) {
                                arti = iter.next();

                        %>
                        <tbody>
                            <tr>                   
                                <td></td>

                                <td><%= arti.getMarca()%></td>
                                <td><%= arti.getDescripcion()%></td>
                                <td><%= arti.getPrecio()%></td>


                                <td></td>



                                <td>
                                    <form action="CarritoController" method="Post">
                                        <input name="accion" type="hidden" value="AgregarCarrito">
                                        <input name="id" type="hidden" value="<%= arti.getId()%>">
                                        <input type="submit" class="btn btn-success" value="Carrito">
                                    </form>



                                </td> 
                            </tr>
                            <% }%>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Footer-->
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

