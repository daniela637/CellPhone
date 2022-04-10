<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Articulo"%>
<%@page import="modeloDAO.ArticuloDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
    
        <title>Administraccion</title>
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
                <a class="navbar-brand" href="administraccion.jsp">Shop CellPhone</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                   
                    
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" >
                        <li class="nav-item" style="margin-left:700px"> <h5>Bienvenid@ ${user}</h5></li>
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
        
        
              <div class="container" >
   
              <a  href="altaArticulo.jsp" class="btn btn-success w-25" style="margin-left:100px"> Agregar Producto</a>
              <a  href="historialCompras.jsp" class="btn btn-success w-25" style="margin-left:100px"> Historial de Compras</a>
              
              </div>
         
    
        
                         
           
 
                 
                    <!-- Page Heading -->
      
        
        <br>
        <br>
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
                      <th>ID</th>
                      <th>Marca</th>
                      <th>Descripcion</th>
                      <th>Cantidad</th>
                      <th>Precio</th>
                      <th>Accion</th>
                      
                      <th></th>
                   </tr>
               </thead>
               <%
               ArticuloDAO adao = new ArticuloDAO();
               List<Articulo>list = adao.listar();
               Iterator<Articulo>iter = list.iterator();
               Articulo arti = null;
               while(iter.hasNext()){
                   arti=iter.next();
               
               %>
               <tbody>
                   <tr>
                   <td></td>
                                  <td><%= arti.getId() %></td>
                                 <td><%= arti.getMarca()%></td>
                                     <td><%= arti.getDescripcion() %></td>
                                      <td><%= arti.getCantidad() %> </td>
                                    <td><%= arti.getPrecio() %></td>
                                    <td>
                                        <a href="EditArticulo?accion=editar&id=<%= arti.getId() %>">Editar</a>
                                        <a href="EliminarArticulo?accion=eliminar&id=<%= arti.getId() %>">Remover</a>
                                    </td>
                                   
                                    <td></td>
                           
                        <td></td>            
                         </tr>
                         <% }%>
             </tbody>
             </table>
           </div>
       </div>
</div>
<%
            }
            %>
        
         
    </body>
</html>

