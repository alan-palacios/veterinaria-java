package models;

public class Raza extends DBObject {
    private String nombre;
    
    public Raza(int id, String nombre) {
        super(id);
        this.nombre = nombre;
    }
    
    public Raza(String nombre) {
        super();
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
