/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access_object;

/**
 *
 * @author AlanPalacios
 */
public class MascotaDAO {
	private Connection connection; 
	
	private PreparedStatement insertStatement, updateStatement, deleteStatement, selectAllStatement, selectByIdStatement, selectByUsernameStatement;
	
	private final String insertQuery = "INSERT INTO user(username_user, password_user, nama_lengkap_user) VALUES(?,?,?)";
	private final String updateQuery = "UPDATE INTO user SET username_user=?, password_user=?, nama_lengkap_user=? WHERE id_user=?";
	private final String deleteQuery = "DELETE FROM user WHERE id_user=?";
	private final String selectAllQuery = "SELECT * FROM user";
	private final String selectByIdQuery = "SELECT * FROM user WHERE id_user=?";
	private final String selectByUsernameQuery = "SELECT * FROM user WHERE username_user=?";
	
	/**
	 * Setting koneksi
	 * @throws SQLException 
	 */
	public void setConnection(Connection connection) throws SQLException {
		
		this.connection = connection;
		
		this.insertStatement = this.connection.prepareStatement(this.insertQuery, Statement.RETURN_GENERATED_KEYS); // flag generate auto increment key
		this.updateStatement = this.connection.prepareStatement(this.updateQuery);
		this.deleteStatement = this.connection.prepareStatement(this.deleteQuery);
		this.selectAllStatement = this.connection.prepareStatement(this.selectAllQuery);
		this.selectByIdStatement = this.connection.prepareStatement(this.selectByIdQuery);
		this.selectByUsernameStatement = this.connection.prepareStatement(this.selectByUsernameQuery);
		
	}
	
	
	/**
	 * Save user data, set idUser to 0 if you want to save it as new data
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User save(User user) throws SQLException {
		
		if(user.getIdUser() == 0) {
			
			// Insert
			this.insertStatement.setString(1, user.getUsername());
			this.insertStatement.setString(2, user.getPassword());
			this.insertStatement.setString(3, user.getNamaLengkap());
			
			int idUser = this.insertStatement.executeUpdate();
			user.setIdUser(idUser);
			
			return user;
			
		} else {
			
			// Update
			this.updateStatement.setString(1, user.getUsername());
			this.updateStatement.setString(2, user.getPassword());
			this.updateStatement.setString(3, user.getNamaLengkap());
			this.updateStatement.setInt(4, user.getIdUser());
			
			this.updateStatement.executeUpdate();
			
			return user;
			
		}
		
	}
}
