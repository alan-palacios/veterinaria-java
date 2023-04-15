package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

import models.Propietario;

public class PropietarioDAO {
	private Connection connection; 
	
	private PreparedStatement insertStatement, updateStatement, selectAllStatement, selectByIdStatement;
	
	private final String insertQuery = "INSERT INTO propietario (correo, nombre, appat, apmat, dir, password) VALUES (?, ?, ?, ?, ?, ?)";
	private final String updateQuery = "UPDATE propietario SET correo=?, nombre=?, appat=?, apmat=?, dir=?, password=? WHERE id=?";
	private final String selectAllQuery = "SELECT * FROM propietario";
	private final String selectByIdQuery = "SELECT * FROM propietario WHERE id_propietario=?";

	public PropietarioDAO(Connection connection){
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
	public Propietario save(Propietario propietario) throws SQLException {
		System.out.println(propietario.getIdPropietario());
		if (propietario.getIdPropietario() == -1) {
			// cifrar contraseña
			propietario.setPassword(BCrypt.hashpw(propietario.getPassword(), BCrypt.gensalt()));

			// Insert propietario
			this.insertStatement.setString(1, propietario.getCorreo());
			this.insertStatement.setString(2, propietario.getNombre());
			this.insertStatement.setString(3, propietario.getAppat());
			this.insertStatement.setString(4, propietario.getApmat());
			this.insertStatement.setString(5, propietario.getDir());
			this.insertStatement.setString(6, propietario.getPassword());
			
			int idPropietario = this.insertStatement.executeUpdate();
			System.out.println("idPropietario: "+idPropietario);
			
			propietario.setIdPropietario(idPropietario);
			
			return propietario;
			
		} else {
			// Update
			this.updateStatement.setString(1, propietario.getCorreo());
			this.updateStatement.setString(2, propietario.getNombre());
			this.updateStatement.setString(3, propietario.getAppat());
			this.updateStatement.setString(4, propietario.getApmat());
			this.updateStatement.setString(5, propietario.getDir());
			this.updateStatement.setString(6, propietario.getPassword());
			this.updateStatement.setInt(7, propietario.getIdPropietario());

			this.updateStatement.executeUpdate();
			
			return propietario;
		}
	}

	// Obtener todas las mascotas
	public List<Propietario> getAll() throws SQLException {
		
		List<Propietario> propietarioList = new ArrayList<>();
		
		ResultSet resultSet = this.selectAllStatement.executeQuery();
		
		while(resultSet.next()) {
			Propietario propietario = new Propietario(
				resultSet.getInt("id_propietario"),
				resultSet.getString("correo"),
				resultSet.getString("nombre"),
				resultSet.getString("appat"),
				resultSet.getString("apmat"),
				resultSet.getString("dir"),
				resultSet.getString("password")
			);
			
			propietarioList.add(propietario);
		}
		return propietarioList;
	}
	
	// Obtener mascota por id
	public Propietario getById(int idPropietario) throws SQLException {
		
		this.selectByIdStatement.setInt(1, idPropietario);
		
		ResultSet resultSet = this.selectByIdStatement.executeQuery();
		
		if(resultSet.next()) {
			Propietario propietario = new Propietario(
				resultSet.getInt("id_propietario"),
				resultSet.getString("correo"),
				resultSet.getString("nombre"),
				resultSet.getString("appat"),
				resultSet.getString("apmat"),
				resultSet.getString("dir"),
				resultSet.getString("password")
			);
			
			return propietario;
		}
		return null;
	}
	
}
