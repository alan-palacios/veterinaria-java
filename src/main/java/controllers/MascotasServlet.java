/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access_object.DBConnection;
import data_access_object.MascotaDAO;
import models.Mascota;

/**
 *
 * @author AlanPalacios
 */
public class MascotasServlet extends HttpServlet {
    Connection connection = DBConnection.getConnection(getServletContext());
    MascotaDAO mascotaDAO = new MascotaDAO(connection);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Mascota mascota = new Mascota(
            Integer.parseInt(request.getParameter("propietario_id")),
            Integer.parseInt(request.getParameter("raza_id")),
            java.sql.Timestamp.valueOf(request.getParameter("nacimiento")),
            request.getParameter("nombre"),
            new com.mysql.cj.jdbc.Blob(null, null),
            Integer.parseInt(request.getParameter("tamano")),
            Integer.parseInt(request.getParameter("peso")),
            request.getParameter("sexo")
        );
        try {
            mascotaDAO.save(mascota);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
