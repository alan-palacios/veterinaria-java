package controllers;

import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access_object.DBConnection;
import data_access_object.PropietarioDAO;
import models.Propietario;

@WebServlet(name="PropietariosServlet", urlPatterns={"/PropietariosServlet"})
public class PropietariosServlet extends HttpServlet {
    private void actualizarPropietario(HttpServletRequest request, HttpServletResponse response)
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

    private void borrarPropietario(HttpServletRequest request, HttpServletResponse response)
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
    
    private void registrarPropietario(HttpServletRequest request, HttpServletResponse response)
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

    private void leerPropietario(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        PropietarioDAO propietarioDAO = new PropietarioDAO(connection, request.getServletContext());

        String idPropietario = request.getParameter("id");
        System.out.println("Buscando propietario: "+idPropietario);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method) {
            case "actualizar":
                actualizarPropietario(request, response); 
                break;
            case "borrar":
                borrarPropietario(request, response);
                break;
            case "registrar":
                registrarPropietario(request, response);
                break;
            default:
                leerPropietario(request, response);
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
