package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.Album;

public class AlbumDao {


	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public int findSongId(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		int song_id = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
		    String sql = "select * from album_table where album_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String s_id = resultSet.getString("album_id");
		    	song_id = resultSet.getInt("album_id");
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return song_id;
	}
	
	
	
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Album user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "insert into album_table values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,user.getAlbum_id());
		    preparestatement.setString(2,user.getAlbum_name());
		    preparestatement.setInt(3,user.getArtist_id());
		    preparestatement.setInt(4,user.getGenre());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void update(Album user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "UPDATE album_table SET album_name=?, artist_id=?, genre=? WHERE album_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getAlbum_name());
		    preparestatement.setInt(2,user.getArtist_id());
		    preparestatement.setInt(3,user.getGenre());
		    preparestatement.setInt(4,user.getAlbum_id());


		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Album user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "DELETE FROM album_table WHERE album_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,user.getAlbum_id());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Object> findallAlbums() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "select * from album_table";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Album user = new Album();
				user.setAlbum_id(resultSet.getInt("album_id"));
	    		user.setAlbum_name(resultSet.getString("album_name"));
	    		user.setArtist_id(resultSet.getInt("artist_id"));
	    		user.setGenre(resultSet.getString("genre"));

	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}




	public List<Object> sq3() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "select * from album_table Where artist_name='artist'";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Album user = new Album();
				user.setAlbum_id(resultSet.getInt("album_id"));
	    		user.setAlbum_name(resultSet.getString("album_name"));
	    		user.setArtist_id(resultSet.getInt("artist_id"));
	    		user.setGenre(resultSet.getString("genre"));

	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
