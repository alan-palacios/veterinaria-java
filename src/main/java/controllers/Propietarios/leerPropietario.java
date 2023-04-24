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

@WebServlet(name="leerPropietario", urlPatterns={"/leerPropietario"})
public class leerPropietario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        PropietarioDAO propietarioDAO = new PropietarioDAO(connection, request.getServletContext());

        String idPropietario = request.getParameter("id");
        try {
            Propietario propietario = propietarioDAO.getById(Integer.parseInt(idPropietario));
            if (propietario != null) {
                System.out.println("Propietario encontrado: "+propietario.getNombre());
                request.getSession().setAttribute("propietario", propietario);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            response.sendRedirect("pages/cuenta.jsp");
        }
    } 

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
