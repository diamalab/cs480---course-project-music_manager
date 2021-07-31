package artist.dao;

import java.sql.Connection;
import config.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import artist.domain.Artist;
import user.domain.User;




/**
 * DAO Class for Artist
 * @author changxin bai
 *
 */
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
					.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
			
			
			String sql = "INSERT INTO `artist` (`artist_id`, `artist_name`, `artist_email`) VALUES (?, ?, ?); ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
            preparestatement.setString(1, artist.getArtistId());
		    preparestatement.setString(2, artist.getName());
            preparestatement.setString(3, artist.getEmail());
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
					.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?" + "user=root&password=PASSWORD");
			
			
			String sql = "select * from artist";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Artist artist = new Artist();
				artist.setArtistId(resultSet.getString("artist_id"));
				artist.setName(resultSet.getString("artist_name"));
	    		artist.setEmail(resultSet.getString("artist_email"));
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
		    String sql = "select * from artist where artist_id=?";
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, artist_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String id = resultSet.getString("artist_id");
		    	if(id.equals(artist_id)){
		    		artist.setArtistId(resultSet.getString("artist_id"));
		    		artist.setName(resultSet.getString("artist_name"));
		    		artist.setEmail(resultSet.getString("artist_email"));
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return artist;
	}
	
	public Artist updateArtist(Artist artist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "UPDATE artist SET artist_name=?,artist_email=? WHERE artist_id = ?";
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,artist.getName());
        preparestatement.setString(2 ,artist.getEmail());
	    preparestatement.setString(3,artist.getArtistId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return artist;
		
		
	}
	
	public Artist deleteArtist(Artist artist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "DELETE FROM artist WHERE artist_id = ? ";
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,artist.getArtistId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return artist;
		
	}
	
	
		
}
