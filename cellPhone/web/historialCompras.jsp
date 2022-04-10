<%-- 
    Document   : historialCompras
    Created on : 13-feb-2022, 22:05:28
    Author     : daniela
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Compra"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.FacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta lang="en">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="sweetalert2.all.min.js"></script>

        <title>Perfil</title>
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
               




                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" >
                    <li  class="nav-item"> <a class="navbar-brand" href="administraccion.jsp">Shop CellPhone</a></li>
                     <li class="nav-item"><a class="nav-link active" aria-current="page" href="administraccion.jsp">Administración</a></li>
                    <li class="nav-item" style="margin-left:500px"> <h5>Bienvenid@ ${user}</h5></li>
                    <li></li>
                    <li class="nav-item"><form action ="#" method="POST" style="float: left">
                            <div class="col-4" style="margin-right:100px">

                                <a href="Controlador?accion=Salir" class="btn btn-primary">Logout</a>

                            </div>

                        </form> </li>
                </ul>

            </div>

        </div>
    </nav>
                    <br>
                    <!--section -->
    <section>
        <article>
            <div class="container">
                
                <h3>Historial de Compras</h3>
                <br>
                <div class="row">
                    <div class="table-responsive table">
                        <table class="table">
                             <thead class="table-dark">                
                            <tr>
                                <td></td>
                                  <td>Id Compra</td>
                                <td>Id Pago</td>
                                <td>Estado</td>

                                <td>Monto</td>
                                


                                <td></td>

                                
                            </tr>
                        </thead>
                        <%
                            FacturaDAO fdao = new FacturaDAO();
                            List<Compra>list = fdao.listar();
                            Iterator<Compra>iter = list.iterator();
                            Compra compra = null;
                            while(iter.hasNext()){
                                compra = iter.next();
                            
                            %>
                            <tbody>
                                <tr>
                                      <td></td>

                                <td><%= compra.getId()%></td>
                                <td><%= compra.getIdPago()%></td>
                                <td><%= compra.getEstado()%></td>
                                 <td><%= compra.getMonto()%></td>
                                  


                                <td></td>
                                </tr>
                                 <% }%>
                            </tbody>
                        </table>
                    </div>
                </div>
                
            </div>
        </article>
    </section>
      <!--footer-->               
    <footer>

    </footer>
      <%
            }
            %>
</body>
</html>
