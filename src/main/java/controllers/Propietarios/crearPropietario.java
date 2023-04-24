package controllers.Propietarios;

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

@WebServlet(name="crearPropietario", urlPatterns={"/crearPropietario"})
public class crearPropietario extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        PropietarioDAO propietarioDAO = new PropietarioDAO(connection, request.getServletContext());

		System.out.println("Guardando propietario");
        Propietario propietario = new Propietario(
            request.getParameter("correo"),
            request.getParameter("nombre"),
            request.getParameter("appat"),
            request.getParameter("apmat"),
            request.getParameter("dir"),
            request.getParameter("password")
        );
        try {
            propietario = propietarioDAO.save(propietario);
		    System.out.println(
                "propietario "+
                propietario.getIdPropietario()+" "+
                propietario.getNombre()+
                " agregado"
            );
            response.sendRedirect("pages/login.jsp");
        } catch (Exception e) {
		    System.out.println(e);
            // TODO: handle exception
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
