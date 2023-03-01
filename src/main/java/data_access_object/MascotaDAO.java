/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Mascota;

/**
 *
 * @author AlanPalacios
 */
public class MascotaDAO {
	private Connection connection; 
	
	private PreparedStatement insertStatement, selectAllStatement, selectByIdStatement;
	
	private final String insertQuery = "INSERT INTO mascotas(propietario_id, raza_id, nacimiento, nombre, imagen, tamano) VALUES(?, ?, ?, ?, ?, ?)"; 
	private final String selectAllQuery = "SELECT * FROM mascotas";
	private final String selectByIdQuery = "SELECT * FROM mascotas WHERE id=?";
	
	/**
	 * Setting connection
	 * @throws SQLException 
	 */
	public void setConnection(Connection connection) throws SQLException {
		this.connection = connection;
		this.insertStatement = this.connection.prepareStatement(this.insertQuery, Statement.RETURN_GENERATED_KEYS); // flag generate auto increment key
		this.selectAllStatement = this.connection.prepareStatement(this.selectAllQuery);
		this.selectByIdStatement = this.connection.prepareStatement(this.selectByIdQuery);
	}
	
	/**
	 * Guardar mascota
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public Mascota save(Mascota mascota) throws SQLException {
		if (mascota.getId() ==0) {
			
			// Insert
			this.insertStatement.setInt(1, mascota.getPropietario_id());
			this.insertStatement.setInt(2, mascota.getRaza_id());
			this.insertStatement.setTimestamp(3, mascota.getNacimiento());
			this.insertStatement.setString(4, mascota.getNombre());
			this.insertStatement.setBlob(5, mascota.getImagen());
			this.insertStatement.setInt(6, mascota.getTamano());
			
			int idMascota = this.insertStatement.executeUpdate();
			mascota.setId(idMascota);
			
			return mascota;
			
		} else {
			
			// Update
			//this.updateStatement.setString(1, user.getUsername());
			//this.updateStatement.setString(2, user.getPassword());
			//this.updateStatement.setString(3, user.getNamaLengkap());
			//this.updateStatement.setInt(4, user.getIdUser());
			
			//this.updateStatement.executeUpdate();
			
			return mascota;
		}
	}

	/**
	 * Obtener todas las mascotas
	 * 
	 * @return List : Mascota - Devuelve todas las mascotas que hay en la base de datos
	 * @throws SQLException 
	 */
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
				resultSet.getInt("tamano")
			);
			
			mascotasList.add(mascota);
		}
		
		return mascotasList;
		
	}
	
	/**
	 * Obtener mascota por id
	 * 
	 * @param idMascota
	 * @return Mascota - Devuelve la mascota que se ha seleccionado por id
	 * @throws SQLException 
	 */
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
				resultSet.getInt("tamano")
			);
			
			return mascota;
			
		}
		
		return null;
		
	}
	
}
