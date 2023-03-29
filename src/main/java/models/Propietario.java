package models;

public class Propietario extends Persona {
    private String direccion;
    
    public Propietario(int id, String nombre, String apellido_paterno, String apellido_materno, String telefono, String email) {
        super(id, nombre, apellido_paterno, apellido_materno, telefono, email);
    }

    public Propietario(String nombre, String apellido_paterno, String apellido_materno, String telefono, String email) {
        super(nombre, apellido_paterno, apellido_materno, telefono, email);
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
