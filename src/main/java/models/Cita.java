package models;

import java.sql.Timestamp;

public class Cita extends DBObject{
    private int mascota_id;
    private int veterinario_id;
    private String descripcion;
    private Timestamp fecha;
    private Timestamp fecha_creacion;
    private Timestamp fecha_modificacion;
    
    public Cita(int id, int mascota_id, int veterinario_id, String descripcion, Timestamp fecha, Timestamp fecha_creacion, Timestamp fecha_modificacion) {
        super(id);
        this.mascota_id = mascota_id;
        this.veterinario_id = veterinario_id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Cita(int mascota_id, int veterinario_id, String descripcion, Timestamp fecha, Timestamp fecha_creacion, Timestamp fecha_modificacion) {
        super();
        this.mascota_id = mascota_id;
        this.veterinario_id = veterinario_id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }
    
    public int getMascotaId() {
        return mascota_id;
    }

    public void setMascotaId(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public int getVeterinarioId() {
        return veterinario_id;
    }

    public void setVeterinarioId(int veterinario_id) {
        this.veterinario_id = veterinario_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Timestamp getFechaCreacion() {
        return fecha_creacion;
    }

    public void setFechaCreacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    public Timestamp getFechaModificacion() {
        return fecha_modificacion;
    }

    public void setFechaModificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
