<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/login_style.css">
    <link rel="stylesheet" href="css/cabecera.css">

   

    
 
</head>
<body>
   

  
 
 <form action="Controlador" method="POST">
   <img src="./img/login.png" alt="" width= "100px" height="100px">
   <p>Usuario <input type="text" placeholder="Ingrese su usuario" name="usuario"></p><br>
   <p>Contraseña <input type="password" placeholder="Ingrese su contraseña" name="clave"></p>
   <br><br>
    <div class="col-12 text-center mt-4">
        <input class="btn btn-danger btn-block" type="submit" name="accion" value="Ingresar" >
        <input class="btn btn-dark btn-block" type="submit" name="accion" value="Cancelar" >
    </div>
   
   
   
   
   </form> 

  

</body>
</html>
