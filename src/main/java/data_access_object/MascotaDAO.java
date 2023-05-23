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
	
	private PreparedStatement insertBasicStatement, insertStatement, updateStatement, selectAllStatement, selectAllOwnerStatement, selectByIdStatement, deleteByIdStatement;
	
	private final String insertQuery = "INSERT INTO mascota (id_propietario, id_raza, fecha_nacimiento, nombre, imagen, tamano, sexo, peso) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String insertBasicQuery = "INSERT INTO mascota (id_propietario, nombre, sexo, fecha_nacimiento) VALUES (?, ?, ?, ?)";
	private final String updateQuery = "UPDATE mascota SET fecha_nacimiento=?, nombre=?, sexo=? WHERE id_mascota=?";
	private final String selectAllQuery = "SELECT * FROM mascota";
	private final String selectAllOwnerQuery = "SELECT * FROM mascota WHERE id_propietario=?";
	private final String selectByIdQuery = "SELECT * FROM mascota WHERE id_mascota=?";
	private final String deleteById = "DELETE FROM mascota WHERE id_mascota=?";

	public MascotaDAO(Connection connection){
		this.connection = connection;
		try {
			this.insertBasicStatement = this.connection.prepareStatement(this.insertBasicQuery, Statement.RETURN_GENERATED_KEYS); // flag generate auto increment key
			this.insertStatement = this.connection.prepareStatement(this.insertQuery, Statement.RETURN_GENERATED_KEYS); // flag generate auto increment key
			this.updateStatement = this.connection.prepareStatement(this.updateQuery);
			this.selectAllStatement = this.connection.prepareStatement(this.selectAllQuery);
			this.selectAllOwnerStatement = this.connection.prepareStatement(this.selectAllOwnerQuery);
			this.selectByIdStatement = this.connection.prepareStatement(this.selectByIdQuery);
			this.deleteByIdStatement = this.connection.prepareStatement(this.deleteById);
		} catch (Exception e) {
      e.printStackTrace();
		}
	}
	
	public Mascota saveBasicInfo(Mascota mascota) throws SQLException {
		if (mascota.getIdMascota() == -1) {
			// Insert
			this.insertBasicStatement.setInt(1, mascota.getId_propietario());
			this.insertBasicStatement.setString(2, mascota.getNombre());
			this.insertBasicStatement.setString(3, mascota.getSexo());
			this.insertBasicStatement.setTimestamp(4, mascota.getNacimiento());
			
			int idMascota = this.insertBasicStatement.executeUpdate();
			mascota.setIdMascota(idMascota);
		}
		return mascota;
	}
	// guardar mascota
	public Mascota save(Mascota mascota) throws SQLException {
		if (mascota.getIdMascota() == -1) {
			
			// Insert
			this.insertStatement.setInt(1, mascota.getId_propietario());
			this.insertStatement.setInt(2, mascota.getId_raza());
			this.insertStatement.setTimestamp(3, mascota.getNacimiento());
			this.insertStatement.setString(4, mascota.getNombre());
			this.insertStatement.setBlob(5, mascota.getImagen());
			this.insertStatement.setInt(6, mascota.getTamano());
			this.insertStatement.setString(7, mascota.getSexo());
			this.insertStatement.setInt(8, mascota.getPeso());
			
			int idMascota = this.insertStatement.executeUpdate();
			mascota.setIdMascota(idMascota);
			
			return mascota;
			
		} else {
			
			// Update
			this.updateStatement.setInt(1, mascota.getId_propietario());
			this.updateStatement.setInt(2, mascota.getId_raza());
			this.updateStatement.setTimestamp(3, mascota.getNacimiento());
			this.updateStatement.setString(4, mascota.getNombre());
			this.updateStatement.setBlob(5, mascota.getImagen());
			this.updateStatement.setInt(6, mascota.getTamano());
			this.updateStatement.setString(7, mascota.getSexo());
			this.updateStatement.setInt(8, mascota.getPeso());
			this.updateStatement.setInt(9, mascota.getIdMascota());

			this.updateStatement.executeUpdate();
			
			return mascota;
		}
	}
	
	public Mascota update(Mascota mascota) throws SQLException {
		this.updateStatement.setTimestamp(1 , mascota.getNacimiento());
		this.updateStatement.setString(2, mascota.getNombre());
		this.updateStatement.setString(3, mascota.getSexo());
		this.updateStatement.setInt(4, mascota.getIdMascota());
		this.updateStatement.executeUpdate();
		
		return mascota;
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
	
	public List<Mascota> getAllOfOwner(int idPropietario) throws SQLException {
		
		List<Mascota> mascotasList = new ArrayList<>();
		this.selectAllOwnerStatement.setInt(1, idPropietario);
		
		ResultSet resultSet = this.selectAllOwnerStatement.executeQuery();
		
		while(resultSet.next()) {
			Mascota mascota = new Mascota(
				resultSet.getInt("id_mascota"),
				resultSet.getInt("id_propietario"),
				resultSet.getInt("id_raza"),
				resultSet.getTimestamp("fecha_nacimiento"),
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
				resultSet.getInt("id_mascota"),
				resultSet.getInt("id_propietario"),
				resultSet.getInt("id_raza"),
				resultSet.getTimestamp("fecha_nacimiento"),
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
	
	public boolean delete(int idMascota) throws SQLException {
		this.deleteByIdStatement.setInt(1, idMascota);
		this.deleteByIdStatement.executeUpdate();
		return true;
	}
}
