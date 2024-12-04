package playlist.dao;

import java.sql.Connection;
import config.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import playlist.domain.Playlist;




/**
 * DAO Class for Playlist
 * @author Sai Samarth
 *
 */
public class PlaylistDao {
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Playlist playlist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
			
			
			String sql = "INSERT INTO `playlist` (`playlist_id`, `playlist_name`, `user_id`) VALUES (?, ?, ?); ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
            preparestatement.setString(1, playlist.getPlaylistId());
		    preparestatement.setString(2, playlist.getPlaylistName());
            preparestatement.setString(3, playlist.getUserId());
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
			
			
			String sql = "select * from playlist";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Playlist playlist = new Playlist();
				playlist.setPlaylistId(resultSet.getString("playlist_id"));
				playlist.setPlaylistName(resultSet.getString("playlist_name"));
	    		playlist.setUserId(resultSet.getString("user_id"));
	    		list.add(playlist);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public Playlist findById(String playlist_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Playlist playlist = new Playlist();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    String sql = "select * from playlist where playlist_id=?";
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, playlist_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String id = resultSet.getString("playlist_id");
		    	if(id.equals(playlist_id)){
		    		playlist.setPlaylistId(resultSet.getString("playlist_id"));
		    		playlist.setPlaylistName(resultSet.getString("playlist_name"));
		    		playlist.setUserId(resultSet.getString("user_id"));
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return playlist;
	}
	
	public Playlist updatePlaylist(Playlist playlist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "UPDATE playlist SET playlist_name=?, user_id=? WHERE playlist_id = ?";
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,playlist.getPlaylistName());
        preparestatement.setString(2 ,playlist.getUserID());
	    preparestatement.setString(3,playlist.getPlaylistId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return playlist;
		
		
	}
	
	public Playlist deletePlaylist(Playlist playlist) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "DELETE FROM playlist WHERE playlist_id = ? ";
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,playlist.getPlaylistId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return playlist;
		
	}
	
	
		
}