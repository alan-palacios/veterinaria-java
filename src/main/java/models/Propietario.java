package models;

public class Propietario {
    private int id_propietario=-1;
    private String correo;
    private String nombre;
    private String appat;
    private String apmat;
    private String dir;
    private String password;
    
    public Propietario(int id_propietario, String correo, String nombre, String appat, String apmat, String dir, String password) {
        this(correo, nombre, appat, apmat, dir, password);
        this.id_propietario = id_propietario;
    }

    public Propietario(String correo, String nombre, String appat, String apmat, String dir, String password) {
        this.correo = correo;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.dir = dir;
        this.password = password;
    }
    
    // Write all Getters and Setters
    
    public int getIdPropietario() {
        return id_propietario;
    }

    public void setIdPropietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
