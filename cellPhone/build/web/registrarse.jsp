<%-- 
    Document   : registrarse
    Created on : 14-nov-2021, 18:57:10
    Author     : daniela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>

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

</head>
<body>
    <!--Cabecera -->
    <header>
        <br> <br>
        <h1 class="text-center">Registro</h1>
    </header>

<!-- INICIO DEL CONTENIDO PRINCIPAL -->
<section>
    <div class="container">
    
    

    <form action="AltaCliente"  method="POST" class="row g-3 formStyle mx-auto py-4 px-4">
    
    <div class="col-6">
        <label for="nombre" class="form-label">Nombre</label>
        <input type="text" required class="form-control" placeholder="Maria Eugenia"  id="nombre" name="nombre" pattern="[a-zA-Z\s]{2,30}">
    </div>
    <div class="col-6">
        <label for="apelllido" class="form-label">Apellido</label>
        <input type="text" required class="form-control" placeholder="Perez" id="apellido" name="apellido" pattern="[a-zA-Z\s]{2,30}">
    </div> 
    <div class="col-6">
        <label  for="usuario" class="form-label">Usuario</label>
        <input type="text" required class="form-control" placeholder="mariaeuge1"  id="usuario" name="usuario"pattern="[a-zA-Z0-9]{2,20}">
    </div>
    <div class="col-6">
        <label for="clave" class="form-label">Password</label>
        <input type="password" required class="form-control" id="clave" name="clave" placeholder="*******">
    </div>
   
   
    <div class="col-12 text-center mt-4">
        
         <input class="btn btn-success w-25" type="submit" name="accion" value="Agregar" >
         <a  href="index.jsp" class="btn btn-danger w-25" > Cancelar</a>
        
    </div>
    </form>
    <br>
    
</div>
</section>




</body>
</html

