package playlistsongs.dao;

import java.sql.Connection;
import config.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import playlistsongs.domain.PlaylistSongs;




/**
 * DAO Class for PlaylistSongs
 * @author Sai Samarth
 *
 */
public class PlaylistSongsDao {
	
	/**
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Playlist playlistSongs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
			
			
			String sql = "INSERT INTO `playlist_songs` (`playlist_songs_id`, `playlist_id`, `song_id`) VALUES (?, ?, ?); ";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
            preparestatement.setString(1, playlistSongs.getPlaylistSongsId());
		    preparestatement.setString(2, playlistSongs.getPlaylistId());
            preparestatement.setString(3, playlistSongs.getSongId());
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
			
			
			String sql = "select * from playlist_songs";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				PlaylistSongs playlistSongs = new PlaylistSongs();
				playlistSongs.setPlaylistSongsId(resultSet.getString("playlist_song_id"));
				playlistSongs.setPlaylistId(resultSet.getString("playlist_id"));
	    		playlistSongs.setSongId(resultSet.getString("song_id"));
	    		list.add(playlist);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public PlaylistSongs findById(String playlist_songs_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PlaylistSongs playlistSongs = new PlaylistSongs();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    String sql = "select * from playlist_songs where playlist_songs_id=?";
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1, playlist_songs_id);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	String id = resultSet.getString("playlist__songs_id");
		    	if(id.equals(playlist_songs_id)){
		    		playlistSongs.setPlaylistSongsId(resultSet.getString("playlist_songs_id"));
		    		playlistSongs.setPlaylistId(resultSet.getString("playlist_id"));
		    		playlistSongs.setSongId(resultSet.getString("song_id"));
		    	}
		    }
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return playlist;
	}
	
	public PlaylistSongs updatePlaylist(PlaylistSongs playlistSongs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "UPDATE playlist SET playlist_id=?, song_id=? WHERE playlist_songs_id = ?";
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,playlistSongs.getPlaylistId());
        preparestatement.setString(2 ,playlistSongs.getSongID());
	    preparestatement.setString(3,playlistSongs.getPlaylistSongsId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return playlistSongs;
		
		
	}
	
	public PlaylistSongs deletePlaylist(PlaylistSongs playlistSongs) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	    String sql = "DELETE FROM playlist_songs WHERE playlist_songs_id = ? ";
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DATABASE NAME?"
				              + "user=root&password=PASSWORD");
	    PreparedStatement preparestatement = connect.prepareStatement(sql); 
	    preparestatement.setString(1,playlistSongs.getPlaylistSongsId());
	    System.out.println(preparestatement.toString());
	    preparestatement.executeUpdate();

	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	return playlistSongs;
		
	}
	
	
		
}