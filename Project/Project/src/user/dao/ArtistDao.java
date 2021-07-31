package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.Artist;
import user.domain.Song;

public class ArtistDao {

	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Artist artist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "insert into artist_table values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
            preparestatement.setString(1, artist.getArtist_id());
		    preparestatement.setString(2, artist.getArtist_name());
            preparestatement.setString(3, artist.getArtist_email());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findallArtist() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "select * from artist_table";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Artist artist = new Artist();
				artist.setArtist_id(resultSet.getString("artist_id"));
				artist.setArtist_name(resultSet.getString("artist_name"));
	    		artist.setArtist_email(resultSet.getString("artist_email"));
	    		list.add(artist);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public Artist findById(String artist_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Artist artist = new Artist();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    String sql = "select * from Artist_table where artist_id=?";
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, artist_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String id = resultSet.getString("artist_id");
		    	if(id.equals(artist_id)){
		    		artist.setArtist_id(resultSet.getString("artist_id"));
		    		artist.setArtist_name(resultSet.getString("artist_name"));
		    		artist.setArtist_email(resultSet.getString("artist_email"));
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return artist;
	}
	
	public Artist update(Artist artist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		Connection connect = DriverManager
		          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
		
	    String sql = "UPDATE Artist_table SET artist_name=?,artist_email=? WHERE artist_id = ?";
		
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,artist.getArtist_name());
        preparestatement.setString(2 ,artist.getArtist_email());
	    preparestatement.setString(3,artist.getArtist_id());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return artist;
		
		
	}
	
	public Artist delete(Artist artist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "DELETE FROM Artist_table WHERE artist_id = ? ";
		Connection connect = DriverManager
		          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,artist.getArtist_id());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return artist;
		
	}


	public List<Object> sq1() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/music_manager?user=root&password=Goblin123!");
			
			
			String sql = "select * from artist_table Where artist_name='artist'";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Artist artist = new Artist();
				artist.setArtist_id(resultSet.getString("artist_id"));
				artist.setArtist_name(resultSet.getString("artist_name"));
	    		artist.setArtist_email(resultSet.getString("artist_email"));
	    		list.add(artist);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;	}
}
