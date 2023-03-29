package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Mascota;

public class MascotaDAO {
	private Connection connection; 
	
	private PreparedStatement insertStatement, updateStatement, selectAllStatement, selectByIdStatement;
	
	private final String insertQuery = "INSERT INTO mascotas (propietario_id, raza_id, nacimiento, nombre, imagen, tamano, sexo, peso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String updateQuery = "UPDATE mascotas SET propietario_id=?, raza_id=?, nacimiento=?, nombre=?, imagen=?, tamano=?, sexo=?, peso=? WHERE id=?";
	private final String selectAllQuery = "SELECT * FROM mascotas";
	private final String selectByIdQuery = "SELECT * FROM mascotas WHERE id=?";

	public MascotaDAO(Connection connection){
		this.connection = connection;
		try {
			this.insertStatement = this.connection.prepareStatement(this.insertQuery, Statement.RETURN_GENERATED_KEYS); // flag generate auto increment key
			this.updateStatement = this.connection.prepareStatement(this.updateQuery);
			this.selectAllStatement = this.connection.prepareStatement(this.selectAllQuery);
			this.selectByIdStatement = this.connection.prepareStatement(this.selectByIdQuery);
		} catch (Exception e) {
      e.printStackTrace();
		}
	}
	
	// guardar mascota
	public Mascota save(Mascota mascota) throws SQLException {
		if (mascota.getId() == -1) {
			
			// Insert
			this.insertStatement.setInt(1, mascota.getPropietario_id());
			this.insertStatement.setInt(2, mascota.getRaza_id());
			this.insertStatement.setTimestamp(3, mascota.getNacimiento());
			this.insertStatement.setString(4, mascota.getNombre());
			this.insertStatement.setBlob(5, mascota.getImagen());
			this.insertStatement.setInt(6, mascota.getTamano());
			this.insertStatement.setString(7, mascota.getSexo());
			this.insertStatement.setInt(8, mascota.getPeso());
			
			int idMascota = this.insertStatement.executeUpdate();
			mascota.setId(idMascota);
			
			return mascota;
			
		} else {
			
			// Update
			this.updateStatement.setInt(1, mascota.getPropietario_id());
			this.updateStatement.setInt(2, mascota.getRaza_id());
			this.updateStatement.setTimestamp(3, mascota.getNacimiento());
			this.updateStatement.setString(4, mascota.getNombre());
			this.updateStatement.setBlob(5, mascota.getImagen());
			this.updateStatement.setInt(6, mascota.getTamano());
			this.updateStatement.setString(7, mascota.getSexo());
			this.updateStatement.setInt(8, mascota.getPeso());
			this.updateStatement.setInt(9, mascota.getId());

			this.updateStatement.executeUpdate();
			
			return mascota;
		}
	}

	// Obtener todas las mascotas
	public List<Mascota> getAll() throws SQLException {
		
		List<Mascota> mascotasList = new ArrayList<>();
		
		ResultSet resultSet = this.selectAllStatement.executeQuery();
		
		while(resultSet.next()) {
			Mascota mascota = new Mascota(
				resultSet.getInt("id"),
				resultSet.getInt("propietario_id"),
				resultSet.getInt("raza_id"),
				resultSet.getTimestamp("nacimiento"),
				resultSet.getString("nombre"),
				resultSet.getBlob("imagen"),
				resultSet.getInt("tamano"),
				resultSet.getInt("peso"),
				resultSet.getString("sexo")
			);
			
			mascotasList.add(mascota);
		}
		return mascotasList;
	}
	
	// Obtener mascota por id
	public Mascota getById(int idMascota) throws SQLException {
		
		this.selectByIdStatement.setInt(1, idMascota);
		
		ResultSet resultSet = this.selectByIdStatement.executeQuery();
		
		if(resultSet.next()) {
			Mascota mascota = new Mascota(
				resultSet.getInt("id"),
				resultSet.getInt("propietario_id"),
				resultSet.getInt("raza_id"),
				resultSet.getTimestamp("nacimiento"),
				resultSet.getString("nombre"),
				resultSet.getBlob("imagen"),
				resultSet.getInt("tamano"),
				resultSet.getInt("peso"),
				resultSet.getString("sexo")
			);
			
			return mascota;
		}
		return null;
	}
	
}
