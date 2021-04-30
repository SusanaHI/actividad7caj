<%-- 
    Document   : muestraResultado
    Created on : 30/04/2021, 01:51:02 AM
    Author     : SusanaHI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "controller.muestraOperacion"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        
        <h1>USUARIO</h1>
            <%
                HttpSession mysession = request.getSession(false);
                out.println(mysession.getAttribute("usuarioResuelto"));
            %>
        
        <h1>Area y Perimetro de un Triangulo</h1>
            <h3>AREA</h3><br>
            <%=request.getAttribute("areaResuelta")%>
            <h3>PERIMETRO</h3>
            <%=request.getAttribute("perimetroResuelto")%>
        
    </body>
</html>
