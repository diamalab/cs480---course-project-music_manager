package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.Song;

public class SongDao {


	
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
			          .getConnection("jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=Goblin123!");
		    String sql = "select * from song where song_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String s_id = resultSet.getString("song_id");
		    	song_id = resultSet.getInt("song_id");
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
	public void add(Song user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=Goblin123!");
			
			
			String sql = "insert into song_table values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getSong_id());
		    preparestatement.setString(2,user.getSong_name());
		    preparestatement.setString(3,user.getArtist_id());
		    preparestatement.setString(4,user.getAlbum_id());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void update(Song user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=Goblin123!");
			
			
			String sql = "Update song_table set song_id=?, song_name=?, artist_id=? album_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getSong_id());
		    preparestatement.setString(2,user.getSong_name());
		    preparestatement.setString(3,user.getArtist_id());
		    preparestatement.setString(4,user.getAlbum_id());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Song user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=Goblin123!");
			
			
			String sql = "DELETE FROM song_table WHERE song_id=?, song_name=?, artist_id=? album_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getSong_id());
		    preparestatement.setString(2,user.getSong_name());
		    preparestatement.setString(3,user.getArtist_id());
		    preparestatement.setString(4,user.getAlbum_id());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=Goblin123!");
			
			
			String sql = "select * from song_table";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Song user = new Song();
				user.setSong_id(resultSet.getString("song_id"));
	    		user.setSong_name(resultSet.getString("song_name"));
	    		user.setArtist_id(resultSet.getString("artist_id"));
	    		user.setAlbum_id(resultSet.getString("album_id"));

	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
