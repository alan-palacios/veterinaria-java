package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access_object.DBConnection;
import data_access_object.MascotaDAO;
import models.Mascota;

@WebServlet(name="MascotasServlet", urlPatterns={"/MascotasServlet"})
public class MascotasServlet extends HttpServlet {
    
    private void seleccionarMascota(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        MascotaDAO mascotaDAO = new MascotaDAO(connection);

        String idMascota = request.getParameter("idMascota");
        System.out.println("Buscando mascota: "+idMascota);
        try {
            Mascota mascota = mascotaDAO.getById(Integer.parseInt(idMascota));
            if (mascota != null) {
                System.out.println("Mascota encontrada: "+mascota.getNombre());
                request.getSession().setAttribute("mascota", mascota);
                response.sendRedirect("pages/mascota.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("pages/mascotas.jsp");
        }
    }

    private void obtenerMascotasPropietario(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        MascotaDAO mascotaDAO = new MascotaDAO(connection);

        String idPropietario = request.getParameter("idPropietario");
        System.out.println("Buscando propietario: "+idPropietario);
        try {
            List<Mascota> mascotas = mascotaDAO.getAllOfOwner(Integer.parseInt(idPropietario));
            if (mascotas != null) {
                System.out.println("Mascotas encontradas: "+mascotas.size());
                request.getSession().setAttribute("mascotas", mascotas);
                response.sendRedirect("pages/mascotas.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("pages/cuenta.jsp");
        }
    }
    
    private void actualizarMascota(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        MascotaDAO mascotaDAO = new MascotaDAO(connection);

        try {
            System.out.println("Actualizando mascota");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(request.getParameter("nacimiento"));
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

            Mascota mascota = new Mascota(
                Integer.parseInt(request.getParameter("idMascota")),
                Integer.parseInt(request.getParameter("idPropietario")),
                request.getParameter("nombre"),
                request.getParameter("sexo"),
                timestamp
            );

            mascota = mascotaDAO.update(mascota);
            System.out.println(
                "mascota "+
                mascota.getId_propietario()+" "+
                mascota.getNombre()+
                " actualizado"
            );
            obtenerMascotasPropietario(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void registrarMascota(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        MascotaDAO mascotaDAO = new MascotaDAO(connection);

        try {
            System.out.println("Guardando mascota");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(request.getParameter("nacimiento"));
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

            Mascota mascota = new Mascota(
                Integer.parseInt(request.getParameter("idPropietario")),
                request.getParameter("nombre"),
                request.getParameter("sexo"),
                timestamp
            );

            mascota = mascotaDAO.saveBasicInfo(mascota);
		    System.out.println(
                "mascota "+
                mascota.getId_propietario()+" "+
                mascota.getNombre()+
                " agregado"
            );
            obtenerMascotasPropietario(request, response);
        } catch (Exception e) {
		    System.out.println(e);
        }
    }
    
    private void borrarMascota(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection connection = DBConnection.getConnection(request.getServletContext());
        MascotaDAO mascotaDAO = new MascotaDAO(connection);

        try {
            System.out.println("Borrando mascota");
            int idMascota = Integer.parseInt(request.getParameter("idMascota"));
            mascotaDAO.delete(idMascota);
            System.out.println("mascota "+idMascota+" borrado");
            obtenerMascotasPropietario(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method) {
            case "actualizar":
                actualizarMascota(request, response);
                break;
            case "borrar":
                borrarMascota(request, response);
                break;
            case "registrar":
                registrarMascota(request, response);
                break;
            case "seleccionar":
                seleccionarMascota(request, response);
                break;
            default:
                obtenerMascotasPropietario(request, response);
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
