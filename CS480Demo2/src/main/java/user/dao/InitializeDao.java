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
 * @author changxin bai
 *
 */
public class InitializeDao {
	
	
	
	public void initDB() {
		Statement statement;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/music_manager?"
				              + "user=root&password=password");
		   
		statement = connect.createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS song");
		statement.executeUpdate("DROP TABLE IF EXISTS song_info");
		statement.executeUpdate("DROP TABLE IF EXISTS playlist");
		statement.executeUpdate("DROP TABLE IF EXISTS album");
		statement.executeUpdate("DROP TABLE IF EXISTS genre");
		statement.executeUpdate("DROP TABLE IF EXISTS artist");
		statement.executeUpdate("DROP TABLE IF EXISTS artist_info");
		statement.executeUpdate("DROP TABLE IF EXISTS song_s");
		statement.executeUpdate("DROP TABLE IF EXISTS album_s");
		statement.executeUpdate("DROP TABLE IF EXISTS keyword");
		statement.executeUpdate("DROP TABLE IF EXISTS user_playlist");
		statement.executeUpdate("DROP TABLE IF EXISTS user");
		
		
		
		String sqlstmt = "CREATE TABLE IF NOT EXISTS song ("
				+ "	id INT NOT NULL,"
				+ "	name VARCHAR(100) NOT NULL,"
				+ "	PRIMARY KEY(id)"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IF NOT EXISTS playlist ("
				+ "	id INT NOT NULL,"
				+ "	song_id INT,"
				+ "	PRIMARY KEY(id),"
				+ "	FOREIGN KEY(song_id) REFERENCES song(id) ON DELETE CASCADE"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IS NOT EXISTS album ("
				+ "	id INT AUTO_INCREMENT NOT NULL,"
				+ "	name VARCHAR(200),"
				+ "	release_date DATE,"
				+ "	genre INT,"
				+ "	PRIMARY KEY(id)"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IF NOT EXISTS genre ("
				+ "	id INT NOT NULL AUTO_INCREMENT,"
				+ "	name VARCHAR(100) NOT NULL CHECK (name IN (\"Hip-Hop\", \"Rock\", \"R&B\", \"Country\", \"Pop\", \"K-Pop\", \"Classical\", \"Soul\", \"Dance/Electronic\", \"Jazz\", \"Punk\", \"Desi\", \"Metal\")),"
				+ "	PRIMARY KEY(id)"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IF NOT EXISTS artist ("
				+ "	id VARCHAR(200) NOT NULL UNIQUE,"
				+ "	artist_name VARCHAR(200),"
				+ "	keyword VARCHAR(200) NOT NULL UNIQUE,"
				+ "	PRIMARY KEY(id)	"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IF NOT EXISTS artist_info ("
				+ "	artist_id INT NOT NULL AUTO_INCREMENT,"
				+ "	name VARCHAR(200),"
				+ "	email VARCHAR(200),"
				+ "	PRIMARY KEY(artist_id),"
				+ "	FOREIGN KEY(artist_id) REFERENCES artist(id)"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IF NOT EXISTS song_info ("
				+ "	song_info_id INT AUTO_INCREMENT,"
				+ "	song_id INT,"
				+ "	artist_id VARCHAR(100) NOT NULL,"
				+ "	album_id VARCHAR(100) NOT NULL,"
				+ "	genre _id VARCHAR(100),"
				+ "	PRIMARY KEY(song_info_id),"
				+ "	FOREIGN KEY(song_id) REFERENCES song(id),"
				+ "	FOREIGN KEY(artist_id) REFERENCES  artist_info(artist_id),"
				+ "	FOREIGN KEY(album_id) REFERENCES album(id),"
				+ "	FOREIGN KEY(genre_id) REFERENCES genre(id)"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IF NOT EXISTS album_s ("
				+ "	id VARCHAR(200) NOT NULL UNIQUE,"
				+ "	keyword VARCHAR(200) NOT NULL UNIQUE,"
				+ "	album_id INT NOT NULL,"
				+ "	PRIMARY KEY(id)"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "CREATE TABLE IF NOT EXISTS song_s ("
				+ "	id VARCHAR(200) NOT NULL UNIQUE,"
				+ "	song_id INT NOT NULL,"
				+ "	keyword VARCHAR(200) NOT NULL UNIQUE,"
				+ "	PRIMARY KEY(id)"
				+ ");";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "INSERT INTO song(name) \r\n"
				+ "VALUES ('Humble', 'DNA', 'Goosebumps', 'WUSYANAME', 'Heartless');";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "INSERT INTO playlist(song_id)"
				+ "VALUES(1, 2, 3),"
				+ "(1, 3, 4),"
				+ "(4, 5, 2);";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "INSERT INTO artist(artist_name, keyword)"
				+ "VALUES('Kanye', 'KW'),"
				+ "('Kendrick', 'KL'),"
				+ "('Travis Scott', 'TS');";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "INSERT INTO album(name, release_date, genre)"
				+ "VALUES ('ASTROWORLD', '2018-02-08', 'Hip-Hop'),"
				+ "('IGOR', '2019-05-03', 'R&B'),"
				+ "('DAMN', '2017-04-24', 'Hip-Hop');";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "INSERT INTO genre(name)"
				+ "VALUES ('Hip-Hop')"
				+ "('R&B'),"
				+ "('Rock');";
		
		statement.executeUpdate(sqlstmt);
		
		sqlstmt = "INSERT INTO song_info(song_id, artist_id, album_id, genre _id)"
				+ "VALUES (1, 3, 1, 1)"
				+ "(2, 2, 3, 1),"
				+ "(3, 1, 2, 3);";
		
		statement.executeUpdate(sqlstmt);
		
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
		
}
