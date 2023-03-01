/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 *
 * @author AlanPalacios
 */
public class Mascota {
    private int id;
    private int propietario_id;
    private int raza_id;
    private Timestamp nacimiento;
    private String nombre;
    private Blob imagen;
    private int tamano;

    public Mascota(int id, int propietario_id, int raza_id, Timestamp nacimiento, String nombre, Blob imagen, int tamano) {
        this.id = id;
        this.propietario_id = propietario_id;
        this.raza_id = raza_id;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tamano = tamano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropietario_id() {
        return propietario_id;
    }

    public void setPropietario_id(int propietario_id) {
        this.propietario_id = propietario_id;
    }

    public int getRaza_id() {
        return raza_id;
    }

    public void setRaza_id(int raza_id) {
        this.raza_id = raza_id;
    }

    public Timestamp getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Timestamp nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    
}
