package models;

import java.sql.Blob;
import java.sql.Timestamp;

public class Mascota{
    private int id_mascota=-1;
    private int id_propietario;
    private int id_raza;
    private Timestamp nacimiento;
    private String nombre;
    private Blob imagen;
    private int tamano;
    private int peso;
    private String sexo;

    public Mascota(int id, int propietario_id, int raza_id, Timestamp nacimiento, String nombre, Blob imagen, int tamano, int peso, String sexo) {
        this.id_mascota = id;
        this.id_propietario = propietario_id;
        this.id_raza = raza_id;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tamano = tamano;
        this.sexo = sexo;
        this.peso = peso;
    }
    
    public Mascota(int propietario_id, int raza_id, Timestamp nacimiento, String nombre, Blob imagen, int tamano, int peso, String sexo) {
        this.id_propietario = propietario_id;
        this.id_raza = raza_id;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tamano = tamano;
        this.sexo = sexo;
        this.peso = peso;
    }
    
    public Mascota(int propietario_id, String nombre, String sexo, Timestamp nacimiento ){
        this.id_propietario = propietario_id;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
    }
    public Mascota(int id_mascota, int id_propietario, String nombre, String sexo, Timestamp nacimiento ){
        this(id_propietario, nombre, sexo, nacimiento);
        this.id_mascota = id_mascota;
    }
    
    public int getIdMascota() {
        return id_mascota;
    }
    
    public int setIdMascota(int id_mascota) {
        return this.id_mascota = id_mascota;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int propietario_id) {
        this.id_propietario = propietario_id;
    }

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int raza_id) {
        this.id_raza = raza_id;
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
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
