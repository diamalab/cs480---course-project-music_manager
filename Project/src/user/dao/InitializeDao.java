package user.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;



/**
 * DDL functions performed in database
 *
 */
public class UserDao {
	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void initDB() {
		Statement statement;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=Goblin123!");
		    
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS user");
			String sqlstmt = "CREATE TABLE user ("
					+ "	user_id INT UNIQUE NOT NULL, "
					+ "	user_name VARCHAR(100) NOT NULL,"
					+ "	user_email VARCHAR(20) NOT NULL,"
					+ "	sex VARCHAR(20),\n"
					+ "	password VARCHAR(50) NOT NULL,"
					+ "	PRIMARY KEY(user_id)"
					+ ");";
			statement.executeUpdate(sqlstmt);
			
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS artist");
			String sqlstmt1 = "CREATE TABLE artist ("
					+ "	artist_id INT NOT NULL UNIQUE,"
					+ "	artist_name VARCHAR(100) NOT NULL,"
					+ "	artist_email VARCHAR(20) NOT NULL ,"
					+ "	PRIMARY KEY(artist_id)"
					+ ");";
			statement.executeUpdate(sqlstmt1);
					
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS following");
			String sqlstmt2 = "CREATE TABLE following ("
					+ "	following_id INT UNIQUE NOT NULL,"
					+ "	user_id INT NOT NULL,"
					+ "	follower_id INT NOT NULL,"
					+ "	PRIMARY KEY(following_id),"
					+ "	FOREIGN KEY(user_id) REFERENCES user(user_id),"
					+ "	FOREIGN KEY(follower_id) REFERENCES user(user_id)"
					+ ");";
			statement.executeUpdate(sqlstmt2);
			
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS album");
			String sqlstmt3 = "CREATE TABLE album ("
					+ "	album_id INT UNIQUE NOT NULL,"
					+ "	album_name VARCHAR(100) NOT NULL,"
					+ "	artist_id INT NOT NULL,"
					+ "	genre VARCHAR(20) NOT NULL,"
					+ "	PRIMARY KEY(album_id),"
					+ "	FOREIGN KEY(artist_id) REFERENCES artist(artist_id)"
					+ ");";
			statement.executeUpdate(sqlstmt3);
			
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS song");
			String sqlstmt4 = "CREATE TABLE song ("
					+ "	song_id INT NOT NULL UNIQUE,"
					+ "	song_name VARCHAR(100) NOT NULL,"
					+ "	album_id INT NOT NULL,"
					+ "	artist_id INT NOT NULL,"
					+ "	PRIMARY KEY(song_id),"
					+ "	FOREIGN KEY(album_id) REFERENCES album(album_id),"
					+ "	FOREIGN KEY(artist_id) REFERENCES artist(artist_id)"
					+ ");";
			statement.executeUpdate(sqlstmt4);
			
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS playlist");
			String sqlstmt5 = "CREATE TABLE playlist ("
					+ "	playlist_id INT NOT NULL UNIQUE,"
					+ "	user_id INT NOT NULL,"
					+ "	playlist_name VARCHAR(100) NOT NULL,"
					+ "	PRIMARY KEY(playlist_id),"
					+ "	FOREIGN KEY(user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");";
			statement.executeUpdate(sqlstmt5);
			
			
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS playlist_songs");
			String sqlstmt6 = "CREATE TABLE playlist_songs ("
					+ "	playlist_songs_id INT NOT NULL UNIQUE,"
					+ "	playlist_id INT NOT NULL,"
					+ "	song_id INT NOT NULL,"
					+ "	PRIMARY KEY(playlist_songs_id),"
					+ "	FOREIGN KEY(playlist_id) REFERENCES playlist(playlist_id) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "	FOREIGN KEY(song_id) REFERENCES song(song_id) ON DELETE CASCADE ON UPDATE CASCADE"
					+ ");";
			statement.executeUpdate(sqlstmt6);
			
			
			resultSet = statement
			          .executeQuery("select * from song, artist, user, playlist_songs, album, following, playlist;");

			      writeResultSet(resultSet);
			// find all followers of a user
			resultSet = statement.executeQuery("select u.user_name from following f join user u on u.user_id = f.follower_id and f.user_id = 02")
			writeResultSet(resultSet);
			
			// Songs from the hip-hop genre
			resultSet = statement.executeQuery("SELECT s.song_nameFROM song s INNER JOIN album a ON a.artist_id = s.artist_id AND a.genre = ‘Hip-Hop’;")
			writeResultSet(resultSet);
			
			// Playlists of a user's followers
			resultSet = statement.executeQuery("SELECT * FROM playlist WHERE user_id IN (SELECT follower_id FROM following WHERE user_id=02);")
			writeResultSet(resultSet);
			
			// find all playlist that only have songs by one artist
			resultSet = statement.executeQuery("SELECT p.playlist_name FROM playlist p JOIN playlist_songs ps ON p.playlist_id = ps.playlist_id JOIN song s ON ps.song_id = s.song_id GROUP BY p.playlist_id HAVING COUNT(DISTINCT s.artist_id) = 1;")
			writeResultSet(resultSet);
			
			// find the most popular genre and the number of songs
			resultSet = statement.executeQuery("SELECT a.genre, count(*) songs from album a INNER JOIN song s ON a.album_id = s.album_id GROUP BY a.genre ORDER BY 2 DESC LIMIT 1;")
			writeResultSet(resultSet);	
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	
	

		
}
