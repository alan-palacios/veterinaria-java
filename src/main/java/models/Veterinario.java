package models;

public class Veterinario extends Persona {
    private String cedula;

    public Veterinario(int id, String nombre, String apellido_paterno, String apellido_materno, String telefono, String email) {
        super(id, nombre, apellido_paterno, apellido_materno, telefono, email);
    }
  
    public Veterinario(String nombre, String apellido_paterno, String apellido_materno, String telefono, String email) {
        super(nombre, apellido_paterno, apellido_materno, telefono, email);
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
