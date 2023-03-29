package models;

public class DBObject {
    private int id = -1;

    public DBObject(int id) {
        this.id = id;
    }
    
    public DBObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
}
