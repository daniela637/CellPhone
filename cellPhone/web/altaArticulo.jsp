<%-- 
    Document   : altaArticulo
    Created on : 16-nov-2021, 20:50:18
    Author     : daniela
--%>

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
        <title>Alta Producto</title>
    </head>
    <body>
         
       <%HttpSession misession = request.getSession();
        
String usu = (String) request.getSession().getAttribute("user");
if(usu== null){
    response.sendRedirect("errorLogueo.jsp");
    
}else{
               
        %>
  

 <!-- CABECERA -->
 <header>
     <br><br>
      <h1 class="text-center">AGREGAR PRODUCTO</h1>
 </header>
<!-- INICIO DEL CONTENIDO PRINCIPAL -->
<section>
    <article>
        <div class="container">
   
     
 
    <form action="ControlArticulo"  method="POST" class="row g-3 formStyle mx-auto py-4 px-4">
    <div class="col-6">
 
        <label for="nombre" class="form-label">Marca</label>
        <input type="text" required class="form-control" id="nombre" name="marca" pattern="[a-zA-Z0-9\s]{3,25}">
    </div>
    <div class="col-6">
        <label for="cantidad" class="form-label">Cantidad</label>
        <input  required class="form-control"  id="cantidad" name="cantidad" type="number" min="0">
    </div>
    <div class="col-4"  style="margin-left:250px">
        <label for="precio" class="form-label">Precio</label>
        <input  required class="form-control" id="precio" name="precio" type="number" min="0">
    </div>
    
        <div class="col-12">
        <label for="descripcion" class="form-label">Descripcion</label>
        <textarea name="descripcion" required id="" class="w-100"rows="4"></textarea>
    </div>
    
    <div class="col-12 text-center mt-4">
       
        <input class="btn btn-success w-25" type="submit" name="accion" value="Agregar" >
        <a  href="administraccion.jsp" class="btn btn-danger w-25" > Cancelar</a>
        
       
    </div>
    </form>
</div>
    </article>
</section>


        <%
            }
            %>
         
    </body>
</html>
