<%-- 
    Document   : index
    Created on : 30/04/2021, 01:52:06 AM
    Author     : SusanaHI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<%@page import = "controller.muestraOperacion"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Triangulo</title>
    </head>
    <body>
        
        <%--Session--%>
        <%
            HttpSession mysession = request.getSession(false);
            Enumeration e = mysession.getAttributeNames();
            if (e.hasMoreElements()) {
                out.println("Bienvenid@ de nuevo " + mysession.getAttribute("usuarioResuelto"));
            }
        %>
               
        <%--Cookies--%>
        <%
            Cookie ck[] = request.getCookies();
            if (ck!=null){
                for(int i=0; i<ck.length; i++){
                    if(ck[i].getName().equals("base")){
                        out.print("<h1> Tu base anterior fue " + ck[i].getValue());
                    }
                    if(ck[i].getName().equals("altura")){
                        out.print("<h1> Tu altura anterior fue " + ck[i].getValue());
                    }
                    if(ck[i].getName().equals("area")){
                        out.print("<h1> Tu area anterior fue " + ck[i].getValue());
                    }
                    if(ck[i].getName().equals("perimetro")){
                        out.print("<h1> Tu perimetro anterior fue " + ck[i].getValue());
                    }
                }
            }
        %>
                
        <div><br>TRIANGULO EQUILATERO <br><br>
            <form action="muestraOperacion" method="post">
                BIENVENIDO <br><br> Introduce tu nombre de usuario:<br>
                <input type="text" name="userName"><br><br>
                Introduzca la base del triangulo:<br>
                <input type="text" name="base" value=""><br>
                Introduzca la altura del triangulo:<br>
                <input type="text" name="altura" value=""><br>
                <input type="submit" value="Calcular">
            </form>
        </div>
        
    </body>
</html>
