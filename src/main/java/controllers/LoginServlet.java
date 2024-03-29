package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access_object.DBConnection;
import data_access_object.PropietarioDAO;
import models.Propietario;

@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // recibir correo y contraseña y verificar si existe en la base de datos
        // si existe, redirigir a la página de inicio e iniciar sesión
        // si no existe, redirigir a la página de login y mostrar mensaje de error
        Connection connection = DBConnection.getConnection(request.getServletContext());
        PropietarioDAO propietarioDAO = new PropietarioDAO(connection, request.getServletContext());
        
        Propietario propietario = new Propietario(
            request.getParameter("correo"),
            request.getParameter("password")
        );
        try {
            propietario = propietarioDAO.login(propietario);
            if (propietario != null) {
                // crear sesión con el propietario y redirigir a la página de inicio
                request.getSession().setAttribute("propietario", propietario);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("pages/login.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
