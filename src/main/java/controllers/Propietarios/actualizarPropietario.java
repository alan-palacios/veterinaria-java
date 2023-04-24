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

@WebServlet(name="actualizarPropietario", urlPatterns={"/actualizarPropietario"})
public class actualizarPropietario extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        PropietarioDAO propietarioDAO = new PropietarioDAO(connection, request.getServletContext());

        System.out.println("Actualizando propietario");
        System.out.println("idPropietario: "+request.getParameter("idPropietario"));

        Propietario propietario = new Propietario(
            Integer.parseInt(request.getParameter("idPropietario")),
            request.getParameter("nombre"),
            request.getParameter("appat"),
            request.getParameter("apmat"),
            request.getParameter("dir")
        );

        try {
            propietario = propietarioDAO.save(propietario);
            System.out.println(
                "propietario "+
                propietario.getIdPropietario()+" "+
                propietario.getNombre()+
                " actualizado"
            );
            if (propietario != null) {
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
