package models;

public class Documento extends DBObject{
    private int mascota_id; 
    private String nombre;
    private String descripcion;
    private Byte[] archivo;

    public Documento(int id, int mascota_id, String nombre, String descripcion, Byte[] archivo) {
        super(id);
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public Documento(int mascota_id, String nombre, String descripcion, Byte[] archivo) {
        super();
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }
    
    public int getMascotaId() {
        return mascota_id;
    }

    public void setMascotaId(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(Byte[] archivo) {
        this.archivo = archivo;
    }

}
