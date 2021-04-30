/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SusanaHI
 */
public class muestraOperacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            
            //Usuario
            String idUser = request.getParameter("userName");

            model.user e2 = new model.user(idUser);
            //String usuario = e2.getId();

            HttpSession mysession = request.getSession(false);
            mysession.setAttribute("usuarioResuelto", e2.getId());
            
            //request.setAttribute("lastUser", e2.getId());
            //request.getRequestDispatcher("/MuestraResultado.jsp").forward(request, response);
            
            //Triangulo, Cookies and Filter
            
            if(request.getAttribute("flag")!=null){
                request.setAttribute("flag", 1);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else{
                String n1 = request.getParameter("base");
                String n2 = request.getParameter("altura");

                model.triangulo e1 = new model.triangulo(n1, n2);
                double a1 = e1.getArea();
                double p2 = e1.getPerimeter();
                                    
                Cookie ck = new Cookie("base", e1.getBase()+"");
                response.addCookie(ck);

                ck = new Cookie("altura", e1.getAltura()+"");
                response.addCookie(ck);

                ck = new Cookie("area", e1.getArea()+"");
                response.addCookie(ck);

                ck = new Cookie("perimetro", e1.getPerimeter()+"");
                response.addCookie(ck);

                request.setAttribute("areaResuelta", a1);
                request.setAttribute("perimetroResuelto", p2);

                request.getRequestDispatcher("/muestraResultado.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
