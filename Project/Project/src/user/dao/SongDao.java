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
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
		    String sql = "select * from song_table where song_id=?";
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
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "insert into song_table values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,user.getSong_id());
		    preparestatement.setString(2,user.getSong_name());
		    preparestatement.setInt(3,user.getArtist_id());
		    preparestatement.setInt(4,user.getAlbum_id());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void update(Song user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "UPDATE song_table SET song_name=?, artist_id=?, album_id=? WHERE song_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getSong_name());
		    preparestatement.setInt(2,user.getArtist_id());
		    preparestatement.setInt(3,user.getAlbum_id());
		    preparestatement.setInt(4,user.getSong_id());


		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Song user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "DELETE FROM song_table WHERE song_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,user.getSong_id());

		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Object> findallSongs() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "select * from song_table";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Song user = new Song();
				user.setSong_id(resultSet.getInt("song_id"));
	    		user.setSong_name(resultSet.getString("song_name"));
	    		user.setArtist_id(resultSet.getInt("artist_id"));
	    		user.setAlbum_id(resultSet.getInt("album_id"));

	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}




	public List<Object> sq2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "select * from song_table order by artist_id";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Song user = new Song();
				user.setSong_id(resultSet.getInt("song_id"));
	    		user.setSong_name(resultSet.getString("song_name"));
	    		user.setArtist_id(resultSet.getInt("artist_id"));
	    		user.setAlbum_id(resultSet.getInt("album_id"));

	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
