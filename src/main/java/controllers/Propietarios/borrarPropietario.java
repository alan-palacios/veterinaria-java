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

@WebServlet(name="borrarPropietario", urlPatterns={"/borrarPropietario"})
public class borrarPropietario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        PropietarioDAO propietarioDAO = new PropietarioDAO(connection, request.getServletContext());

        String idPropietario = request.getParameter("id");
        try {
            boolean success = propietarioDAO.delete(Integer.parseInt(idPropietario));
            if (success) {
                System.out.println("Propietario borrado: "+idPropietario);
                request.getSession().removeAttribute("propietario");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            response.sendRedirect("index.jsp");
        }
    } 

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
