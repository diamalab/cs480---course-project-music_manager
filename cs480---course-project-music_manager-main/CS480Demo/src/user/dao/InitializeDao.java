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
import java.sql.Statement;


public class InitializeDao {
	static Connection connect;
	static Statement statement;
	PreparedStatement preparedStatement;
	static ResultSet resultSet;
	
	public void InitDB()	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://127.0.0.1:3306/demo?"
				              + "user=root&password=Goblin123!");
		
		statement = connect.createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS Song");
		String sqlstmt = "CREATE TABLE IF NOT EXISTS Song " +
		" ( Song_ID INTEGER not NULL AUTO_INCREMENT, " +
		" Song_Name VARCHAR(50) not NULL, " +
		" Artist_ID Integer not NULL, " +
		" PRIMARY KEY ( Song_ID ))";
		statement.executeUpdate(sqlstmt);
		
		statement = connect.createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS Artist_Info");
		String sqlstmt1 = "CREATE TABLE IF NOT EXISTS Artist_Info " +
		" ( Artist_ID INTEGER not NULL AUTO_INCREMENT, " +
		" Artist_Name VARCHAR(50) not NULL, " +
		" Artist_Email VARCHAR(50) not NULL, " +
		" PRIMARY KEY ( Artist_ID ))";
		statement.executeUpdate(sqlstmt1);
				
		statement = connect.createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS User");
		String sqlstmt2 = "CREATE TABLE IF NOT EXISTS User " +
		" ( User_ID INTEGER not NULL AUTO_INCREMENT, " +
		" User_Name VARCHAR(50) not NULL, " +
		" User_Email VARCHAR(50) not NULL, " +
		" Sex VARCHAR(1), " +
		" PRIMARY KEY ( User_ID ))";
		statement.executeUpdate(sqlstmt2);
		
		resultSet = statement
		          .executeQuery("select * from Song, Artist_Info, User");

		      writeResultSet(resultSet);

		      // PreparedStatements can use variables and are more efficient


		/*  test 2 */
		      preparedStatement = connect
		          .prepareStatement("insert into  Song values (?, ?, ?)");
		      preparedStatement.setString(1, "0");
		      preparedStatement.setString(2, "Song1");
		      preparedStatement.setString(3, "1000");
		      preparedStatement.executeUpdate();
		      
		      preparedStatement = connect
			          .prepareStatement("insert into  Artist_Info values (?, ?, ?)");
			      preparedStatement.setString(1, "1000");
			      preparedStatement.setString(2, "Artist1");
			      preparedStatement.setString(3, "Artist1@email.com");
			      preparedStatement.executeUpdate();

			  preparedStatement = connect
				          .prepareStatement("insert into  User values (?, ?, ?, ?)");
				      preparedStatement.setString(1, "2000");
				      preparedStatement.setString(2, "User1");
				      preparedStatement.setString(3, "Usert1@email.com");
				      preparedStatement.setString(4, "M");

				      preparedStatement.executeUpdate();
		      
		      resultSet = statement
		          .executeQuery("select * from Song, Artist_Info, User");

		      writeResultSet(resultSet);
				
				
		
		
		
		
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
	
	
//	private void writeMetaData(ResultSet resultSet) throws SQLException {
//	    //   Now get some metadata from the database
//	    // Result set get the result of the SQL query
//	    
//	    System.out.println("The columns in the table are: ");
//	    
//	    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
//	    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
//	      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
//	    }
//	  }

	  private static void writeResultSet(ResultSet resultSet) throws SQLException {
	    // ResultSet is initially before the first data set
	  //  System.out.println("print result from a table..");
	    while (resultSet.next()) {
	      // It is possible to get the columns via name
	      // also possible to get the columns via the column number
	      // which starts at 1
	      // e.g. resultSet.getSTring(2);
	      String song_name = resultSet.getString("Song_Name");
	      String song_id = resultSet.getString("Song_ID");
	      String artist_id = resultSet.getString("Artist_ID");
	      
	      String artist_id2 = resultSet.getString("Artist_ID");
	      String artist_name = resultSet.getString("Artist_Name");
	      String artist_email = resultSet.getString("Artist_email");
	      
	      String user_id = resultSet.getString("User_ID");
	      String user_name = resultSet.getString("User_Name");
	      String user_email = resultSet.getString("User_Email");
	      String sex = resultSet.getString("Sex");

	      System.out.println("Song_Name: " + song_name);
	      System.out.println("Song_ID: " + song_id);
	      System.out.println("Artist_ID: " + artist_id);
	      
	      System.out.println("Artist_ID: " + artist_id2);
	      System.out.println("Artist_Name: " + artist_name);
	      System.out.println("Artist_email: " + artist_email);
	      
	      System.out.println("User_ID: " + user_id);
	      System.out.println("User_Name: " + user_name);
	      System.out.println("User_Email: " + user_email);
	      System.out.println("Sex: " + sex);

	      System.out.println("");
	    }
	  }

//	  // You need to close the resultSet
//	  private static void close() {
//	    try {
//	      if (resultSet != null) {
//	        resultSet.close();
//	      }
//
//	      if (statement != null) {
//	        statement.close();
//	      }
//
//	      if (connect != null) {
//	        connect.close();
//	      }
//	    } catch (Exception e) {
//
//	    }
//	  }
}
